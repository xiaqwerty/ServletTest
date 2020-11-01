package myServletPackage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addServlet",urlPatterns = "/addServlet")
public class addServlet extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String parameter1=request.getParameter("a");
        String parameter2=request.getParameter("b");
        if(isIntegerOrNull(parameter1)&&isIntegerOrNull(parameter2))
        {
            RequestDispatcher rd=request.getRequestDispatcher("/doneServlet");
            rd.forward(request,response);
        }
        else
        {
            PrintWriter out=response.getWriter();
            out.println("Wrong parameter!\nTo get more details, please read server.log");
        }
    }
    private boolean isIntegerOrNull(String string)
    {
        if(string==null||string.equals(""))
        {
            System.out.println("Parameter a or b missing!");
            return false;
        }
        for(int i=0;i<string.length();i++)
        {
            if(!Character.isDigit(string.charAt(i)))
            {
                System.out.println("Wrong input type!");
                return false;
            }
        }
        return true;
    }
}
