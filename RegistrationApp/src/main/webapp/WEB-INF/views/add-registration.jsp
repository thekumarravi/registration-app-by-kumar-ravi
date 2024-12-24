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
     <h2> Add registration..</h2>
     <form action="addReg" method="post">
        <pre>
          Name : <input type="text" name="Name" required/>
        Course : <input type="text" name="Course" required/>
          Email : <input type="text" name="Email"/>
          Mobile : <input type="text" name="Mobile"/>
          <input type="submit" value="save"/>
        </pre>
          
     </form>
    
         
        
</body>
</html>