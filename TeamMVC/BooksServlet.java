package java112.project3.TeamMVC;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

import java112.project3.TeamMVC.Book;
import java112.project3.TeamMVC.NetworkUtils;
import org.json.JSONException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
    name = "BooksServlet",
    urlPatterns = { "/books" }
)
public class BooksServlet extends HttpServlet {

    private String urlResult;
    private ArrayList<Book> books;



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

            urlResult = NetworkUtils.getResponseFromURL(NetworkUtils.generateURL(request.getParameter("title"), "0"));
            books = NetworkUtils.parseJSONBooks(urlResult);
             request.setAttribute("books", books);

        RequestDispatcher dispatcher = request
                        .getRequestDispatcher("/MVC_Test_Output.jsp");
                dispatcher.forward(request, response);
            }
        }

