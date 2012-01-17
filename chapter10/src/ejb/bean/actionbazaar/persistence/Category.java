package actionbazaar.persistence;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.Set;

import javax.persistence.*;
import javax.persistence.FetchType.*;



@Entity
@EntityListeners({actionbazaar.persistence.CategoryNotifier.class})
@NamedQueries({
@NamedQuery(
name="findCategoryByName",
query="SELECT c FROM Category c WHERE c.categoryName LIKE :categoryName order by c.categoryId"
),
@NamedQuery(
name="findCategoryByUser",
query="SELECT c FROM Category AS c JOIN c.user AS u WHERE u.userId = ?1"
)})
@Table(name="CATEGORIES")
public class Category implements Serializable {
    private Long categoryId;
    private String categoryName;
    private Timestamp createDate;
    private Set<Item> items;
    private User user;
    private Category category;
    private Set<Category> categorySet;

    public Category() {
    }

    public Category(Long categoryId) {
        this.categoryId = categoryId;
    }
     
    @SequenceGenerator(name="CATEGORY_SEQ_GEN", 
    sequenceName="CATEGORY_SEQ", 
                         initialValue=1, allocationSize=1)


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="CATEGORY_SEQ_GEN")
    @Column(name="CATEGORY_ID", nullable=false)
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name="CATEGORY_NAME")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    @Column(name="CREATE_DATE", insertable=false, updatable=false)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="CATEGORIES_ITEMS",
    joinColumns=
    @JoinColumn(name="CATEGORY_ID", referencedColumnName="CATEGORY_ID"),
    inverseJoinColumns=
     @JoinColumn(name="ITEM_ID", referencedColumnName="ITEM_ID"))
    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Item addItem(Item item) {
        getItems().add(item);
        item.addCategory(this);
        return item;
    }

    public Item removeItem(Item item) {
        getItems().remove(item);
        item.setCategory(null);
        return item;
    }

    @ManyToOne
    @JoinColumn(name="CREATED_BY", referencedColumnName="USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name="PARENT_ID", referencedColumnName="CATEGORY_ID")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToMany(mappedBy="category")
    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }

    public Category addCategory(Category category) {
        getCategorySet().add(category);
       // category.setCategory(this);
        return category;
    }

    public Category removeCategory(Category category) {
        getCategorySet().remove(category);
        category.setCategory(null);
        return category;
    }
}
