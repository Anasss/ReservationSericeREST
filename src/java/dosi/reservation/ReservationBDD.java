package dosi.reservation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anass
 */
public class ReservationBDD {
    private static List<Salle>       salles       = new ArrayList<Salle>();
    private static List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
    private static List<Reservation> reservations = new ArrayList<Reservation>();

    static {
        salles.add(new Salle("Micro 1.4", "TP"));
        salles.add(new Salle("Micro 2.4", "TP"));
        salles.add(new Salle("I005", "TD"));
        salles.add(new Salle("B", "Amphi"));
    }

    static {
        utilisateurs.add(new Utilisateur("Mounir", "Lallali", "MdC", "mounir.lallali@univ-brest.fr"));
        utilisateurs.add(new Utilisateur("Anass", "RACH", "MdC", "anas.rach@univ-brest.fr"));
    }   

    public static List<Salle> getSalles() {
        return salles;
    }

    public static List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public static List<Reservation> getReservations() {
        return reservations;
    }
}