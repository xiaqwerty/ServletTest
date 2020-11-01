package myServletPackage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet",urlPatterns = "/login")
public class loginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session=request.getSession();
        session.setAttribute("login",false);
        if(request.getParameter("user").equals("admin")&&request.getParameter("password").equals("123456"))
        {
            session.setAttribute("login",true);
            System.out.println("login success!");
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<head>");
            out.println("<title>Login Success!</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login Sucess!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        else
        {
            System.out.println("wrong login request detected");
            System.out.println("Wrong user is: "+request.getParameter("user"));
            System.out.println("Wrong password is: "+request.getParameter("password"));
            PrintWriter out=response.getWriter();
            out.println("Login Failed!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
