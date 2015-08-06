package com.gft.banking.frontend;

import com.gft.banking.business.dto.ClientDTO;
import com.gft.banking.business.services.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rowesolowski on 2015-08-05.
 */
@WebServlet()
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int clientId = Integer.parseInt(req.getParameter("clientID"));
        final ClientService clientService = new ClientService();
        final ClientDTO clientDTO = clientService.getClient(clientId);
        resp.getWriter().write(clientDTO.toString());
    }
}
