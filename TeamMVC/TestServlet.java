package java112.project3.TeamMVC;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * MCV SERVLET
 *
 *@author    whurd
 */
@WebServlet(
    name = "TestServlet",
    urlPatterns = { "/testServlet" }
)
public class TestServlet extends HttpServlet {

        /**
         *  Handles HTTP GET requests.
         *
         *@param  request                   the HttpServletRequest object
         *@param  response                   the HttpServletResponse object
         *@exception  ServletException  if there is a Servlet failure
         *@exception  IOException       if there is an IO failure
         */
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            response.setContentType("text/html");
            // set the response type before sending data
            PrintWriter  out  = response.getWriter();
            out.print("<HTML>");
            out.print("<HEAD><TITLE>Book Browser</TITLE></HEAD>");
            out.print("<BODY>");
            out.print("<h1>Book Browser</h1>");

            out.print("<p>"+ request.getParameter("bookTitle") + "</p>");

            out.print("</BODY>");
            out.print("</HTML>");
            out.close();
        }

    }
