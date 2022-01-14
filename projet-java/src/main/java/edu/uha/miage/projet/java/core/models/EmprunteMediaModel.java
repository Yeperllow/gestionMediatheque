
package edu.uha.miage.projet.java.core.models;



import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.associations.EmprunteMedia;
import edu.uha.miage.projet.java.core.service.MediaService;
import edu.uha.miage.projet.java.core.service.associations.EmprunteMediaService;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.springframework.validation.BindingResult;


/**
 *
 * @author Yvan Maillot <yvan.maillot@uha.fr>
 */
public class EmprunteMediaModel implements Serializable {

    public static boolean tryToSave(EmprunteMediaService emprunteMediaService, EmprunteMedia emprunteMedia, BindingResult br) {
        emprunteMediaService.save(emprunteMedia);
        /*try {
            emprunteMediaService.save(emprunteMedia);
            return true;
        } catch (Exception ex) {
            br.rejectValue("dateDebut", "error", "Erreur");
            return false;
        }*/
        return true;
    }

    public static boolean tryToDelete(EmprunteMediaService emprunteMediaService, int id) {
        try {
            //emprunteMediaService.delete(emprunteMediaService);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
}
