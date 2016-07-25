<!-- 
/*
 * Author Andre Tertzakian
 * November, 2013
 */
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="addrBook.AddressBookRecord"%>
<%@ page import="addrBook.Constants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address Book</title>
</head>

<%
	ArrayList<AddressBookRecord> ab = (ArrayList<AddressBookRecord>) session.getAttribute(Constants.ADDRESS_BOOK);
%>

<body>
	<a href="/AddressBook/">Back</a>
	<form id="form" action="/AddressBook/DeleteServlet" method="post">
	<input type="hidden" name="deleteOption" value="one"/>
	<%if (ab != null && !ab.isEmpty()) {%>
		<table border="1">
			<thead>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Phone Number</td>
				<td>eMail Address</td>
				<td>Home Address</td>
				<td>Gender</td>
				<td>Delete</td>
				<td>Update</td>
			</thead>
		<% for(int i = ab.size()-1; i>=0 ; i--) {
			AddressBookRecord tempAB = ab.get(i);
		%>
			<tr>
				<td><%=tempAB.getFirstName() %></td>
				<td><%=tempAB.getLastName() %></td>
				<td><%=tempAB.getPhoneNum() %></td>
				<td><%=tempAB.getEmail() %></td>
				<td><%=tempAB.getAddress() %></td>
				<td><%=tempAB.getGender() %></td>
				<td><input type="checkbox" value="off" onclick="changeDeleteChkbox(this)" name="<%=i%>"></input></td>
				<td>
					<input type="hidden" id="updateIndex" name="updateIndex"/>
					<input type="button" value="Update" onclick="updateAddressBook(<%=i%>)">
				</td>
			</tr>
							
		<%} %>
		</table>
		<input id="formSubmit" type="submit" value="Delete"></input>
	<%} %>
	</form>
</body>

<script type="text/javascript">
function updateAddressBook(index){
	var form = document.getElementById('form');
	form.setAttribute('action', '/AddressBook/Update.jsp');
	
	var updateHidden = document.getElementById('updateIndex');
	updateHidden.setAttribute('value', index);
	
	form.submit();
}

function changeDeleteChkbox(obj){
	if(obj.value == 'off'){
		obj.value = 'on';
	} else {
		obj.value = 'off';
	}
	
}
</script>

</html>