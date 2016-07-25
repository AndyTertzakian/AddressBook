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

import org.apache.commons.lang3.StringUtils;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("Search");
		HttpSession session = request.getSession();
		ArrayList<AddressBookRecord> ab = (ArrayList<AddressBookRecord>) session.getAttribute(Constants.ADDRESS_BOOK);
		ArrayList<AddressBookRecord> searchResults = new ArrayList<AddressBookRecord>();
		if (ab != null) {
			for (int i = 0; i < ab.size(); i++) {
				AddressBookRecord addressBookRecord = ab.get(i);

				boolean firstName = StringUtils.containsIgnoreCase(addressBookRecord.getFirstName(), search);
				boolean lastName = StringUtils.containsIgnoreCase(addressBookRecord.getLastName(), search);
				boolean email = StringUtils.containsIgnoreCase(addressBookRecord.getEmail(), search);
				boolean phoneNum = StringUtils.containsIgnoreCase(addressBookRecord.getPhoneNum(), search);
				boolean address = StringUtils.containsIgnoreCase(addressBookRecord.getAddress(), search);
				boolean gender = StringUtils.containsIgnoreCase(addressBookRecord.getGender(), search);
				if (firstName || lastName || email || phoneNum || address || gender) {
					searchResults.add(addressBookRecord);
				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("SearchResults.jsp");
		session.setAttribute("SearchResults", searchResults);
		rd.forward(request, response);
	}
}
