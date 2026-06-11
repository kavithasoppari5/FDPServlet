import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
@WebServlet("/life")
public class ServletDemo extends HttpServlet{
    private int requestCount;
    @Override
    public void init() throws ServletException
    {
      requestCount=0;
      System.out.println("init():Servlet has been initiated.");
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
      {
        synchronized(this){
            requestCount++;
        }
        System.out.println("doGet(): Preprocessing kavitha request number" +requestCount);
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html><body>");
        out.println("<h2>kavitha servlet demo</h2>");
        out.println("<p>total visits"+requestCount+"</p>");
        out.println("<form action='index.html'><button>Go Back</button></form>");
        out.println("</body></html>");
    }
    @Override
    public void destroy()
    {
       System.out.println("destroy():cleaning up resources. final rquest count:"+requestCount);
    }
}
