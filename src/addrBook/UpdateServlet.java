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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iString = request.getParameter("iString");
		HttpSession session = request.getSession();
		ArrayList<AddressBookRecord> ab  = (ArrayList<AddressBookRecord>) session.getAttribute(Constants.ADDRESS_BOOK);
		boolean hasErrors = false;
		
	    AddressBookRecord abr = ab.get(Integer.parseInt(iString));
		abr.setFirstName(request.getParameter("firstName"));
		abr.setLastName(request.getParameter("lastName"));
		abr.setAddress(request.getParameter("address"));
		abr.setEmail(request.getParameter("email"));
		abr.setGender(request.getParameter("gender"));
		abr.setPhoneNum(request.getParameter("phoneNum"));
		
		if(abr.getFirstName() != null && abr.getFirstName().equalsIgnoreCase("")) {
			String fnErr = "Did you forget your first name?";
			request.setAttribute("fnErr", fnErr);
			hasErrors = true;
		}
		if(abr.getLastName() != null && abr.getLastName().equalsIgnoreCase("")) {
			String lnErr = "Did you have a family?";
			request.setAttribute("lnErr", lnErr);
			hasErrors = true;
		}
		if(abr.getAddress() != null && abr.getAddress().equalsIgnoreCase("")) {
			String adErr = "Are you homeless?";
			request.setAttribute("adErr", adErr);
			hasErrors = true;
		}
		if(abr.getPhoneNum() != null && abr.getPhoneNum().equalsIgnoreCase("")) {
			String phErr = "Did you have a phone?";
			request.setAttribute("phErr", phErr);
			hasErrors = true;
		}
		if(abr.getEmail() != null && abr.getEmail().equalsIgnoreCase("")) {
			String emErr = "Did you have an email account?";
			request.setAttribute("emErr", emErr);
			hasErrors = true;
		}
		if(abr.getGender() != null && abr.getGender().equalsIgnoreCase("")) {
			String gdErr = "Did you have a body?";
			request.setAttribute("gdErr", gdErr);
			hasErrors = true;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("AddressBook.jsp");

		if(hasErrors) {
			request.setAttribute("iString", iString);
			rd = request.getRequestDispatcher("Update.jsp");
		}
		
		rd.forward(request, response);
	}

}
