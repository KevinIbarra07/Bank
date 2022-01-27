package mx.com.gm.bank;

public class MortgaugeAccount extends Account {

    private String AccountType;
    private long Balance;

    public MortgaugeAccount(int AccountId, int CustomerId, Long AccountN) {
        super(AccountId, CustomerId, AccountN);
        this.AccountType = "MortgaugeAccount";
        this.Balance = -10000;
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
