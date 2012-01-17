package actionbazaar.persistence;
import java.io.Serializable;

import java.sql.Timestamp;

public class CategoryPK implements Serializable {
public CategoryPK() {
    }
String categoryName;
Timestamp createDate;

public boolean equals(Object other)
  {
    if (other instanceof CategoryPK)
    {
      final CategoryPK otherCategoryPK = (CategoryPK)other;
      boolean areEqual = (otherCategoryPK.equals(categoryName) && 
otherCategoryPK.createDate.equals(createDate));

      return areEqual;
    }

    return false;
  }

 public int hashCode()
  {
    // Add custom hashCode() implementation here
    return super.hashCode();
  }


 }
