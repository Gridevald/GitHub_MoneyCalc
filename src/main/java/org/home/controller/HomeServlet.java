package org.home.controller;

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

@WebServlet(name = "Home", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String status = (String) session.getAttribute(AttributeEnum.STATUS.getValue());
        if (status == null) {
            status = StatusEnum.GUEST.getValue();
        }
        session.setAttribute(AttributeEnum.STATUS.getValue(), status);

        String log = (String) session.getAttribute(AttributeEnum.LOG.getValue());
        if (log == null) {
            log = LogEnum.LOGIN.getValue();
        }
        session.setAttribute(AttributeEnum.LOG.getValue(), log);

        request.getRequestDispatcher(PageEnum.HOME.getValue()).forward(request, response);
    }
}
