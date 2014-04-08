import java.util.*;

/** Gestion d'evenement d'une course
 * 
 **/
public class Course {
	private ArrayList<Coureur> participants = new ArrayList<Coureur>(); 
	private ArrayList<Coureur> arrives = new ArrayList<Coureur>();
    	
    public int getNbParticipants() { return participants.size();}
    
    /** Enregistre un nouveau coureur de no @param nc 
     *  parmi les participants.
     **/
    public void opInscritCoureur(String nc){
    	Coureur c = new Coureur(nc,participants.size()+1);
    	participants.add(c);
    }
    
    /** Teste si le numero de dossard @param nd 
     * est compris entre [1..N] avec N nombre de participants.
     **/
    public boolean dossardValide(int nd){
    	return (nd > 0 && nd <= participants.size());
    }

    /** Enregistre le coureur de dossard @param nd dans la liste des arrivees.
     * pre: suppose @param nd correspond a un dossard valide dans [1..N]
     * @return code d'erreur:
     * 0 si pas d'erreur
     * 2 s'il est deja dans les arrives
     * 3 s'il a deja abandonne
     * 4 s'il est deja disqualifie
     **/
    public void enregistreArrivee(int nd){
    	try{
    	    participants.get(nd-1).changeStatus(Statut.Arrive);
    	    arrives.add(participants.get(nd-1));
    	}catch (Exception e){
    		if (e instanceof ExceptionDejaArrive){
    		    afficheErreur(2, nd, "classement");
    	    }
    		else if (e instanceof ExceptionDejaAbandon){
		        afficheErreur(3, nd, "classement");
	        }
    		else if (e instanceof ExceptionDejaDisqual){
	            afficheErreur(4, nd, "classement");
            }
    	}
    }
  
    /** Enregistre abandon pour le dossard @param nd
     * pre: Suppose que le numero @param nd correspond a un dossard valide.
     * @return code d'erreur  si abandon impossible.
     */
    public void enregistreAbandon(int nd){
    	try{
    	    participants.get(nd-1).changeStatus(Statut.Abandon);
    	}catch (Exception e){
    		if (e instanceof ExceptionDejaArrive){
    		    afficheErreur(2, nd, "abandon");
    	    }
    		else if (e instanceof ExceptionDejaAbandon){
		        afficheErreur(3, nd, "abandon");
	        }
    		else if (e instanceof ExceptionDejaDisqual){
	            afficheErreur(4, nd, "abandon");
            }
    	}
    }
    /** Enregistre disqualification dossard @param nd.
     * pre: @param nd numero de dossard valide.
     * @return code d'erreur si disqualification impossible.
     **/
    public void enregistreDisqual(int nd){
    	try{
    	    participants.get(nd-1).changeStatus(Statut.Disqualification);
    	}catch (Exception e){
    		if (e instanceof ExceptionDejaArrive){
    		    afficheErreur(2, nd, "disqualification");
    	    }
    		else if (e instanceof ExceptionDejaAbandon){
		        afficheErreur(3, nd, "disqualification");
	        }
    		else if (e instanceof ExceptionDejaDisqual){
	            afficheErreur(4, nd, "disqualification");
            }
    	}
    }
  
    /****   Operations d'affichage *****/
    /** Affiche le message @param m 
     * suivi de la liste de coureurs dans @param lc 
     **/
    private static void afficheListe(String m,  ArrayList<Coureur> lc){
    	Terminal.ecrireStringln(m);
    	Terminal.ecrireStringln("-----------------------");
    	if (lc.size()==0) {
    	  	Terminal.ecrireStringln("  ==> aucun");
    	  	return;
    	}
    	for (int i=0; i< lc.size(); i++) {
      	  lc.get(i).affiche();
        }	
    	Terminal.sautDeLigne();
    }
    
    public void afficheParticipants(){
    	afficheListe("Participants a la course", participants);   	
    }
    
    /** Affiche le message @param m 
     * suivi de la liste de tous les coureurs de @param lc 
     * qui ont le @param statut s 
     **/
    private static void afficheListeStat(String m, ArrayList<Coureur> lc, Statut s){
    	// Remplacer le throw par votre code!!!
    	throw new Error("Remplacer ce throw par votre implantation.");
    }
    /** Affiche la liste de coureurs classes */
    public void afficheClasses(){
    	System.out.println("\nListe des coureurs classes :\n");
    	for(Coureur c : arrives){// ou "for(Coureur c : participants){" : le resultat est le meme
    		if (c.getStatus() == Statut.Arrive){
    			c.affiche();
    		}
    	}
    }
    /** Affiche la liste de coureurs ayant abandonne */
    public void afficheAbandons(){
    	System.out.println("\nListe des coureurs ayant abandonne :\n");
    	for(Coureur c : participants){
    		if (c.getStatus() == Statut.Abandon){
    			c.affiche();
    		}
    	}
    }
    
    /** Affiche la liste de coureurs disqualifies */
    public void afficheDisqualifications(){
    	System.out.println("\nListe des coureurs disqualifies :\n");
    	for(Coureur c : participants){
    		if (c.getStatus() == Statut.Disqualification){
    			c.affiche();
    		}
    	}
    }
    /** Affiche le gagnant (s'y il en a un)
     * ou un message si pas de gagnant 
     */
    public void afficheGagnant(){
    	// Remplacer le throw par votre code!!!
    	throw new Error("Remplacer ce throw par votre implantation.");
    }
    
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
}
