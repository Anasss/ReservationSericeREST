package dosi.reservation;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anass
 */
@XmlRootElement(name = "salle")
public class Salle {
    private String nom;
    private String type;

    public Salle() {}

    public Salle(String nom, String type) {
        this.nom  = nom;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}