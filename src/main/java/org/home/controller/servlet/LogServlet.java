package org.home.controller.servlet;

import org.home.model.logic.AttributeEnum;
import org.home.model.logic.LogEnum;
import org.home.model.logic.PageEnum;
import org.home.model.logic.StatusEnum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Log", urlPatterns = {"/log"})
public class LogServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String log = (String) session.getAttribute(AttributeEnum.LOG.getValue());
        if (log.equals(LogEnum.LOGIN.getValue())) {
            request.getRequestDispatcher(PageEnum.LOGIN.getValue()).forward(request, response);
        }
        if (log.equals(LogEnum.LOGOUT.getValue())) {
            session.setAttribute(AttributeEnum.STATUS.getValue(), StatusEnum.GUEST.getValue());
            session.setAttribute(AttributeEnum.LOG.getValue(), LogEnum.LOGIN.getValue());
            request.getRequestDispatcher(PageEnum.HOME.getValue()).forward(request, response);
        }
    }
}
