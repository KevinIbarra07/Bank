package mx.com.gm.bank;
import java.util.*;
public interface CustomersDAO {

    public void SetCustomer();
    public List<Customers> GetCustomers();
    public Customers getCustomersByName(String CustomerName);
    public Customers getCustomersById(int CustomerName);
    public void updateCustomer(int CustomerId);
    
}
