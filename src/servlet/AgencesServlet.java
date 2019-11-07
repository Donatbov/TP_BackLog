package servlet;

import ejb.AgenceEJB;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AgencesServlet")
public class AgencesServlet extends HttpServlet {
    @EJB
    AgenceEJB ejb;

    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        request.getRequestDispatcher("/index.xhtml").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    }
}
