package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="userinfo",
        urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        out.println("<HTML>\n" +
                "<HEAD>\n" +
                "<TITLE>RÉCAP INFO</TITLE>\n" +
                "<HEAD>\n" +
                "<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Nom: "
                + request.getParameter("name") + "\n" +
                " <LI>Prenom: "
                + request.getParameter("firstname") + "\n" +
                " <LI>Age: "
                + request.getParameter("age") + "\n" +
                "</UL>\n" +
                "<UL><P>Retour au formulaire : <A HREF='./index.html'>ICIII</A></P></UL>\n" +
                "</BODY></HTML>");
    }

    /**
     *
     * ================================================================================================================
     * ================================================================================================================
     * A TERMINER
     * ================================================================================================================
     * ================================================================================================================
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>\n" +
                "<h1>Tableau des paramètres</h1>\n" +
                "<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "<tr>\n" +
                "<th>Nom</th><th>Prenom</th><th>Age</th>");

        Enumeration NomsParam = request.getParameterNames();

        while(NomsParam.hasMoreElements()) {
            String NomParam = (String)NomsParam.nextElement();

            out.println("<tr><td>" + NomParam + "</td></tr>\n");

            String[] ValeursParam = request.getParameterValues(NomParam);

            if (ValeursParam.length == 1) {
                String ValeurParam = ValeursParam[0];

                if (ValeurParam.length() == 0)
                    out.println("<td><b>Aucune valeur</i></td>");

                else		  out.println(ValeurParam);
            }
            else {
                out.println("<td><ul>");
                for(int i=0; i < ValeursParam.length; i++) {
                    out.println("<li>" + ValeursParam[i] + "</li>");
                }
                out.println("</ul></td></tr>");
            }
        }
        out.println("</table>\n</body></html>");
    }
}
