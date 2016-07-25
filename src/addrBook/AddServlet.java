package addrBook;

/*
 * Author Andre Tertzakian
 * November, 2013
 */

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddServlet() {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("AddressBook.jsp");

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNum = request.getParameter("phoneNum");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		boolean hasErrors = false;
		// Debug
		// System.out.println(firstName);
		// System.out.println(lastName);
		// System.out.println(phoneNum);
		// System.out.println(email);
		// System.out.println(address);
		// System.out.println(gender);

		if(firstName == null || firstName.equals("")) {
			String fnErr = "Do you have a first name?";
			request.setAttribute("fnErr", fnErr);
			hasErrors = true;
		}else {
			request.setAttribute("fn", firstName);
		}
		
		if(lastName == null || lastName.equals("")) {
			String lnErr = "Do you have a last name?";
			request.setAttribute("lnErr", lnErr);
			hasErrors = true;
		}else {
			request.setAttribute("ln", lastName);
		}
		if(phoneNum == null || phoneNum.equals("")) {
			String phErr = "Do you own a phone?";
			request.setAttribute("phErr", phErr);
			hasErrors = true;
		}else {
			request.setAttribute("ph", phoneNum);
		}
		if(address == null || address.equals("")) {
			String adErr = "Are you homeless?";
			request.setAttribute("adErr", adErr);
			hasErrors = true;
		}else {
			request.setAttribute("ad", address);
		}
		if(email == null || email.equals("")) {
			String emErr = "Do you still send your mail via post?";
			request.setAttribute("emErr", emErr);
			hasErrors = true;
		}else {
			request.setAttribute("em",	email);
		}
	
		if(gender == null || gender.equals("")) {
			String gdErr = "Are you human?";
			request.setAttribute("gdErr", gdErr);
			hasErrors = true;
		}else {
			request.setAttribute("gd", gender);
		}
		
		if(hasErrors) {
			rd = request.getRequestDispatcher("Add.jsp");
			rd.forward(request, response);
			return;
		}
		
		// Option 1
		// AddressBookRecord abr = new AddressBookRecord();
		// abr.setFirstName(firstName);
		// abr.setLastName(lastName);
		// abr.setPhoneNum(phoneNum);
		// abr.setEmail(email);
		// abr.setAddress(address);
		// abr.setGender(gender);

		HttpSession session = request.getSession();
		AddressBookRecord abr = new AddressBookRecord(firstName, lastName, phoneNum, email, gender, address);
		ArrayList<AddressBookRecord> addressBook = (ArrayList<AddressBookRecord>) session.getAttribute("AddressBook");
		if(addressBook == null) {
			addressBook = new ArrayList<AddressBookRecord>();
		}
		addressBook.add(abr);


		session.setAttribute("AddressBook", addressBook);
		rd.forward(request, response);
	}

}
