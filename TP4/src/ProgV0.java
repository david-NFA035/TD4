
public class ProgV0 {

	/**
	 * Gestion d'evenements d'une course (code a completer)
	 *  - pas de menu
	 *  - gestion d'erreurs avec codes d'erreurs (sans exceptions)
	 *  Version V0
	 */
	
    
    
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
		c.enregistreArrivee(3);
		c.afficheParticipants();
		c.enregistreAbandon(2);
		c.enregistreArrivee(2);
		c.enregistreDisqual(2);
		c.enregistreArrivee(3);
		c.enregistreDisqual(3);
		c.enregistreDisqual(3);
		c.enregistreAbandon(3);
		c.enregistreArrivee(4);
		c.enregistreAbandon(8);
		c.enregistreDisqual(6);
		c.enregistreArrivee(6);
		c.enregistreAbandon(8);
	    c.afficheParticipants();
	    
	    c.afficheClasses();
	    c.afficheAbandons();
	    c.afficheDisqualifications();
	    
	
	}

}
