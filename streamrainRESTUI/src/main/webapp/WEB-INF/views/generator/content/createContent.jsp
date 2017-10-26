<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html xmlns="http://www.w3.org/1999/xhtml">
 
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>Create Content</title>
		<style type="text/css">
			body {
				font-family: verdana, sans-serif;			
			}
			
			span.fielderror {
				color: red;
			}
			
		</style>	
	</head>
	 
	<body>			
		<h1>Create Content</h1>
		<c:if test="${not empty message}">
			<td style="font-style: italic; color: green;">${message}</td>
		</c:if>
		<c:if test="${not empty error}">
			<td style="font-style: italic; color: red;">${error}</td>
		</c:if>
		<c:url value="createContentProcess" var="content"/>			
		<form:form method="post" action="${content}" enctype="multipart/form-data" commandName="contentDto">
			<table>
				<tbody>
					<tr>
						<td>Name:</td>
						<td><form:input path="name" /></td>
						<td><form:errors path="name" cssClass="fielderror"/></td>
					</tr>
					<tr>
						<td>Description:</td>
						<td><form:textarea path="description" /></td>
						<td><form:errors path="description" cssClass="fielderror"/></td>
					</tr>
					<tr>
						<td>Type:</td>
						<td><form:input path="type" /></td>
						<td><form:errors path="type" cssClass="fielderror"/></td>
					</tr>
					<tr>
			           <td>Selecciona fichero:</td>
			           <td><input type="file" name="picture"></td>
			        </tr>
					<tr>
						<td colspan="3"><input type="submit" value="Create" /></td>
					</tr>
					
				</tbody>
			</table>
		</form:form>    		
	</body>
</html>