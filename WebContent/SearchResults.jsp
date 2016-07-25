<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="addrBook.AddressBookRecord"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<%ArrayList<AddressBookRecord> sr = (ArrayList<AddressBookRecord>) session.getAttribute("SearchResults"); %>
<body>
	<a href="/AddressBook/">Back</a> <br>
	
	<%if(sr.isEmpty()) { %>
		Sorry, no results found...
	<%} else{%>
	<form action="/AddressBook/DeleteServlet" method="post">
		<input type="hidden" name="deleteOption" value="two"/>
		<table border="1">
			<thead>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Phone Number</td>
				<td>eMail Address</td>
				<td>Home Address</td>
				<td>Gender</td>
				<td>Delete</td>
			</thead>	
			<%for(int i = 0; i < sr.size(); i++){ 
				AddressBookRecord tempSR = sr.get(i); %>
				<tr>
				<td><%=tempSR.getFirstName() %></td>
				<td><%=tempSR.getLastName() %></td>
				<td><%=tempSR.getPhoneNum() %></td>
				<td><%=tempSR.getEmail() %></td>
				<td><%=tempSR.getAddress() %></td>
				<td><%=tempSR.getGender() %></td>
				<td><input type="checkbox" name="delete" value="<%=i%>"></input></td>
				</tr>
			<%}%>
		</table>
		<input type="submit" value="Delete"></input>
		</form>
	<%}%>
</body>
</html>