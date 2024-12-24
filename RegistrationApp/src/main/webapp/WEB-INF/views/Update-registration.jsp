<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h2>Update registration..</h2>
     <form action="UpdateRegistration" method="post">
        <pre>
          Email : <input type="text" name="email"value="<%=request.getAttribute("email")%>"/>
          Mobile : <input type="text" name="mobile"value="<%=request.getAttribute("mobile")%>"/>
          <input type="submit" value="Update"/>
        </pre>
          
     </form>
    
         
       
</body>
</html>