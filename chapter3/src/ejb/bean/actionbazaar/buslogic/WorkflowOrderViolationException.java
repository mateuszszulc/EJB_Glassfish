package actionbazaar.buslogic;

public class WorkflowOrderViolationException extends RuntimeException {

    public WorkflowOrderViolationException() {
    }


    public WorkflowOrderViolationException(String msg) {
        super(msg);
    }


    public WorkflowOrderViolationException(String msg, Throwable cause) {
        super(msg, cause);
    }


    public WorkflowOrderViolationException(Throwable cause) {
        super(cause);
    }
}
