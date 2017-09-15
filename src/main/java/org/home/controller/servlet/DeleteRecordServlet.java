package org.home.controller.servlet;

import org.home.model.handler.RecordHandler;
import org.home.model.handler.UserHandler;
import org.home.model.logic.AttributeEnum;
import org.home.model.logic.PageEnum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteRecord", urlPatterns = {"/deleteRecord"})
public class DeleteRecordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.valueOf(request.getParameter("delete_id"));
        String email = (String) request.getSession().getAttribute(AttributeEnum.EMAIL.getValue());

        new RecordHandler().removeRecord(id);
        request.getSession().setAttribute(AttributeEnum.ORDER_LIST.getValue(), new UserHandler().findUser(email).getRecords());
        request.getRequestDispatcher(PageEnum.MAIN.getValue()).forward(request, response);
    }
}
