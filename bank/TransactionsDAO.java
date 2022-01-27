
package mx.com.gm.bank;

import java.util.List;

public interface TransactionsDAO {
    
   public void SetTransaction(int CustomerId, long AccountNumber, long Amount, String TransactionType);
   public List<Transactions> getTransactionReport(int CustomerId);
    
}
