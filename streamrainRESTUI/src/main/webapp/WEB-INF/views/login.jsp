<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Login User</title>
	</head>
	<body>
	   <h1>Login</h1>
	   <form:form id="loginForm" modelAttribute="login" action="loginProcess" method="post">
	      <table align="center">
	      <tbody>
	         <tr>
	            <td>User:</td>
	            <td><form:input path="username" name="username" id="username"  /></td>
	         </tr>
	         <tr>
	            <td>Password:</td>
	            <td><form:password path="password" name="password" id="password"  /></td>
	         </tr>
	         <tr>
                 <td></td>
                 <td align="left">
                     <form:button id="login" name="login">Login</form:button>
                 </td>
             </tr>
             <tr>
                <td align="right">
                	<a href="registerUser">Register</a>
                </td>
           	 </tr>
	         </tbody>
	      </table>
	  </form:form>
	  <table align="center">
          <tr>
              <td style="font-style: italic; color: red;">${message}</td>
          </tr>
      </table>
	</body>
</html>