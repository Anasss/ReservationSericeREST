package dosi.reservation;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Anass
 */

@Path("salles")
public class SalleResource {
    @Context
    private UriInfo context;

    public SalleResource() {}
    @GET
    @Produces("application/xml")
    public List<Salle> getSalles() {
        System.out.println("getSalles");
        return ReservationBDD.getSalles();
    }

    @GET
    @Path("salle-{nom}")
    @Produces("application/xml")
    public Salle getSalle(@PathParam("nom") String nom) {
        System.out.println("getSalle");

        for (Salle current : ReservationBDD.getSalles()) {
            if (current.getNom().equals(nom)) {
                return current;
            }
        }

        return null;
    }

    @GET
    @Path("/searchByName")
    @Produces("application/xml")
    public Salle searchSalleByName(@QueryParam("nom") String nom) {
        System.out.println("searchSalleByName");

        for (Salle current : ReservationBDD.getSalles()) {
            if (current.getNom().equals(nom)) {
                return current;
            }
        }
        return null;
    }

    @GET
    @Path("/searchByType")
    @Produces("application/xml")
    public List<Salle> searchSallesByType(@QueryParam("type") String type) {
        List<Salle> listSalles = new ArrayList<Salle>();

        System.out.println("searchSallesByType");

        for (Salle current : ReservationBDD.getSalles()) {
            if (current.getType().equals(type)) {
                listSalles.add(current);
            }
        }
        return listSalles;
    }

    @Path("/reservations")
    @Produces("application/xml")
    public ReservationResource getReservationResource() {
       
        return new ReservationResource();
    }
}