package tomcat.examples;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SessionExample")
public class SessionExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(true);

		// print session info

		Date created = new Date(session.getCreationTime());
		Date accessed = new Date(session.getLastAccessedTime());
		out.println("ID " + session.getId());
		out.println("Created: " + created);
		out.println("Last Accessed: " + accessed);

		// set session info if needed

		String dataName = request.getParameter("dataName");
		if (dataName != null && dataName.length() > 0) {
			String dataValue = request.getParameter("dataValue");
			session.setAttribute(dataName, dataValue);
		}

		// print session contents

		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = session.getAttribute(name).toString();
			out.println(name + " = " + value);
		}
	}
}
