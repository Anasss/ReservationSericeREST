package dosi.reservation;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Anass
 */

@Path("Reservation")


public class ReservationResource {
    @Context
    private Request request;
    @Context
    private UriInfo uriInfo;

    @GET
    @Produces("application/xml")
    @Valid
    public List<Reservation> getReservations() {
        System.out.println("getReservations");
        return ReservationBDD.getReservations();
    }
    
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    @Valid
    public String creerReservation(@QueryParam("description")  String description , @QueryParam("date") String date,
                                    @QueryParam("heure") String heure, @QueryParam("duree") Double duree,
                                    @QueryParam("typeCours") String typeCours, @QueryParam("nomSalle") String nomSalle,
                                    @QueryParam("prenomUtilisateur") String prenomUtilisateur,
                                    @QueryParam("nomUtilisateur") String nomUtilisateur,
                                    @QueryParam("gradeUtilisateur") String gradeUtilisateur,
                                    @QueryParam("emailUtilisateur") String emailUtilisateur) {
        
        
        
        Utilisateur utilisateur = null;
        Salle       salle       = null;

        for (Salle currentS : ReservationBDD.getSalles()) {
            if (currentS.getNom().equals(nomSalle)) {
                salle = currentS;
            }
        }

        if (salle == null) {
            return "Réservation refusée salle " + nomSalle + "Inexistante ";
        }

        for (Utilisateur currentU : ReservationBDD.getUtilisateurs()) {
            if (currentU.getPrenom().equals(prenomUtilisateur) && currentU.getNom().equals(nomUtilisateur)) {
                utilisateur = currentU;
            }
        }
        
        for (Reservation currentR : ReservationBDD.getReservations()){
        
            if(currentR.getDate().equals(date) && currentR.getHeure().equals(heure) && currentR.getSalle().getNom().equals(nomSalle)){
            
            return "la salle "+salle+"est dèja réservé"; 
            }
        }
        

        if (utilisateur == null) {
            utilisateur = new Utilisateur(prenomUtilisateur, nomUtilisateur, gradeUtilisateur, emailUtilisateur);
            ReservationBDD.getUtilisateurs().add(utilisateur);
        }

        Reservation reservation = new Reservation();

        reservation.setNumReservation(Long.toString(System.currentTimeMillis()));
        reservation.setDescription(description);
        reservation.setDate(date);
        reservation.setHeure(heure);
        reservation.setDuree(duree);
        reservation.setTypeCours(typeCours);
        reservation.setSalle(salle);
        reservation.setUtilisateur(utilisateur);
        ReservationBDD.getReservations().add(reservation);
        return "Reservation effectuee : " + reservation.getNumReservation();
    }

    
    @PUT
    @Produces("application/xml")
    @Valid
    public String ModifierReservation( @NotNull @QueryParam("date") String date,
                                  @NotNull @QueryParam("heure") String heure,
                                   @NotNull @QueryParam("typeCours") String typeCours, @NotNull @QueryParam("numReservation") String numReservation) {
        
        
       

         for (Reservation currentR : ReservationBDD.getReservations()){
        
            if(!currentR.getNumReservation().equals(numReservation)){
            
            return "Numèro de réservation inéxistant"; 
            }
         }
         
          
         
       
          for (Reservation currentR : ReservationBDD.getReservations()){
        
            if(currentR.getNumReservation().equals(numReservation)){
            
            currentR.setDate(date);
            currentR.setHeure(heure);
            currentR.setTypeCours(typeCours);
            }
         }
         
         return "Modification effectuée";
         
         
        
    }
    
}
