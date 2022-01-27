package mx.com.gm.bank;

import java.util.*;

public class AccountOperations implements AccountsDAO {

    Scanner sc = new Scanner(System.in);

    private List<Account> accounts;
    private Account account;

    public AccountOperations() {
        accounts = new ArrayList<>();
    }

    public void setAccount(int CustomerId) {

        int option;

        System.out.println("Account Number:");
        long AN = sc.nextLong();

        System.out.println("\nPlease select the account type");
        System.out.println("1-Current Account");
        System.out.println("2-Saving Account");
        System.out.println("3-Mortgauge Account");
        option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                account = new CurrentAccount(accounts.size(), CustomerId, AN);
                break;
            case 2:
                account = new SavingAccount(accounts.size(), CustomerId, AN);
                break;
            case 3:
                account = new MortgaugeAccount(accounts.size(), CustomerId, AN);
                break;
            default:
                System.out.println("Incorrect option selected");

        }

        accounts.add(account);
        System.out.println("Account created successfully");
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    
    public Account getAccountByAccountNumber(long AccountNumber){
        account = null;
        
        accounts.forEach(Acc->{
            if(Acc.getAccountNumber()==AccountNumber){
                account = Acc;
            }
        });
        
        return account;
    }
    
    public void UpdateAccount(Account Account,int AccountID){
        accounts.set(AccountID, Account);
    }                

    public List<Account> getAccountsByCustomer(int CustomerId) {
        List<Account> CustomerAccount = new ArrayList<>();        
        accounts.forEach(Acc -> {
            if (CustomerId == Acc.getCustomerId()) {
                CustomerAccount.add(Acc);
            }
        });

        return CustomerAccount;

    }

}
