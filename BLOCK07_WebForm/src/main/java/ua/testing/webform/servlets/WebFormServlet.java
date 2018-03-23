package ua.testing.webform.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.testing.webform.model.Model;
import ua.testing.webform.model.ModelImp;
import ua.testing.webform.model.NotUniqueLoginException;

/**
 * Servlet implementation class WebFormServlet
 */
@WebServlet("/webform")
public class WebFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebFormServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String login = request.getParameter("login");
		
		PrintWriter out = response.getWriter();
		StringBuffer buffer = new StringBuffer();
		
		Model model = new ModelImp();
		model.setName(name);
		try {
			model.setLogin(login);
		} catch (NotUniqueLoginException e) {
			e.printStackTrace();
			buffer.append(login + " isn't unique! Enter another login.");
		}		
		out.println("Name: " + model.getName() + "<br>Login: " + model.getLogin() + buffer.toString());

	}

}
