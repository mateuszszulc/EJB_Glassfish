<%@ page import="java.util.*" %>
<html>
<head>
  <title>EJB 3 In Action: Chapter 16 Code Examples</title>
  <LINK href="blaf.css" type=text/css rel=stylesheet>
</head>
<body>
  <h1> EJB 3 In Action: Chapter 16 Code Examples</h1>       
  [<a href="index.html">  Home Page </A>] <br> <br>
  <h3> Bid Successfully submitted</h3>
  <%
    try
    {
      	Long bidId = (Long ) request.getAttribute("bidId");
     	     out.println("<b>Bid Id:"+ bidId+"</b><br>");
    }
    catch(Throwable ex)
    {
      ex.printStackTrace();
    }
  %>            
</body>
</html>
