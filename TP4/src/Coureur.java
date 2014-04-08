
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
   **/
   public int changeStatus(Statut s) {
	   int err = 0; 
	   if (this.getStatus() == Statut.Arrive) {
			if (s == Statut.Disqualification) { 
				this.stat = s;
			} else {
				err = 2; // deja arrive
			}
		} else if (this.getStatus() == Statut.Abandon)  {
			err = 3; // deja abandonne
		} else if (this.getStatus() == Statut.Disqualification) {
			err = 4; // deja disqualifie
		} else if (this.stat == Statut.DansCourse){
			stat = s;
		}
		return err;
   }
   public String toString() { return ("   No."+ numDossard + ": "+ nom + ", status: "+ stat);}
   
   public void affiche() {
	   Terminal.ecrireStringln(this.toString());
   }
}
