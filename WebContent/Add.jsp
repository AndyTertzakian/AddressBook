<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address Book</title>
</head>
<%String fnErr = (String) request.getAttribute("fnErr");%>
<%String lnErr = (String) request.getAttribute("lnErr");%>
<%String phErr = (String) request.getAttribute("phErr");%>
<%String adErr = (String) request.getAttribute("adErr");%>
<%String emErr = (String) request.getAttribute("emErr");%>
<%String gdErr = (String) request.getAttribute("gdErr");%>
<%String fn = (String) request.getAttribute("fn");%>
<%String ln = (String) request.getAttribute("ln");%>
<%String ph = (String) request.getAttribute("ph");%>
<%String ad = (String) request.getAttribute("ad");%>
<%String em = (String) request.getAttribute("em");%>
<%String gd = (String) request.getAttribute("gd");%>


<body>
	<a href="/AddressBook/">Back</a>
	<form action="/AddressBook/AddServlet" method="post">
		<table>
			<tr>
				<td>
					First Name
				</td>
				<td>
					<input type="text" name="firstName" value="<%=fn != null ? fn : "" %>"/>
				</td>
				<td>
					<b><font size="5" color="red"><%=fnErr != null ? fnErr : "" %></font></b>
				</td>
				<td>
					Last Name
				</td>
				<td>
					<input type="text" name="lastName" value="<%=ln != null ? ln : "" %>"/>
					
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
					<input type="text" name="phoneNum" value="<%=ph != null ? ph : "" %>"/>
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
					<input type="text" name="email" value="<%=em != null ? em : "" %>"/>
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
					<input type="text" name="address" value="<%=ad != null ? ad : "" %>"/>
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
					 <input type="radio" name="gender" value="Male" <%=gd != null && gd.equals("Male") ? "checked" : ""%>/>Male
					 <input type="radio" name="gender" value="Female" <%=gd != null && gd.equals("Female") ? "checked" : ""%>/>Female
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