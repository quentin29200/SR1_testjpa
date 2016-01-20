package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="electronicdevicesinfo",
        urlPatterns={"/ElectronicDevicesInfo"})
public class ElectronicDeviceInfo extends HttpServlet {
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
                " <LI>Conso : "
                + request.getParameter("consoelectdevice") + "\n" +
                "</UL>\n" +
                "<UL><P>Retour au formulaire : <A HREF='./myformadd.html'>ICIII</A></P></UL>\n" +
                "</BODY></HTML>");
    }
}
