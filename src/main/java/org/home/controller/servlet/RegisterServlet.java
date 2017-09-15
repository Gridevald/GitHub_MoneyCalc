package org.home.controller.servlet;

import org.home.model.handler.UserHandler;
import org.home.model.logic.PageEnum;
import org.home.model.logic.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Register", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private final String FAULT = "sign_fault";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Validator v = new Validator();

        //Check for correct e-mail
        String email = request.getParameter("reg_email");
        if (!v.checkEmail(email)) {
            request.setAttribute(FAULT, "Wrong e-mail. Enter correct e-mail.");
            request.getRequestDispatcher(PageEnum.SIGN.getValue()).forward(request, response);
            return;
        }

        //Check for correct password
        String password1 = request.getParameter("reg_password_1");
        String password2 = request.getParameter("reg_password_2");
        if (!password1.equals(password2)) {
            request.setAttribute(FAULT, "Enter equal passwords.");
            request.getRequestDispatcher(PageEnum.SIGN.getValue()).forward(request, response);
            return;
        }
        if (!v.checkPassword(password1) || !v.checkPassword(password2)) {
            request.setAttribute(FAULT, "Wrong password. " +
                    "It can contain latin letters, numbers, punctuation symbols. " +
                    "Length 6-255 symbols.");
            request.getRequestDispatcher(PageEnum.SIGN.getValue()).forward(request, response);
            return;
        }

        //Check for existing user
        if (new UserHandler().findUser(email) != null) {
            request.setAttribute(FAULT, "User with this e-mail already exists.");
            request.getRequestDispatcher(PageEnum.SIGN.getValue()).forward(request, response);
            return;
        }

        new UserHandler().addNewUser(email, password1);
        request.getRequestDispatcher(PageEnum.LOGIN.getValue()).forward(request, response);
    }
}
