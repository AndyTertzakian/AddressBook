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

import org.omg.CORBA.portable.ApplicationException;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<AddressBookRecord> ab = (ArrayList<AddressBookRecord>) session.getAttribute(Constants.ADDRESS_BOOK);
		ArrayList<AddressBookRecord> toDelete = new ArrayList<AddressBookRecord>();

		String delO = request.getParameter("deleteOption");
		if (delO.equals(Constants.DELETE_METHOD_ONE)) {
			for (int i = 0; i < ab.size(); i++) {
				String dt = request.getParameter(Integer.toString(i));
				// System.out.println(dt);
				if (dt != null && dt.equals("on")) {
					AddressBookRecord t = ab.get(i);
					toDelete.add(t);
				}
			}
		} else if (delO.equals(Constants.DELETE_METHOD_TWO)) {

			String[] dt = request.getParameterValues("delete");
			for (int i = 0; i < dt.length; i++) {
				int index = Integer.parseInt(dt[i]);

				AddressBookRecord addressBookRecord = ab.get(index);
				toDelete.add(addressBookRecord);
			}
		} else {
			throw new RuntimeException("did not specify delete option");
		}
		ab.removeAll(toDelete);
		RequestDispatcher rd = request.getRequestDispatcher("/AddressBook.jsp");
		rd.forward(request, response);
	}

}
