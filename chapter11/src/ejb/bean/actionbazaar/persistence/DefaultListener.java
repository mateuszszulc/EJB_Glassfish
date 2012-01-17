package actionbazaar.persistence;

import javax.persistence.*;



public class DefaultListener {
    public DefaultListener() {
    }
        @PostPersist 
        public  void notification(Object entity) {
            System.out.println("Default Listener invoked ..");
            //implement your logic 
	}

}
