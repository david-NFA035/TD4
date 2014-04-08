import java.util.ArrayList;
import java.util.Iterator;


public class exo1 {

	public static void main(String[] args) {
		ArrayList<String> ls = new ArrayList<String>();
		String[] tab = {"1", "2", "3", "4", "5", "6"};
		for (String s : tab){
			ls.add(s);
		}
		afficheListeSt(ls);
		ls.set(3, "element remplace");
		afficheListeSt(ls);
		ls.add(2, "element ajoute");
		afficheListeSt(ls);
		ls.remove(1);
		afficheListeSt(ls);
		//ls.remove(10); // leve java.lang.IndexOutOfBoundsException
		//ls.add(20, "element ajoute"); // leve java.lang.IndexOutOfBoundsException
		
		//question 2
		
		boolean b = ls.contains("4");
		System.out.println("Contient \"4\" ? " + b);
		b = ls.contains("3");
		System.out.println("Contient \"3\" ? " + b);
		
		int index = ls.indexOf("4");
		if(index == -1){
			System.out.println("Ne contient pas \"4\"");
		}
		else{
			System.out.println("Contient \"4\" à la position " + index);
		}
		
		index = ls.indexOf("3");
		if(index == -1){
			System.out.println("Ne contient pas \"3\"");
		}
		else{
			System.out.println("Contient \"3\" à la position " + index);
		}
		ls.add("1");
		afficheListeSt(ls);
		
		int lastIndex = ls.lastIndexOf("1");
		if (lastIndex== -1){
			System.out.println("Ne contient pas \"1\"");
		}
		else{
			System.out.println("Derniere occurence de \"1\" : " + lastIndex);
		}
		
		ArrayList<Cell> lc = new ArrayList<Cell>();
		Cell c1= new Cell(1);
		Cell c2= new Cell(2);
		Cell c3= new Cell(3);
		Cell c4= new Cell(4);
		Cell c5= new Cell(5);
		lc.add(c1);
		lc.add(c2);
		lc.add(c3);
		lc.add(c4);
		lc.add(c5);
		Cell.afficheListeCe(lc);
		
		// Comparez le comportement de ce code:
		Cell autreTrois = new Cell(3); // on cree ici un nouvel objet inconnu de lc
		if (lc.contains(autreTrois)) // le test ici retourne false
		    System.out.println("Nouvelle cellule 3 dedans.");
		else
		    System.out.println("Nouvelle cellule 3 pas dedans.");
		int nindex = lc.indexOf(autreTrois); // retourne -1 (index negatif pour signaler l'absence)
		    System.out.println("Indice trouve pour nouvelle cellule 3: "+ nindex);
		
		    // Avec celui-ci
		Cell trois = lc.get(4); // on recupere une reference a un objet Cell de lc
		if (lc.contains(trois)) // cet objet est bien contenu dans lc
		    System.out.println("Cellule de meme adresse dedans");
		else
		    System.out.println("Pas dedans.");
		int index3 = lc.indexOf(trois); // sans surprise son index est egal au parametre du get(index)
		System.out.println("Indice trouve pour cellule meme adresse: "+ index3);


	}
	
	public static void afficheListeSt(ArrayList<String> l){
		Iterator<String> it = l.iterator();
		String sortie = "{";
		while (it.hasNext()){
			sortie += "\"" + it.next() + "\", ";
		}
		sortie += "}";
		System.out.println(sortie);
	}

}
