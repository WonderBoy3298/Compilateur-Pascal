package compilateur;

public enum CodesErr {

	CAR_INC_ERR(" caractère inconnu "),
	FIC_VIDE_ERR(" Fichier Vide ") ,
	PROGRAM_ERR(" Erreur du programme "),
	ID_ERR(" Identificateur attendu "),
	PVIR_ERR(" Symbol attendu ") ,
	CONST_ERR("il y a pas de const"),
	EGAL_ERR("besoin d'affectation "),
	VAR_ERR("besoin de Var") , 
	VIR_ERR("besoin de virgule") ,
	BEGIN_ERR("mot cle Begin ") ,
	END_ERR("mot cle End "),
	IF_ERR("besoin de if "),
	MUL_ERR("multplication erreur"),
	DIV_ERR("Division erreur"),
	PLUS_ERR("plus erreur"),
	MOINS_ERR("moins erreur"),
	WhileErreur("while erreur"),
	DO_ERR("do erreur") ,
	INF_ERR("INfreeir erreur") ,
	INFEG_ERR("inferrieur ou egal "),
	INFSUP_ERR("Supperieur ou egal") ,
	DIFF_ERR("diffrence  erreur"),
	EG_ERR("Egale erreur"),
	PARD_ERR("Besoin de parenthese droite  ") ,
	PARG_ERR("besoin de parenthese gauche") ,
	ID_DEFINED_ERR("id est deja declarer ") ,
	CONST_MODIF("Constante ne doit pas etre modifier ") ; 
	
	
	private String  message ; 
	private CodesErr(String mess) {
		message=mess ;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
