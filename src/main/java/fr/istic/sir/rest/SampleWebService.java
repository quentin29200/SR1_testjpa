package fr.istic.sir.rest;

import domain.Heater;
import domain.Home;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/ws")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }

    @GET @Path("/home/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Home findById(@PathParam("id") int arg0) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Home h = new Home();
        try {
            System.out.println(arg0);
            h = manager.find(Home.class, arg0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        return h;
    }

    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Home getHome() {
        System.out.println("hello");
        Home h = new Home();
        h.setNbPieces(2);
        Heater h1 = new Heater();
        h1.setConso(550);
        Heater h2 = new Heater();
        h2.setConso(550);
        List<Heater> heaters = new ArrayList<Heater>();
        heaters.add(h1);
        heaters.add(h2);
        h.setHeaters(heaters);
        return h;
    }
}

