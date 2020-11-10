package java112.project3;
 
import java.io.*;
import java.net.URISyntaxException;
import java.util.*;
import org.json.JSONException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
    name = "booksServlet", 
    urlPatterns = { "/books" }
)
public class BooksServlet extends HttpServlet {

    private String urlResult;
    private ArrayList<Book> books;

    /**
     * Initializes properties servlet
     * @throws ServletException in case of servlet failure
     */
    public void init() throws ServletException {

    }

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
        PrintWriter  out  = response.getWriter();
        try {
            urlResult = NetworkUtils.getResponseFromURL(NetworkUtils.generateURL(request.getParameter("title"), "0"));
        }
        catch (URISyntaxException e) {
            out.println(e);
        }
        finally {
            try {
                books = NetworkUtils.parseJSONBooks(urlResult);
            }
            catch (JSONException e) {
                books = null;
                out.println(e);
            }
            finally {       //Check if result found or not
                if(books == null) {
                    String message = "I'm sorry, we couldn't find that title :("
                            + "<br><a href='MVC_Test.jsp'>Go Back</a>";
                    request.setAttribute("books", message);
                } else {
                    request.setAttribute("books", books);
                }

                String url = "/MVC_Test_Output.jsp";

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);

            }
        }

        
    }
}