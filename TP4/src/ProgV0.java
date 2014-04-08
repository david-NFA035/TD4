
public class ProgV0 {

	/**
	 * Gestion d'evenements d'une course (code a completer)
	 *  - pas de menu
	 *  - gestion d'erreurs avec codes d'erreurs (sans exceptions)
	 *  Version V0
	 */
	
    /** Affiche message d'erreur 
     * selon @param code 
     * avec numero dossard @param nd
     * et nom d'operation erronee @param op */
    public static void afficheErreur(int code, int nd, String op){
  	  String [] erreur = {"", "Dossard invalide.", "coureur deja arrive", "coureur ayant abandonne", 
	  "coureur deja disqualifie"};
  	  if (code != 0) 
  		  Terminal.ecrireStringln("Dossard no." + nd + " => "+ op + " impossible: " + erreur[code]);
    }
    
	public static void main(String[] args) {

		// A completer
		
		Course c = new Course();
		c.opInscritCoureur("A");
		c.opInscritCoureur("B");
		c.opInscritCoureur("C");
	
		c.afficheParticipants();
		afficheErreur(c.enregistreArrivee(3), 3, "Classement");	
		c.afficheParticipants();
		afficheErreur(c.enregistreArrivee(3), 3, "Classement");	
	    c.afficheParticipants();
	
	}

}
