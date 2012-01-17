package actionbazaar.buslogic;
import javax.ejb.ApplicationException;
public class BillingException extends RuntimeException {

    public BillingException() {}
    public BillingException(String msg) { super(msg); }
    public BillingException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public BillingException(Throwable cause) {
        super(cause);
    }	
}
