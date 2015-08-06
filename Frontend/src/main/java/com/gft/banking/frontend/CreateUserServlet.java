package com.gft.banking.frontend;

import com.gft.banking.business.services.ClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rowesolowski on 2015-08-06.
 */
public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Create.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String firstName = req.getParameter("FirstName");
        final String lastName = req.getParameter("LastName");
        final ClientService clientService = new ClientService();
        if(clientService.createClient(firstName, lastName)) {
            resp.sendRedirect(req.getContextPath() + "/Index.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/create");
        }
    }
}
