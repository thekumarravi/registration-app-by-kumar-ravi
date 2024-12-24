<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.ResultSet" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <table border='1'>
      <tr>
          <th>Name</th>
           <th>Email</th>
            <th>Course</th>
             <th>Mobile</th>
             <th>Delete</th>
             <th>Update</th>
        </tr>
        
        <%
        ResultSet result = (ResultSet)request.getAttribute("result");
        while(result.next()){%>
        <tr>
            <td><%=result.getString(1)%></td>
            <td><%=result.getString(2)%></td>
            <td><%=result.getString(3)%></td>
            <td><%=result.getString(4)%></td>
             <td><a href="deleteRegistration?email=<%=result.getString(2)%>">Delete</a></td>
             <td><a href="UpdateRegistration?email=<%=result.getString(2)%>&mobile=<%=result.getString(4)%>">Update</a></td>
             
        </tr>
        
        
        
        
        
       <%} %> 
      </table>

</body>
</html>