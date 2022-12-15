package compilateur;

import java.io.IOException;
import java.util.Arrays;

import compiateurv2.CODES_ERREUR;
import compiateurv2.Tokens;


public class Parser {

	Scanner scann ;

	public Scanner getScann() {
		return scann;
	}

	public void setScann(Scanner scann) {
		this.scann = scann;
	} 
	
	public Parser(String file) throws IOException {
		
		scann = new Scanner(file) ; 
		
	}

	public void testAccepte(Tokens tk,CodesErr err) throws ErreurSyntaxique, IOException{
		
		if(scann.getSymbcour().getToken()==tk) {
			
			scann.Symbol_Suivant();
			
		}
		else {
			throw new ErreurSyntaxique(err) ; 
		}
		

	
	}
	
	

	public void  program() throws ErreurSyntaxique, IOException {
		
		testAccepte(Tokens.PROGRAM_TOKEN,CodesErr.PROGRAM_ERR);
		testAccepte(Tokens.ID_TOKEN,CodesErr.ID_ERR) ;
		testAccepte(Tokens.PVIR_TOKEN,CodesErr.PVIR_ERR) ;
		block();
		testAccepte(Tokens.PNT_TOKEN,CodesErr.PROGRAM_ERR);
	}
	
	public void consts() throws ErreurSyntaxique, IOException {
		testAccepte(Tokens.CONST_TOKEN,CodesErr.CONST_ERR);
		
		
		while(scann.getSymbcour().getToken()==Tokens.ID_TOKEN)
		testAccepte(Tokens.ID_TOKEN,CodesErr.ID_ERR) ;
		testAccepte(Tokens.EG_TOKEN,CodesErr.EGAL_ERR) ;
		testAccepte(Tokens.NUM_TOKEN,CodesErr.CONST_ERR);
	}

	public  void var() throws ErreurSyntaxique, IOException {
		
		testAccepte(Tokens.VAR_TOKEN,CodesErr.VAR_ERR) ;
		testAccepte(Tokens.ID_TOKEN,CodesErr.ID_ERR) ;
		
		while(scann.getSymbcour().getToken()==Tokens.VIR_TOKEN) {
			testAccepte(Tokens.VIR_TOKEN,CodesErr.VIR_ERR) ;
			testAccepte(Tokens.ID_TOKEN,CodesErr.ID_ERR);
		}
		testAccepte(Tokens.PVIR_TOKEN,CodesErr.PVIR_ERR);
		
	
	}

	public void block() throws ErreurSyntaxique, IOException {
		
		consts();
		var();
		insts();

		
	}
	
public void insts() throws ErreurSyntaxique, IOException {
		
		testAccepte(Tokens.BEGIN_TOKEN,CodesErr.BEGIN_ERR);
		inst();
		while(scann.getSymbcour().getToken()==Tokens.PVIR_TOKEN) {
			
			testAccepte(Tokens.PVIR_TOKEN,CodesErr.PROGRAM_ERR);
			inst();
			
		}
		
		testAccepte(Tokens.END_TOKEN,CodesErr.END_ERR);
		
	}


public void inst() throws ErreurSyntaxique, IOException {
	
	switch(scann.getSymbcour().getToken()) {
	   case BEGIN_TOKEN : this.insts();
       case ID_TOKEN : this.affect();
       case READ_TOKEN : this.lire();
       case WRITE_TOKEN : this.ecrire();
       case IF_TOKEN : this.si();
       case WHILE_TOKEN : this.tantQue();}
	
	
	}

private void tantQue() throws ErreurSyntaxique, IOException {
	// TODO Auto-generated method stub
	testAccepte(Tokens.WHILE_TOKEN,CodesErr.WhileErreur) ;
	condition() ; 
	testAccepte(Tokens.PARD_TOKEN,CodesErr.PARD_ERR) ;

}

private void condition() throws ErreurSyntaxique, IOException {
	// TODO Auto-generated method stub
	this.exprs();
	this.operateur();
	this.exprs();
}

private void si() throws ErreurSyntaxique, IOException {

	
	// TODO Auto-generated method stub
	testAccepte(Tokens.IF_TOKEN,CodesErr.IF_ERR) ; 
	testAccepte(Tokens.PARG_TOKEN,CodesErr.PARG_ERR) ; 
	condition() ;
	testAccepte(Tokens.PARD_TOKEN,CodesErr.PARD_ERR) ;


}





private void ecrire() {

	// write("hamza alaoui ") ; 

}

private void lire() throws ErreurSyntaxique, IOException {
	testAccepte(Tokens.READ_TOKEN,CodesErr.VIR_ERR) ; 
	testAccepte(Tokens.PARD_TOKEN,CodesErr.PARD_ERR);
	
	testAccepte(Tokens.ID_TOKEN,CodesErr.ID_ERR) ; 
	while(scann.getSymbcour().getToken() == Tokens.VIR_TOKEN) {
		testAccepte(Tokens.ID_TOKEN,CodesErr.ID_ERR);
		testAccepte(Tokens.PARD_TOKEN,CodesErr.PARD_ERR);
		
		
	}
	testAccepte(Tokens.PVIR_TOKEN,CodesErr.PVIR_ERR);
	
	
}


public void affect() throws ErreurSyntaxique, IOException {
	testAccepte(Tokens.VAR_TOKEN,CodesErr.VAR_ERR) ; 
	testAccepte(Tokens.AFFEC_TOKEN,CodesErr.ID_ERR) ; 
	exprs() ;
	
	
	
}

public void exprs() throws ErreurSyntaxique, IOException {
	
	Tokens[] tks= {Tokens.PLUS_TOKEN,Tokens.MOINS_TOKEN,Tokens.DIV_TOKEN,Tokens.MUL_TOKEN} ; 
	this.term();
	if(	Arrays.asList(tks).contains(scann.getSymbcour().getToken())) {
		operateur();
		this.term();
		
	}

		}
		
public void term() throws ErreurSyntaxique, IOException {
	
	switch(scann.getSymbcour().getToken()) {
	case ID_TOKEN : testAccepte(Tokens.ID_TOKEN,CodesErr.ID_ERR);
	case NUM_TOKEN: testAccepte(Tokens.NUM_TOKEN,CodesErr.BEGIN_ERR);
	case PARG_TOKEN:{ exprs();testAccepte(Tokens.PARD_TOKEN,CodesErr.PROGRAM_ERR); }
	
	
	}
}
	
	public void operateur() {
		
		switch(scann.getSymbcour().getToken()) {
		case PLUS_TOKEN: testAccepte(Tokens.PLUS_TOKEN,);
		case MOINS_TOKEN : testAccepte(Tokens.MOINS_TOKEN,CodesErr.PROGRAM_ERR) ;
		case MUL_TOKEN : testAccepte(Tokens.MUL_TOKEN,CodesErr.MUL_ERR) ;
		case DIV_TOKEN : testAccepte(Tokens.DIV_TOKEN,CodesErr.DIV_ERR) ;
		
		}
	}

}



//BY WONDER_BOY



