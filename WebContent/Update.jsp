<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="addrBook.Constants"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="addrBook.AddressBookRecord"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address Book</title>
</head>
<%
	ArrayList<AddressBookRecord> ab = (ArrayList<AddressBookRecord>) session.getAttribute(Constants.ADDRESS_BOOK);
    String iString = request.getParameter("updateIndex");
    if(iString == null){
    	iString = (String)request.getAttribute("iString");
    }
%>
<%String fnErr = (String)request.getAttribute("fnErr"); %>
<%String lnErr = (String)request.getAttribute("lnErr"); %>
<%String phErr = (String)request.getAttribute("phErr"); %>
<%String adErr = (String)request.getAttribute("adErr"); %>
<%String emErr = (String)request.getAttribute("emErr"); %>
<%String gdErr = (String)request.getAttribute("gdErr"); %>
<body>
	<a href="/AddressBook/">Back</a>
	<form action="/AddressBook/UpdateServlet" method="post">
	<input type="hidden" name="iString"  value="<%=iString%>"/>

		<table>
			<tr>
				<td>
					First Name
				</td>
				<td>
					<input type="text" name="firstName" value="<%=ab.get(Integer.parseInt(iString)).getFirstName() %>"/>
				</td>
				<td>
					<b><font size="5" color="red"><%=fnErr != null ? fnErr : "" %></font></b>
				</td>
				<td>
					Last Name
				</td>
				<td>
					<input type="text" name="lastName" value="<%=ab.get(Integer.parseInt(iString)).getLastName() %>"/>
					
				</td>
				<td>
					<b><font size="5" color="red"><%=lnErr != null ? lnErr : "" %></font></b>
				</td>
			</tr>
			<tr>
				<td>
					Phone Number
				</td>
				<td>
					<input type="text" name="phoneNum" value="<%=ab.get(Integer.parseInt(iString)).getPhoneNum() %>"/>
				</td>
				<td>
					<b><font size="5" color="red"><%=phErr != null ? phErr : "" %></font></b>
				</td>
			</tr>
			<tr>
				<td>
					eMail Address
				</td>
				<td>
					<input type="text" name="email" value="<%=ab.get(Integer.parseInt(iString)).getEmail() %>"/>
				</td>
				<td>
					<b><font size="5" color="red"><%=emErr != null ? emErr : "" %></font></b>
				</td>
			</tr>
			<tr>
				<td>
					Home Address
				</td>
				<td>
					<input type="text" name="address" value="<%=ab.get(Integer.parseInt(iString)).getAddress() %>"/>
				</td>
				<td>
					<b><font size="5" color="red"><%=adErr != null ? adErr : "" %></font></b>
				</td>
			</tr>
			<tr>
				<td>
					Gender
				</td>
				<td>
					 <input type="radio" name="gender" value="Male"<%=ab.get(Integer.parseInt(iString)).isMale() ? "checked":"" %>/>Male
					 <input type="radio" name="gender" value="Female" <%=ab.get(Integer.parseInt(iString)).isFemale() ? "checked":"" %>/>Female
				</td>
				<td>
					<b><font size="5" color="red"><%=gdErr != null ? gdErr : "" %></font></b>
				</td>
			</tr>
		</table>
		<input type="submit"/> 
	</form>
</body>
</html>