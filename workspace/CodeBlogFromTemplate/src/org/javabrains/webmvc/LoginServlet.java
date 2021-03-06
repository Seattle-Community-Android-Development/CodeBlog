package org.javabrains.webmvc;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helo478.codeblog.user.InvalidPasswordException;
import com.helo478.codeblog.user.InvalidUserException;
import com.helo478.codeblog.user.UserAccount;
import com.helo478.codeblog.user.UserManager;
import com.helo478.codeblog.user.UserManagerException;
import com.helo478.codeblog.util.ServletConstants;
import com.helo478.codeblog.util.WebConstants;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(LoginServlet.class
			.getName());

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		final String userName = request.getParameter(ServletConstants.ATTRIBUTE_USER_NAME);
		final String password = request.getParameter(ServletConstants.ATTRIBUTE_PASSWORD);

		final UserManager userManager = (UserManager) request
				.getServletContext().getAttribute(ServletConstants.ATTRIBUTE_USER_MANAGER);

		try {
			UserAccount activeUser = userManager.loginUser(userName, null);
			// TODO: add password handling

			request.getSession().setAttribute(ServletConstants.ATTRIBUTE_ACTIVE_USER, activeUser);
			response.sendRedirect(WebConstants.PAGE_FORM);
			
		} catch (final InvalidUserException iue) {
			final StringBuffer iueMessage = new StringBuffer();
			iueMessage.append("Invalid User Name: ");
			iueMessage.append(userName);

			logger.info(iueMessage.toString());
		} catch (final InvalidPasswordException ipe) {
			logger.info("Invalid Password");
		} catch (final UserManagerException ume) {
			final String message = ume.getMessage();
			logger.log(Level.WARNING, message != null ? message : "", ume);
		}
	}
}
