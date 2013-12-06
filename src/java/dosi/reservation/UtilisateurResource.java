package dosi.reservation;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Anass
 */
@Path("utilisateurs")
public class UtilisateurResource {

    @Context
    private UriInfo context;

    public UtilisateurResource() {
    }

    @GET
    @Produces("application/xml")
    public List<Utilisateur> getUtilisateurs() {
        System.out.println("getUtilisateurs");
        return ReservationBDD.getUtilisateurs();
    }

    @GET
    @Path("utilisateur-{prenom}-{nom}")
    @Produces("application/xml")
    public Utilisateur getUtilisateur(@PathParam("prenom") String prenom, @PathParam("nom") String nom) {
        System.out.println("getUtilisateur");

        for (Utilisateur current : ReservationBDD.getUtilisateurs()) {
            if (current.getPrenom().equals(prenom) && current.getNom().equals(nom)) {
                return current;
            }
        }
        return null;
    }

    @GET
    @Path("/searchByName")
    public Utilisateur searchUtilisateursByName(@QueryParam("prenom") String prenom, @QueryParam("nom") String nom) {
        System.out.println("searchUtilisateursByName");

        for (Utilisateur current : ReservationBDD.getUtilisateurs()) {
            if (current.getPrenom().equals(prenom) && current.getNom().equals(nom)) {
                return current;
            }
        }
        return null;
    }

    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public String createUtilisateur(@QueryParam("prenom") String prenom, @QueryParam("nom") String nom,
            @QueryParam("grade") String grade, @QueryParam("email") String email) {
        Utilisateur utilisateur = null;

        for (Utilisateur current : ReservationBDD.getUtilisateurs()) {
            if (current.getPrenom().equals(prenom) && current.getNom().equals(nom)) {
                utilisateur = current;
            }
        }

        if (utilisateur == null) {
            utilisateur = new Utilisateur(prenom, nom, grade, email);
            ReservationBDD.getUtilisateurs().add(utilisateur);

            return "L'utilisateur :" + prenom + " " + nom + " est ajoute";
        } else {
            return "L'utilisateur :" + prenom + " " + nom + " existe deja !!!";
        }
    }
}