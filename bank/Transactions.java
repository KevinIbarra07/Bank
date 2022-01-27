package mx.com.gm.bank;

import java.time.LocalDate;

public class Transactions {

    private int CustomerId;
    private long AccountNumber;
    private long Amount;
    private String TransactionType;
    private LocalDate Date;
    
    public Transactions(int CustomerId, long AccountNumber, long Amount, String TransactionType){
        this.CustomerId = CustomerId;
        this.AccountNumber = AccountNumber;
        this.Amount = Amount;
        this.Date = LocalDate.now();
        this.TransactionType = TransactionType;
        
    }
   
    public int getCustomerId() {
        return CustomerId;
    }
    
    public void setCustomerId(int CustomerId) {
        
        this.CustomerId = CustomerId;
    }
    public long getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(long AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public long getAmount() {
        return Amount;
    }

    public void setAmount(long Amount) {
        this.Amount = Amount;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String TransactionType) {
        this.TransactionType = TransactionType;
    }

    public LocalDate getDate() {
        return Date;
    }
    
}
