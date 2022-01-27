package mx.com.gm.bank;

public class Customers{
    
        private int CustomerId;
        private String Name;
        private String MobileNo;
        private String Email;
        private String Password;        
        private Account account;        

     public Customers(int CustomerId,String Name,String Password, String MobileNo, String email){
         super();
         this.CustomerId = CustomerId;
         this.Name = Name;
         this.Email = email;
         this.MobileNo = MobileNo;
         this.Password = Password;
     }          

     public String getEmail(){
         return Email;
     }
     
    public void SetEmail(String Email){
        this.Email = Email;
    } 
     
    public int GetCustomerId(){
        return CustomerId;
    }
    
    public void SetCustomerId(int CustomerId){
        this.CustomerId = CustomerId;
    }
     
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }   
    
    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String MobileNo) {
        this.MobileNo = MobileNo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
        
    
}
