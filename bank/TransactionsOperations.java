package mx.com.gm.bank;

import java.util.*;

public class TransactionsOperations implements TransactionsDAO{

    private List<Transactions> transactions;
    private Transactions transaction;
    
    public TransactionsOperations(){
        transactions = new ArrayList<>();
    }
    
    public void SetTransaction(int CustomerId, long AccountNumber, long Amount, String TransactionType) {
        transaction = new Transactions(CustomerId, AccountNumber, Amount, TransactionType);
        transactions.add(transaction);
    }
    
        public List<Transactions> getTransactionReport(int CustomerId) {
            List<Transactions> CustomerTransactions = new ArrayList<>();
            
            transactions.forEach(Trans -> {
            if (Trans.getCustomerId() == CustomerId) {
                System.out.println("\nDate:" + Trans.getDate() + " Account Number:" + Trans.getAccountNumber() + " Amount:" + Trans.getAmount() + " Transaction Type:" + Trans.getTransactionType());
                CustomerTransactions.add(Trans);
            }
        });
            
        return CustomerTransactions;
    }
    
    
}
