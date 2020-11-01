package myServletPackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "doneServlet",urlPatterns="/doneServlet")
public class doneServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String parameter1=request.getParameter("a");
        String parameter2=request.getParameter("b");
        int a=Integer.parseInt(parameter1);
        int b=Integer.parseInt(parameter2);
        int addResult=a+b;
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>AddResult</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>The result is "+addResult+"</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
