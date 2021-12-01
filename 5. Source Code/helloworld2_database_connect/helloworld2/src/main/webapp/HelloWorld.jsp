<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Test Mybatis</title>
  </head>
  <body>

    <h2>Test Iterable for Database Result from Action</h2>
    <table border="1"> 
    	<tr>
    		<th>ID</th>
    		<th>Name</th>
    		<th>Email</th>
    		<th>Phone</th>
    	</tr>
	   	<s:iterator value="listStudents" var="e">
		   	<tr>
		   		<td>${e.id}</td>
		   		<td>${e.name}</td>
		   		<td>${e.email}</td>
		   		<td>${e.phone}</td>
		   	 </tr>
	    </s:iterator>
    </table>
  </body>
</html>
