package org.home.controller.servlet;

import org.home.model.handler.UserHandler;
import org.home.model.logic.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogIn", urlPatterns = {"/login"})
public class LogInServlet extends HttpServlet{

    private final String FAULT = "log_fault";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //Check for correct e-mail
        if (!new Validator().checkEmail(email)) {
            request.setAttribute(FAULT, "Incorrect e-mail.");
            request.getRequestDispatcher(PageEnum.LOGIN.getValue()).forward(request, response);
            return;
        }

        //Check for existing user
        if (new UserHandler().findUser(email) == null) {
            request.setAttribute(FAULT, "User with this e-mail is not exist.");
            request.getRequestDispatcher(PageEnum.LOGIN.getValue()).forward(request, response);
            return;
        }

        //Validate user
        if (!new UserHandler().validateUser(email, password)) {
            request.setAttribute(FAULT, "Wrong password.");
            request.getRequestDispatcher(PageEnum.LOGIN.getValue()).forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute(AttributeEnum.STATUS.getValue(), StatusEnum.USER.getValue());
        session.setAttribute(AttributeEnum.EMAIL.getValue(), email);
        session.setAttribute(AttributeEnum.ORDER_LIST.getValue(), new UserHandler().findUser(email).getRecords());
        session.setAttribute(AttributeEnum.LOG.getValue(), LogEnum.LOGOUT.getValue());
        request.getRequestDispatcher(PageEnum.MAIN.getValue()).forward(request, response);
    }
}
