package compilateur;

import java.io.IOException;







public class ParserWs extends Parser {

	
	
	ScannerWs scanner2 ;
	
	
	public ParserWs(String filePath) throws IOException {
		super(filePath);
		
	}
	
	public void Test_Cherche(Tokens tk,CodesErr e ) throws IOException {
		
		if(scanner2.getSymbcour().getToken()==tk) {
			scanner2.chercher_Symbol();
			
			scanner2.Symbol_Suivant() ; 
			
		}
			
	}

	
public void Test_Insere(Tokens tk , ClasseIdf idf ,CodesErr cd_err) throws IOException, ErreurSemantique {
		
		if(scanner2.Symbcour.getToken().equals(tk)) {	
			scanner2.chercher_Symbol();
			// le symboles ne doit pas etre deja dans la table 
			if(scanner2.getPlace_SYMB()!=-1) {
				
				scanner2.addSymbol(idf);
				scanner2.Symbol_Suivant();
			
			}
		}else {
			
			throw new ErreurSemantique(CodesErr.ID_DEFINED_ERR) ; 
		}
		
		
		
	}






@Override
public void  program() throws ErreurSyntaxique, IOException, ErreurSemantique   {
	
	testAccepte(Tokens.PROGRAM_TOKEN,CodesErr.PROGRAM_ERR);
	Test_Insere(Tokens.ID_TOKEN,ClasseIdf.CONSTANTE,CodesErr.ID_ERR) ;
	testAccepte(Tokens.PVIR_TOKEN,CodesErr.PVIR_ERR) ;
	block();
	testAccepte(Tokens.PNT_TOKEN,CodesErr.PROGRAM_ERR);

}



@Override
public void consts() throws IOException, ErreurSyntaxique, ErreurSemantique {
	
	testAccepte(Tokens.CONST_TOKEN,CodesErr.CONST_ERR);
	
	while(scanner2.getSymbcour().getToken()==Tokens.ID_TOKEN) {
		Test_Insere(Tokens.ID_TOKEN,ClasseIdf.CONSTANTE,CodesErr.ID_ERR) ;
		testAccepte(Tokens.EG_TOKEN,CodesErr.EGAL_ERR) ;
		testAccepte(Tokens.NUM_TOKEN,CodesErr.CONST_ERR);
		testAccepte(Tokens.PVIR_TOKEN,CodesErr.PVIR_ERR) ; 
	}
		// const a=12;b=13;
}


@Override
public  void var() throws IOException {
	 // var a,b,w ; 
	testAccepte(Tokens.VAR_TOKEN,CodesErr.VAR_ERR) ;
	Test_Insere(Tokens.ID_TOKEN,ClasseIdf.VARIABLE,CodesErr.ID_ERR) ; 
	
	while(sCanner.getSymbCour().getToken()==Tokens.VIR_TOKEN) {
		testAccepte(Tokens.VIR_TOKEN,CodesErr.VIR_ERR) ;
		Test_Insere(Tokens.ID_TOKEN,ClasseIdf.VARIABLE,CodesErr.ID_ERR) ; 
	}
	testAccepte(Tokens.PVIR_TOKEN,CodesErr.PVIR_ERR);
	
}


@Override
public void affect() throws IOException, ErreurSemantique {
	
	// a :=b ; 
	scanner2.chercher_Symbol();

	//regle 4 
	if(scanner2.getTableSymbol().get(scanner2.Place_SYMB  ).getidf() == ClasseIdf.CONSTANTE ) {
	
		throw new ErreurSemantique(CodesErr.ID_DEFINED_ERR) ; 	}
	
	testAccepte(Tokens.VAR_TOKEN,CodesErr.VAR_ERR) ;
	testAccepte(Tokens.PVIR_TOKEN,CodesErr.PVIR_ERR) ;
	this.exprs() ; 
	
	
}

@Override 
protected void lire() throws IOException, ErreurSemantique {

	////read(a,b,c) ne pas lire une constante 
	
	testAccepte(Tokens.READ_TOKEN,CodesErr.VIR_ERR) ; 
	testAccepte(Tokens.PARD_TOKEN,CodesErr.PARD_ERR);
	
	scanner2.chercher_Symbol() ;
	//regle 3 et 4 
	if( scanner2.getTableSymbol().get(scanner2.Place_SYMB).getidf() != ClasseIdf.CONSTANTE && scanner2.Place_SYMB != -1  ) {
		
		testAccepte(Tokens.ID_TOKEN,CodesErr.ID_ERR) ; 
		while(scanner2.getSymbcour().getToken()==Tokens.VIR_TOKEN ) {
		
			testAccepte(Tokens.VIR_TOKEN,CodesErr.VIR_ERR) ; 
			if( scanner2.getTableSymbol().get(scanner2.Place_SYMB).getidf() != ClasseIdf.CONSTANTE && scanner2.Place_SYMB != -1) {
			testAccepte(Tokens.ID_TOKEN,CodesErr.ID_ERR) ; 
			}
			else {
			
				throw new ErreurSemantique(CodesErr.CONST_MODIF) ; 
		
			}
		
	}
		
		
	}
	else {
	
		throw new ErreurSemantique(CodesErr.CONST_MODIF) ; 	
	}
	
	
}
	
	

	
	
}

//BY WONDER_BOY
