package actionbazaar.persistence;
import javax.persistence.*;



public class ItemVerifier{

public static double MIN_PRICE = new Double(50); 

    public ItemVerifier() {
    }
        @PrePersist 
        public  void newItemVerifier(Item item){
                     System.out.println("Item Price:"+item.getInitialPrice());
                      if (item.getInitialPrice()<MIN_PRICE)
                         throw new ItemException("Item Price is lower than Minimum Price");
		}


}
