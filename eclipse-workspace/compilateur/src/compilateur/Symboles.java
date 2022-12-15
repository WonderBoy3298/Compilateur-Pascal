package compilateur;

public class Symboles {
	
	Tokens token ; 
	String nom ;
	ClasseIdf idf ; 
	
	
	// Constructeur avec token et nom 
	Symboles(Tokens t  , String n ){
		token = t ; 
		nom = n ;
		
	}
	
	
	public ClasseIdf getidf() {
		return this.idf ; 
	}
	
	// Constructeur avec token nom et identificateur
	
	Symboles(Tokens t , String n , ClasseIdf identificateur){
		token = t ; 
		nom = n ;
		idf = identificateur ; 
	}
	
	
	public Tokens getToken() {
		return token;
	}
	
	public void setToken(Tokens token) {
		this.token = token;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	} 
	
	
}





//BY WONDER_BOY
