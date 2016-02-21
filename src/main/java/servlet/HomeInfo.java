package servlet;

import domain.Home;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name="homeinfo",
        urlPatterns={"/HomeInfo"})
public class HomeInfo extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        // The response is some html content
        response.setContentType("text/html");

        // Entity Manager
        // Dev environment
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("local");
        EntityManager manager = factory.createEntityManager();

        // Transaction manager
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Home h = new Home();
        // Instantiation object and persist call
        try {
            h.setSize(Float.valueOf(request.getParameter("size")));
            h.setNbPieces(Integer.valueOf(request.getParameter("nbPieces")));
            manager.persist(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        manager.close();
        factory.close();

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        out.println("<HTML>\n" +
                "<HEAD>\n" +
                "<TITLE>Ajouter des appareils</TITLE>\n" +
                "<HEAD>\n" +
                "<BODY>\n" +
                "<h1>Maison n°"+ h.getId() + "</h1>" +
                "<h2>Ajout d'un chauffage</h2>" +
                "<FORM Method=\"POST\" Action=\"/HomeInfo/HeaterInfo\">" +
                "ID Maison :    <input type=\"hidden\" value=\""+h.getId()+"\" name=\"maison\" readOnly=\"true\" />"+
                "Conso : 		<INPUT type=text size=20 name=\"consoheater\"><BR>" +
                "<INPUT type=submit value=Send>" +
                "</FORM>" +
                "<h2>Ajout d'un appareil électronique</h2>" +
                "<FORM Method=\"POST\" Action=\"/HomeInfo/ElectronicDeviceInfo\">" +
                "ID Maison :    <input type=\"hidden\" value=\""+h.getId()+"\" name=\"maison\" readOnly=\"true\" />"+
                "Conso : 		<INPUT type=text size=20 name=\"consoelecdevice\"><BR>" +
                "<INPUT type=submit value=Send>" +
                "</FORM>" +
                "<UL><P>Retour au formulaire : <A HREF='./myformadd.html'>ICIII</A></P></UL>\n" +
                "</BODY></HTML>");
    }

    public void doGet(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>\n" +
                "<h1>Info sur la maison</h1>\n" +
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