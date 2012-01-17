package actionbazaar.buslogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import actionbazaar.persistence.Bidder;
import actionbazaar.persistence.BidderStatus;
import actionbazaar.persistence.Category;
import actionbazaar.persistence.Item;
import actionbazaar.persistence.User;

@Stateless(name = "BazaarAdmin")
public class BazaarAdminBean implements BazaarAdmin {
    @PersistenceContext(name = "actionBazaar")
    private EntityManager em;


    /** **************************************************************** */
    /* Uncomment if you want to use application-managed entity manager */
    /* Injects Persist Unit */
    /** **************************************************************** */

    /*
     * @PersistenceUnit(name="actionBazaar") private EntityManagerFactory emf;
     */

    public BazaarAdminBean() {
    }


    /** **************************************************************** */
    /* Uncomment if you want to use application-managed entity manager */
    /* Creates Application Managed Entity Manager */
    /** **************************************************************** */
    /*
     * @PostConstruct public void initialize() { em = emf.createEntityManager(); }
     */

    public Category createCategory(String name, String userId) {
        Category category = new Category();
        category.setCategoryName(name);
        User user = em.find(User.class, userId);
        System.out.println(user.getFirstName());
        category.setUser(user);
        user.addCategory(category);
        return category;
    }


    public Item createItem(String name, String userId, Long categoryId,
            Double initialPrice) {
        Item item = new Item();
        item.setItemName(name);
        item.setInitialPrice(initialPrice);
        Category category = em.find(Category.class, categoryId);
        item.addCategory(category);
        return item;
    }


    public Category mergeCategory(Category category) {
        em.merge(category);
        return category;
    }


    public Bidder createBidder(Bidder bidder) {
        bidder.setBidderStatus(BidderStatus.NEW);
        em.persist(bidder);
        return bidder;

    }


    public Category refreshCategory(Category category) {
        em.refresh(category);
        return category;
    }


    public void removeCategory(Category category) {
        em.remove(em.merge(category));
    }

    /** **************************************************************** */
    /* Uncomment if you want to use application-managed entity manager */
    /* Closes Application Managed Entity Manager in Post Destroy */
    /** **************************************************************** */

    /*
     * @PreDestroy public void cleanup() { if (em.isOpen()) em.close(); }
     */
}
