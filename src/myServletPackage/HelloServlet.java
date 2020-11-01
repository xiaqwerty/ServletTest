package myServletPackage;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

//@javax.servlet.annotation.WebServlet(name = "HelloServlet",urlPatterns={"/hello"})
@WebServlet(name = "HelloServlet",urlPatterns={"/hello"})
public class HelloServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
    @Override
    public void init() throws ServletException
    {
        System.out.println("**********init() is called*************");
        super.init();
    }
    @Override
    public void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
    {
        System.out.println("***********service is called**********");
        super.service(req,resp);
    }
    @Override
    public void destroy()
    {
        System.out.println("**********destroy() is called**********");
        super.destroy();
    }


}
