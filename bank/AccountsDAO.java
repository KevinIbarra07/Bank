package mx.com.gm.bank;
import java.util.List;
public interface AccountsDAO {

public void setAccount(int CustomerId);
public List<Account> getAccounts();
public List<Account> getAccountsByCustomer(int CustomerId);
public Account getAccountByAccountNumber(long AccountNumber);

}
