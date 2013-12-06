package dosi.reservation;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anass
 */
@XmlRootElement(name = "utilisateur")
public class Utilisateur {
    private String email;
    private String grade;
    private String nom;
    private String prenom;

    public Utilisateur() {}

    public Utilisateur(String prenom, String nom, String grade, String email) {
        this.prenom = prenom;
        this.nom    = nom;
        this.grade  = grade;
        this.email  = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
