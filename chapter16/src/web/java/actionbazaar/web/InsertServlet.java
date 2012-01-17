package actionbazaar.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import actionbazaar.persistence.*;
import actionbazaar.web.*;
import javax.naming.*;
import javax.transaction.*;
import actionbazaar.buslogic.PlaceBid;
import actionbazaar.persistence.Bid;
import javax.ejb.EJB;

public class InsertServlet extends HttpServlet {
@EJB PlaceBid placeBid; 
 
    
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doGet Executed");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long itemId;
        String userId = "";
        Double bidPrice = new Double(0);
        
       
        itemId =  Long.valueOf(request.getParameter("itemId"));

        userId = request.getParameter("userId");
        bidPrice = Double.valueOf(request.getParameter("bidPrice"));
        try {
            System.out.println("itemId:" + itemId);
            System.out.println("userId:" + userId);
            System.out.println("bidPrice:" + bidPrice);

            Long bidId = placeBid.addBid(userId, itemId, bidPrice);  
            System.out.println("Bid Persisted successfully .."+bidId);
            request.setAttribute("bidId",bidId);  

             this.getServletContext().getRequestDispatcher("/jsp/success.jsp")
                    .forward(request, response);
        } catch (Exception e) {
          
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            this.getServletContext().getRequestDispatcher("/jsp/error.jsp")
                    .forward(request, response);
        }

    }
}