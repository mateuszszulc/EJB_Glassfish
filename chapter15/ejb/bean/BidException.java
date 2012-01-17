package actionbazaar.buslogic;
import javax.ejb.ApplicationException;
import javax.ejb.*;
@ApplicationException(rollback=true)
public class BidException extends RuntimeException {

    public BidException() {}
    public BidException(String msg) { super(msg); }
    public BidException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public BidException(Throwable cause) {
        super(cause);
    }	
}
