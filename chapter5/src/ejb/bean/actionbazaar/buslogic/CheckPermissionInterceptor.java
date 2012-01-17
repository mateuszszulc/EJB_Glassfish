package actionbazaar.buslogic;

import javax.annotation.Resource;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class CheckPermissionInterceptor {
    @Resource
    private javax.ejb.SessionContext ctx;


    @AroundInvoke
    public Object checkUserRole(InvocationContext ic) throws Exception {
        System.out.println("*** CheckPermission Interceptor invoked for "
                + ic.getTarget() + " ***");
        if (!ctx.isCallerInRole("admin")) {
            throw new SecurityException("User: '"
                    + ctx.getCallerPrincipal().getName()
                    + "' does not have permissions for method "
                    + ic.getMethod());
        }
        return ic.proceed();
    }
}