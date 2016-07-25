<!-- 
/*
 * Author Andre Tertzakian
 * November, 2013
 */
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Address Book</title>
</head>
<body>
<a href="/AddressBook/">Back</a><hr/>
<form action="/AddressBook/SearchServlet" method="get">
Search Address Book:<input placeholder="type here" type="text" name="Search"></input>
<input type="submit" value="Search"></input>
</form>
</body>
</html>