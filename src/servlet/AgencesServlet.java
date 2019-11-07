package servlet;

import ejb.AgenceEJB;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/AgencesServlet")
public class AgencesServlet extends HttpServlet {
    @EJB
    AgenceEJB ejb;

}
