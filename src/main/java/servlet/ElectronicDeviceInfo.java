package servlet;

import domain.ElectronicDevice;
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

@WebServlet(name="electronicdevicesinfo",
        urlPatterns={"/HomeInfo/ElectronicDevicesInfo"})
public class ElectronicDeviceInfo extends HttpServlet {
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
        ElectronicDevice el = new ElectronicDevice();
        // Instantiation object and persist call
        try {
            el.setConso(Float.valueOf(request.getParameter("consoelecdevice")));
            int idmaison = Integer.valueOf(request.getParameter("maison"));
            Home h = manager.find(Home.class, idmaison);
            h.getElectronicDevices().add(el);
            manager.persist(el);
            manager.persist(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        manager.close();
        factory.close();

        response.sendRedirect("/HomeInfo");
    }
/*
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
    }*/
}
