package org.koushik.javabrains;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

		final String userName = request.getParameter("userName");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Hello, " + userName + ", from the get method");

	}

	@Override
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

		final String userName = request.getParameter("userName");
		final String fullName = request.getParameter("fullName");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Hello, " + userName + ", from the post method. You're full name is " + fullName);

	}
}
