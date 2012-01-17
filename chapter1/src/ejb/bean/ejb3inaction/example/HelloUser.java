package ejb3inaction.example;
import javax.ejb.Remote;
@Remote
public interface HelloUser {                                        
    public void sayHello(String name);
}
