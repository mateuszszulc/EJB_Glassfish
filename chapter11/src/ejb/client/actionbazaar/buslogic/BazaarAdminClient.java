package actionbazaar.buslogic;
import javax.naming.Context;
import javax.naming.InitialContext;
import actionbazaar.persistence.*;
import javax.ejb.EJB;


public class BazaarAdminClient {
@EJB
private static BazaarAdmin bazaarAdmin;
    public static void main(String [] args) {
                                       
           
            
            Category category = bazaarAdmin.createCategory("test category","idiot2");
            
            
            
            System.out.println("Category created with Id:"+category.getCategoryId());
    }

   }
