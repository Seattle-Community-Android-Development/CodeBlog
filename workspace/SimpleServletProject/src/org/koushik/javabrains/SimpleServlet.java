package org.koushik.javabrains;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServlet" }, initParams = { @WebInitParam(name = "defaultUser", value = "John Doe") })
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SESSION_PARAMETER_USER_NAME = "USER_NAME";

	@Override
	public void init() throws ServletException {
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

		response.setContentType("text/html");

		final String userName = request.getParameter("userName");

		final HttpSession session = request.getSession();
		final ServletContext context = request.getServletContext();

		if (userName != null && !userName.isEmpty()) {
			session.setAttribute(SESSION_PARAMETER_USER_NAME, userName);
			context.setAttribute(SESSION_PARAMETER_USER_NAME, userName);
		}

		final PrintWriter writer = response.getWriter();
		writer.println("Request parameter has username as: " + userName);
		writer.println("<br>Session parameter has username as: "
				+ (String) session.getAttribute(SESSION_PARAMETER_USER_NAME));
		writer.println("<br>Context parameter has username as: "
				+ (String) context.getAttribute(SESSION_PARAMETER_USER_NAME));
		writer.println("<br>Initial value has username as: "
				+ getServletConfig().getInitParameter("defaultUser"));

	}
}
