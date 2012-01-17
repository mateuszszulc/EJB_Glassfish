package actionbazaar.persistence;
import javax.persistence.*;



public class CategoryNotifier{

    public CategoryNotifier() {
    }
        @PostPersist 
        public  void newCategoryNotification(Category category){                        
				Notification.sendEmailAlert(category.getCategoryId(), category.getCategoryName(),
                             						 category.getUser().getFirstName(), category.getUser().getLastName());
		}
       
}
