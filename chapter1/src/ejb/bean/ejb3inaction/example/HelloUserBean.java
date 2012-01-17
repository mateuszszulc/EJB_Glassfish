package ejb3inaction.example;
import javax.ejb.Stateless;
@Stateless                                                          
public class HelloUserBean implements HelloUser {                   
    public void sayHello(String name) {
        System.out.println("Hello " + name + " welcome to EJB 3 In Action!");
    }
}
