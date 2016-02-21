package servlet;

import domain.Heater;
import domain.Home;

import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="heaterinfo",
        urlPatterns={"/HomeInfo/HeaterInfo"})
public class HeaterInfo extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        // The response is some html content
        response.setContentType("text/html");

        // Entity Manager
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("local");
        EntityManager manager = factory.createEntityManager();

        int id = Integer.valueOf(request.getParameter("maison"));
        Home h = manager.find(Home.class, id);
        System.out.println(h);

        // Transaction manager
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Heater he = new Heater();
        // Instantiation object and persist call
        try {
            he.setConso(Float.valueOf(request.getParameter("consoheater")));
            h.getHeaters().add(he);
            manager.persist(he);
            manager.persist(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();

        manager.close();


        response.sendRedirect("/HomeInfo");
    }
}