package mx.com.gm.bank;

public abstract class Account {

    private int AccountId;
    private int CustomerId;
    private long AccountNumber;    

    public Account(int AccountId,int CustomerId, Long AccountN) {
        this.AccountId = AccountId;
        this.CustomerId = CustomerId;
        this.AccountNumber = AccountN;
        
    }

    public abstract String getAccountsType();
    
    public abstract long getBalance();
    public abstract void setBalance(long Balance);

    public long getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(long AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int AccountId) {
        this.AccountId = AccountId;
    }

}
