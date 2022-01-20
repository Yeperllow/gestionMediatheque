
package edu.uha.miage.projet.java.core.models;



import java.io.Serializable;
import javax.validation.constraints.NotNull;


/**
 *
 * @author kangacedricmarshallfry
 */
public class DecritMediaModel implements Serializable {

    @NotNull
    private int id_media;
    
    @NotNull
    private int id_tag;
    
    @NotNull
    private boolean etat;
    
   

    public DecritMediaModel(int media, int tag, boolean etat) {
        this.id_media = media;
        this.id_tag = tag;
        this.etat = etat;
    }

    public DecritMediaModel() {
        this(0, 0, true);
    }

    public int getId_media() {
        return id_media;
    }

    public int getId_tag() {
        return id_tag;
    }

    public boolean isEtat() {
        return etat;
    }

   

    public void setId_media(int id_media) {
        this.id_media = id_media;
    }

   
    public void setEtat(boolean etat) {
        this.etat = etat;
        
    }

    public void setId_tag(int id_tag) {
        this.id_tag = id_tag;
    }
    
    

    @Override
    public String toString() {
        return "DecritMediaModel{" + "id_media=" + id_media + ", id_tag=" + id_tag + ", etat=" + etat + '}';
    }

    
    
}
