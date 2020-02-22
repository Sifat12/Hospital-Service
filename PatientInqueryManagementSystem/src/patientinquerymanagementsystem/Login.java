
package patientinquerymanagementsystem;

/**
 *
 * @author Tech Land
 */
public class Login {
    private String username;
    private String date;
    
   public Login(String user,String dt)
   {
       this.username = user;
       this.date  = dt;
   }
   public String getUsername()
   {
       return username;
   }
   public String getDate()
   {
       return date;
   }
}
