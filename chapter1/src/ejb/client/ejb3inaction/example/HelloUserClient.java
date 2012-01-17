package ejb3inaction.example;

import javax.ejb.EJB;

public class HelloUserClient {
      @EJB
        private static HelloUser helloUser;

    	public  static void main(String[] args) {
     
         
             helloUser.sayHello("Curious George");
             System.out.println("Invoked EJB successfully .. see server console for output");     
        }
}
