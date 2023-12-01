import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ControllerServlet", value = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        ArrayList<Dot> dotsList = (ArrayList<Dot>) servletContext.getAttribute("dotsList");
        request.setAttribute("dotsList", dotsList);
        response.getWriter().write(dotsList.toString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("x") != null & request.getParameter("y") != null & request.getParameter("r") != null) {
            response.sendRedirect(this.getServletContext().getContextPath() + "/AreaCheck?x=" + request.getParameter("x")
                    + "&y=" + request.getParameter("y") + "&r=" + request.getParameter("r"));
        } else {
            getServletContext().setAttribute("dotsList", null);
        }

    }


}
