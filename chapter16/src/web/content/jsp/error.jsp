<%@ page import="java.util.*" %>
<html>
<head>
  <title>EJB 3 In Action: Chapter 16 Code Examples </title>
  <LINK href="blaf.css" type=text/css rel=stylesheet>
</head>
<body>
  <h1> EJB 3 In Action: Chapter 16 Code Examples</h1>
  [<a href="index.html">  Home Page </A>] <br> <br>
  <h3>Error Occurred</h3>
  <%
  try
  {
    String error =(String) (request.getAttribute("error"));
    out.println("<pre>Message:"+error+"</pre><br>");
  }
  catch(Throwable ex)
  {
    ex.printStackTrace();
  }
  %>       
</body>
</html>
