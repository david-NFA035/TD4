import java.util.ArrayList;
import java.util.Iterator;


public class Cell {
	private int num;
	public Cell(int i){
		this.num = i;
	}
	public int getNum(){
		return num;
	}
	public void afficher(){
		System.out.println(num);
	}
	public static void afficheListeCe(ArrayList<Cell> l){
		Iterator<Cell> it = l.iterator();
		String sortie = "{";
		while (it.hasNext()){
			sortie += it.next().getNum() + ", ";
		}
		sortie += "}";
		System.out.println(sortie);
	}
}
