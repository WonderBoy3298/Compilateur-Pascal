package compilateur;

import java.io.IOException;
import java.util.ArrayList;




public class ScannerWs extends Scanner {

	public ScannerWs(String file) throws IOException {
		super(file);
	}

	protected ArrayList<Symboles> TableSymbol ; 
	
	protected  int Place_SYMB;
	
	
//Getters and Setters 	
public ArrayList<Symboles> getTableSymbol() {
		return TableSymbol;
	}

	public void setTableSymbol(ArrayList<Symboles> tableSymbol) {
		TableSymbol = tableSymbol;
	}

	public int getPlace_SYMB() {
		return Place_SYMB;
	}


	public void setPlace_SYMB(int place_SYMB) {
		Place_SYMB = place_SYMB;
	}






		// methode pour entrer un Symbole
		public void addSymbol(ClasseIdf id) {
	
				TableSymbol.add(new Symboles(Symbcour.getToken(),super.Symbcour.getNom(),id)) ;
}
		
		
		public void chercher_Symbol() {

				Place_SYMB= (TableSymbol.contains(super.Symbcour))?TableSymbol.indexOf(super.Symbcour):-1 ;  


}


	
}
//BY WONDER_BOY
