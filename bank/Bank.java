package mx.com.gm.bank;

import java.util.*;

public class Bank {

    Scanner sc = new Scanner(System.in);

    private Customers customer;

    private Account account;

    private Transactions transaction;

    private CustomersOperations CustomDao;
    private AccountOperations AccDAO;
    private TransactionsOperations TransDAO;

    public Bank() {

        CustomDao = new CustomersOperations();
        AccDAO = new AccountOperations();
        TransDAO = new TransactionsOperations();

    }

    public void StartBankApplication() {

        boolean cont = true;
        int option;

        do {
            System.out.println("\nWelcome, Please select an option");
            System.out.println("1-Sing Up");
            System.out.println("2-Log in");
            System.out.println("3-Exit");
            System.out.println("4-All customer and account report");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    CustomDao.SetCustomer();
                    break;
                case 2:
                    Login();
                    break;
                case 3:
                    cont = false;
                    break;
                case 4:                    
                    ShowCustomers(CustomDao.GetCustomers(), AccDAO.getAccounts());
                    break;
                default:
                    System.out.println("Incorrect option selected");

            }

        } while (cont);

    }

    protected void Login() {

        System.out.println("Name:");
        String Name = sc.nextLine();

        customer = this.CustomDao.getCustomersByName(Name);

        if (customer != null) {
            System.out.println("Password:");
            String Pass = sc.nextLine();

            if (customer.getName().equals(Name) && customer.getPassword().equals(Pass)) {
                CustomerOperations(Name, customer.GetCustomerId());
            } else {
                System.out.println("Wrong password or Name, please try again");
            }
        } else {
            System.out.println("The user is not regitered");
        }

    }

    public void ShowCustomers(List<Customers> customers, List<Account> accounts) {
        customers.forEach(cust -> {
            System.out.println("\nId:" + cust.GetCustomerId() + " Name:" + cust.getName() + " Mobile:" + cust.getMobileNo() + " Email:" + cust.getEmail());
            accounts.forEach(Acc -> {
                if (cust.GetCustomerId() == Acc.getCustomerId()) {
                    System.out.println("Account:" + Acc.getAccountNumber() + " Type:" + Acc.getAccountsType() + " Balance:" + Acc.getBalance());
                }
            });
        });
    }

    private void CustomerOperations(String CustomerName, int CustomerId) {

        boolean cont = true;
        int option;
        do {
            System.out.println("\nWelcome " + CustomerName + ":" + CustomerId + ", Please select the operation you want perform");
            System.out.println("1-Create Account");
            System.out.println("2-Update Account");
            System.out.println("3-Tranfer");
            System.out.println("4-Deposit");
            System.out.println("5-Withdrawal");
            System.out.println("6-Balance Report");
            System.out.println("7-Transactions Report");
            System.out.println("8-Sing out");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    AccDAO.setAccount(CustomerId);
                    break;
                case 2:
                    CustomDao.updateCustomer(CustomerId);
                    break;
                case 3:
                    System.out.println("Please input the account from will perform the transfer:");
                    long TFromAccount = sc.nextLong();
                    Transfers(TFromAccount, CustomerId);
                    break;
                case 4:
                    Deposit(CustomerId);
                    break;
                case 5:
                    Withdrawal(CustomerId);
                    break;
                case 6:
                    BalanceReport(CustomerId);
                    break;
                case 7:
                    //getTransactionReport(CustomerId);
                    TransDAO.getTransactionReport(CustomerId);
                    break;
                case 8:
                    System.out.println("Come back soon.");
                    cont = false;
                    break;
                default:
                    System.out.println("Incorrect option selected");

            }
        } while (cont);

        System.out.println("Welcome back " + CustomerName);

    }

    public void BalanceReport(int CustomerId) {

        customer = CustomDao.getCustomersById(CustomerId);
        //accounts = AccDAO.getAccountsByCustomer(CustomerId);

        System.out.println("\nId:" + customer.GetCustomerId() + " Name:" + customer.getName());

        AccDAO.getAccountsByCustomer(CustomerId).forEach(Acc -> {
            System.out.println("Account:" + Acc.getAccountNumber() + " Type:" + Acc.getAccountsType() + " Balance:" + Acc.getBalance());
        });

    }

    public void Transfers(long TFromAccount, int CustomerID) {

        Account customerAccount;

        customerAccount = AccDAO.getAccountByAccountNumber(TFromAccount);

        if (customerAccount != null || !customerAccount.getAccountsType().equals("MortgaugeAccount")) {
            System.out.println("Please input the amount");
            int Amount = sc.nextInt();

            if (customerAccount.getBalance() >= Amount) {
                System.out.println("Please input the account that will receive the transfer");
                long TAccount = sc.nextLong();

                account = AccDAO.getAccountByAccountNumber(TAccount);

                if (account != null || !account.getAccountsType().equals("MortgaugeAccount")) {
                    customerAccount.setBalance(customerAccount.getBalance() - Amount);                                                            
                    AccDAO.UpdateAccount(customerAccount, customerAccount.getAccountId());
                    TransDAO.SetTransaction(CustomerID, customerAccount.getAccountNumber(), Amount, "Sent Transfer");
                    System.out.println("Performed transfer" + customerAccount.getAccountNumber());                    

                    account.setBalance(account.getBalance() + Amount);                                        
                    AccDAO.UpdateAccount(account, account.getAccountId());
                    TransDAO.SetTransaction(account.getCustomerId(), account.getAccountNumber(), Amount, "Got Transfer");
                    System.out.println("Receive transfer" + account.getAccountNumber());                    
                } else {
                    System.out.println("The account that will receive the transfer does not exist");
                }
            } else {
                System.out.println("No enough budget in the account");
            }

        } else {
            System.out.println("The user's account does not exist");
        }

    }

    public void Withdrawal(int CustomerId) {
        System.out.println("Input the account");
        long WAccount = sc.nextLong();

        account = AccDAO.getAccountByAccountNumber(WAccount);

        if (account != null) {
            System.out.println("Input the amount:");
            int Amount = sc.nextInt();
            if (account.getCustomerId() == CustomerId && account.getBalance() >= Amount && !account.getAccountsType().equals("MortgaugeAccount")) {
                account.setBalance(account.getBalance() - Amount);
                AccDAO.UpdateAccount(account, account.getAccountId());
                //SetTransaction(CustomerId, WAccount, -Amount, "Withdrawal");//Create transaction
                TransDAO.SetTransaction(CustomerId, WAccount, Amount, "Withdrawal");
                System.out.println("Withdrawal performed successfully");
            }
        } else {
            System.out.println("The account does no exist");
        }

    }

    public void Deposit(int CustomerId) {
        System.out.println("Input the account to do the deposit");
        long DAccount = sc.nextLong();

        System.out.println("Input the amount:");
        int Amount = sc.nextInt();

        account = AccDAO.getAccountByAccountNumber(DAccount);

        if (account != null) {
            account.setBalance(account.getBalance() + Amount);
            //SetTransaction(CustomerId, DAccount, Amount, "Deposit");//Crear la transaccion
            TransDAO.SetTransaction(CustomerId, DAccount, Amount, "Deposit");

            AccDAO.UpdateAccount(account, account.getAccountId());

            System.out.println("Depisit performed successfully");
        } else {
            System.out.println("The account does no exist");
        }

    }

}
