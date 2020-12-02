package servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thealeke.Account;
import thealeke.Thealekeweb;
import thealeke.Thealekeweb_Service;

/**
 *
 * @author ashen
 */
public class UPDATE_ACC extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession(false).getAttribute("username") == null && request.getSession(false).getAttribute("password") == null) {

            response.sendRedirect("index.jsp");
        }

        Account ac = new Account();

        ac.setACCNO(Integer.parseInt(request.getParameter("accnum")));
        ac.setACCTYPE(request.getParameter("ACCTYPE"));
        ac.setOCCUPTION(request.getParameter("OCCUPTION"));
        ac.setDISTRICT(request.getParameter("DISTRICT"));
        ac.setFNAME(request.getParameter("FNAME"));
        ac.setLNAME(request.getParameter("LNAME"));
        ac.setMNAME(request.getParameter("MNAME"));
        ac.setDATE(new Date().toString());
        ac.setGENDER(request.getParameter("GENDER"));
        ac.setPHOTO("ashu.jpg");
        ac.setPNUM(request.getParameter("PNAME"));
        ac.setBALANCE(Integer.parseInt(request.getParameter("BALANCE")));
        ac.setNATIONALITY(request.getParameter("NATIONALITY"));
        ac.setBRANCH(request.getParameter("BRANCH"));
        ac.setADDRESS(request.getParameter("ADDRESS"));
        Thealekeweb_Service service = new Thealekeweb_Service();//connecting to the RPCwebservice to calllogin methode
        Thealekeweb proxy = service.getThealekewebPort();//connecting to the RPCwebservice to calllogin methode
        Account a = proxy.updateAccount(ac);
        response.sendRedirect("accountCheck?search=" + request.getParameter("accnum"));
    }

}
