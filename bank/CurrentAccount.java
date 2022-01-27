package mx.com.gm.bank;

public class CurrentAccount extends Account {

    private String AccountType;
    private long Balance;

    public CurrentAccount(int AccountId, int CustomerId, Long AccountN) {
        super(AccountId, CustomerId, AccountN);
        this.AccountType = "CurrentAccount";
        this.Balance = 1000;
    }

    @Override
    public String getAccountsType() {
        return this.AccountType;
    }

    @Override
    public long getBalance() {
        return this.Balance;
    }

    @Override
    public void setBalance(long Balance) {
        this.Balance = Balance;
    }

}
