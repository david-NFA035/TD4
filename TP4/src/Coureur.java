
public class Coureur {
	/* Participant d'une course 
	 * avec nom et no. de dossard
	 */
   private String nom;
   private int numDossard;
   private Statut stat;
   public Coureur(String n, int d){
	   nom=n; numDossard =d; stat = Statut.DansCourse ;
   }
   public String getNom(){ return nom;}
   public Statut getStatus() { return stat;}
   public int getNumDossard(){ return numDossard;}
  
   /** Change le statut d'un coureur vers le statut @param s
    * @return code d'erreur si 
    * changement  impossible
   * 0  (pas d'erreur)
   * 2 s'il est deja dans les arrives
   * 3 s'il a deja abandonne
   * 4 s'il est deja disqualifie
 * @throws ExceptionDejaArrive 
 * @throws ExceptionDejaAbandon 
 * @throws ExceptionDejaDisqual 
   **/
   public void changeStatus(Statut s) throws ExceptionDejaArrive, ExceptionDejaAbandon, ExceptionDejaDisqual {
	   if (this.getStatus() == Statut.Arrive) {
			if (s == Statut.Disqualification) { 
				this.stat = s;
			} else {
				throw new ExceptionDejaArrive();
			}
		} else if (this.getStatus() == Statut.Abandon)  {
			throw new ExceptionDejaAbandon();
		} else if (this.getStatus() == Statut.Disqualification) {
			throw new ExceptionDejaDisqual();
		} else if (this.stat == Statut.DansCourse){
			this.stat = s;
		}
   }
   public String toString() { return ("   No."+ numDossard + ": "+ nom + ", status: "+ stat);}
   
   public void affiche() {
	   Terminal.ecrireStringln(this.toString());
   }
}

class ExceptionDejaArrive extends Exception{}
class ExceptionDejaAbandon extends Exception{}
class ExceptionDejaDisqual extends Exception{}
