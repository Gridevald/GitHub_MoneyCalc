package org.home.controller.servlet;

import org.home.model.handler.UserHandler;
import org.home.model.logic.AttributeEnum;
import org.home.model.logic.PageEnum;
import org.home.model.logic.StatusEnum;
import org.home.model.logic.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(name = "Name", urlPatterns = {"/main"})
public class MainServlet extends HttpServlet {

    private final String FAULT = "r_fault";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = (String) request.getSession().getAttribute(AttributeEnum.STATUS.getValue());
        if (status.equals(StatusEnum.GUEST.getValue())) {
            request.getRequestDispatcher(PageEnum.LOGIN.getValue()).forward(request, response);
        } else {
            request.getRequestDispatcher(PageEnum.MAIN.getValue()).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sign = request.getParameter("r_sign");
        String value = request.getParameter("r_value");
        String description = request.getParameter("r_description");
        String date = request.getParameter("r_date");

        if (sign.equals("-")) {
            request.setAttribute("p_selected", 1);
        } else {
            request.setAttribute("p_selected", 0);
        }
        request.setAttribute("p_value", value);
        request.setAttribute("p_description", description);
        request.setAttribute("p_date", date);

        //Validate value
        if (!new Validator().checkValue(value)) {
            request.setAttribute(FAULT, "Value should be positive integer or double.");
            request.getRequestDispatcher(PageEnum.MAIN.getValue()).forward(request, response);
            return;
        }

        //Validate description
        if (!new Validator().checkDescription(description)) {
            request.setAttribute(FAULT, "Type in some description. It would be less confusing.");
            request.getRequestDispatcher(PageEnum.MAIN.getValue()).forward(request, response);
            return;
        }

        //Validate date
        if (!new Validator().checkDate(date)) {
            request.setAttribute(FAULT, "Choose some date. It's better, when you know specific date of operation.");
            request.getRequestDispatcher(PageEnum.MAIN.getValue()).forward(request, response);
            return;
        }

        double dValue = new Validator().prepareNumber(value, sign);

        //Validate for zero value
        if (new Validator().checkValueZero(dValue)) {
            request.setAttribute(FAULT, "Value shouldn't be a zero.");
            request.getRequestDispatcher(PageEnum.MAIN.getValue()).forward(request, response);
            return;
        }

        request.setAttribute("p_selected", 0);
        request.setAttribute("p_value", "");
        request.setAttribute("p_description", "");
        request.setAttribute("p_date", "");

        String email = (String) request.getSession().getAttribute(AttributeEnum.EMAIL.getValue());
        Calendar cDate = new Validator().getDate(date);
        new UserHandler().addRecord(email, description, dValue, cDate);
        request.getSession().setAttribute(AttributeEnum.ORDER_LIST.getValue(), new UserHandler().findUser(email).getRecords());
        request.getRequestDispatcher(PageEnum.MAIN.getValue()).forward(request, response);
    }
}
