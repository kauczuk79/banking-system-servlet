package com.gft.banking.frontend;

import com.gft.banking.business.services.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class UserLoginServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Index.jsp");
        //req.setAttribute("dff", dff);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String firstName = req.getParameter("FirstName");
        final String lastName = req.getParameter("LastName");
        final String password = req.getParameter("Password");
        LOGGER.error(firstName + " " + lastName + " " + password);

        LoginService loginService = new LoginService();
        final int clientId = loginService.tryLogin(firstName, lastName, password);
        final String url;
        if(clientId != -1) {
            url = "/client?clientID="+clientId;
        } else {
            url = "/Index.jsp";
        }
        resp.sendRedirect(req.getContextPath() + url);
    }
}
