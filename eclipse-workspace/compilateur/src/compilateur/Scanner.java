package compilateur;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList ;




public class Scanner {

	protected ArrayList<Symboles> motsCle = new ArrayList() ; 
	protected char car_cour ; 
	protected Symboles Symbcour ; 
	
	public Symboles getSymbcour() {
		return Symbcour;
	}

	public void setSymbcour(Symboles symbcour) {
		Symbcour = symbcour;
	}

	protected FileReader fluxSour ; 
	
	public Scanner(String file) throws IOException {
	 	File fichier = new File(file);
	 	fluxSour=new FileReader(fichier);
	 	
	 	motsCle=new ArrayList() ;
		
}
	
	public void initMotsCles() {
		
		 this.motsCle.add(
	                new Symboles(Tokens.PROGRAM_TOKEN, "program")
	        );
	        this.motsCle.add(
	                new Symboles(Tokens.CONST_TOKEN, "const")
	        );
	        this.motsCle.add(
	                new Symboles(Tokens.VAR_TOKEN, "var")
	        );
	        this.motsCle.add(
	                new Symboles(Tokens.BEGIN_TOKEN, "begin")
	        );
	        this.motsCle.add(
	                new Symboles(Tokens.END_TOKEN, "end")
	        );
	        this.motsCle.add(
	                new Symboles(Tokens.IF_TOKEN, "if")
	        );
	        this.motsCle.add(
	                new Symboles(Tokens.THEN_TOKEN, "then")
	        );
	        this.motsCle.add(
	                new Symboles(Tokens.WHILE_TOKEN, "while")
	        );
	        this.motsCle.add(
	                new Symboles(Tokens.DO_TOKEN, "do")
	        );
	        this.motsCle.add(
	                new Symboles(Tokens.WRITE_TOKEN, "write")
	        );
	        this.motsCle.add(
	                new Symboles(Tokens.READ_TOKEN, "read")
	        );
	        
	}
	
	
	 public Tokens Codage_lexical(String nom) {
     	
		for(Symboles symbole:motsCle) {
			if(symbole.getNom() == nom ) {
				return symbole.getToken() ; 
			}
		}
		return Tokens.ID_TOKEN ; 
		 
		 
     }
	 
	 
	 public void LireCar() throws IOException {
		 
		  
		 
		 int a = fluxSour.read() ; 
		 car_cour = (char)(a == -1?-1:a) ; 
		 
	 }
	 
	
		public void Liremot() throws IOException {
			StringBuffer mot=new StringBuffer();
			LireCar();
			//charactere est  un Wrraper 
			while(Character.isDigit(car_cour) || Character.isLetter(car_cour)) {
				mot.append(car_cour) ; 
				LireCar();
			
			}
			// ici on a creer un nouveau symbole et le symbole a deux arg un de type token et l autre de type string 
			// mot et de type string buffer alors on l a changer a string grace a la methode to_string
			Symbcour=new Symboles(Codage_lexical(mot.toString()),mot.toString());
			
		
		}
		
		public void LireNombre() throws IOException {
			
			// 9362
			
			StringBuffer nombre = new StringBuffer() ; 
			LireCar();
			while(Character.isDigit(car_cour)) {
				nombre.append(car_cour) ; 
				LireCar() ; 
			}
			
			Symbcour = new Symboles(Codage_lexical(nombre.toString()),nombre.toString())  ;
			
			
		}
		
		public void Symbol_Suivant() throws IOException {
			if(Character.isLetter(car_cour)) {
				Liremot() ;
			}else if(Character.isDigit(car_cour)) {
				LireNombre() ;
			}
			else {
				switch(car_cour) {
				case '+':
					Symbcour=new Symboles(Tokens.PLUS_TOKEN,"+");
				
				case '<':
					this.LireCar();
					if (car_cour=='>') {
						Symbcour= new Symboles(Tokens.DIFF_TOKEN,"<>");
					}
					else if(car_cour=='=')
						Symbcour= new Symboles(Tokens.INFEG_TOKEN,"<=");
						
					else{
						Symbcour= new Symboles(Tokens.INF_TOKEN,"<") ; 
					}
				
				case '>':
					LireCar();
					if(car_cour=='=') {
						Symbcour= new Symboles(Tokens.SUPEG_TOKEN,">=") ;
					}
					
				
				}
			}
			
			
		}
	
		
}



//BY WONDER_BOY
