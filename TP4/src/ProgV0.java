
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
		c.opInscritCoureur("D");
		c.opInscritCoureur("E");
		c.opInscritCoureur("F");
		c.opInscritCoureur("G");
		c.opInscritCoureur("H");
		c.opInscritCoureur("I");
		c.opInscritCoureur("J");
	
		c.afficheParticipants();
		c.enregistreArrivee(3);
		afficheErreur(c.enregistreArrivee(3), 3, "Classement");	
		c.afficheParticipants();
		c.enregistreAbandon(2);
		afficheErreur(c.enregistreArrivee(2), 2, "Classement");
		afficheErreur(c.enregistreDisqual(2), 2, "Disqualification");
		c.enregistreArrivee(3);
		c.enregistreDisqual(3);
		afficheErreur(c.enregistreDisqual(3), 3, "Disqualification");
		afficheErreur(c.enregistreAbandon(3), 3, "Abandon");
		c.enregistreArrivee(4);
		c.enregistreAbandon(8);
		c.enregistreDisqual(6);
		afficheErreur(c.enregistreArrivee(6), 6, "Classement");
		afficheErreur(c.enregistreAbandon(8), 8, "Abandon");
	    c.afficheParticipants();
	    
	    c.afficheClasses();
	    c.afficheAbandons();
	    c.afficheDisqualifications();
	    
	
	}

}
