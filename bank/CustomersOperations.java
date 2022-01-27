package mx.com.gm.bank;
import java.util.*;

public class CustomersOperations implements CustomersDAO{
    Scanner sc = new Scanner(System.in);
    
    private List<Customers> customers;
    private Customers customer;
    
    public CustomersOperations(){
        customers = new ArrayList<>();
    }
    
    public void SetCustomer() {
        System.out.println("Name:");
        String Name = sc.nextLine();                

        System.out.println("Password:");
        String Pass = sc.nextLine();

        System.out.println("MobileNo:");
        String MobNo = sc.nextLine();

        System.out.println("Email:");
        String Email = sc.nextLine();

        customer = new Customers(customers.size(), Name, Pass, MobNo, Email);
        customers.add(customer);
        System.out.println("Register done");
    }
    
    public List<Customers> GetCustomers() {
        return customers;
    }
    
    public Customers getCustomersByName(String CustomerName){ 
        customer=null;
        customers.forEach(Cust->{
            if(CustomerName.equals(Cust.getName())){
                customer = Cust;                
            }
        });
        return customer;
    }
    
    public Customers getCustomersById(int CustomerId){
        return customers.get(CustomerId);
    }
    
 public void updateCustomer(int CustomerId) {
        System.out.println("Name:");
        String Name = sc.nextLine();
        customer.setName(Name);

        System.out.println("Password:");
        String Pass = sc.nextLine();
        customer.setPassword(Pass);

        System.out.println("MobileNo:");
        String MobNo = sc.nextLine();
        customer.setMobileNo(MobNo);

        System.out.println("Email:");
        String Email = sc.nextLine();
        customer.SetEmail(Email);

        customers.set(CustomerId, customer);

        System.out.println("Update done");
    }


}
