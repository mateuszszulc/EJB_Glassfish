package actionbazaar.persistence.eao;

public class JPAEAOFactory extends EAOFactory {
  public void JPAEAOFactory()
  {
  }
  public ItemEAO getItemEAO()
  {
    return (new ItemEAOImpl());
  }
  public BidEAO getBidEAO() 
  {
     return (new BidEAOImpl());

  }

}
