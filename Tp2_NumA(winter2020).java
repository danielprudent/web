class Employe {
	

	private String NAS; // 200 101 122 Numero Ass Social 
	double salaire; // ex : 40$/h ou 4000$ par semaine (default)
			                    
			
	public Employe(String NAS, double salaire)
	{
		this.NAS  = NAS; // ce this est obligatoire
		this.salaire = salaire; // ce this est obligatoire
	//	this.globale  = globale; // ce this est optionnel (facultatif)
	}
	
	public Employe(String NAS, double horaire, double heure)
	{
		this.NAS = NAS;
		this.salaire = horaire * heure;
		 
	}
	public Employe(String NAS)
	{
		this(NAS,1250.25); // salaire par défaut
	}

	public void afficher(String message)  { // message pour le tableau
	  	System.out.printf(" %sNAS : %s | salaire : %.2f", message , NAS, salaire);
	 }
	
	public void setsalaire(double sal)
	{
		this.salaire =  sal;
		 

		
	}
	public double getsalaire()
	{
		return salaire ;
		 

		
	}
	public String getNAS() // pour date de l'etudiant 
	{
		return NAS;
	}
	
	public String toString() {
		return String.format("\n	%s  -	%.2f", NAS, salaire);
	}
	
	public boolean estInferieur()
	{		
		return NAS.compareTo(NAS) < 0;
	}
} // Fin class employe


public class TestEmploye {

	static void afficher (Employe[] emp, String mess) { // methode pour afficher les etudiant tableau 
	    System.out.printf("Contenu du tableau %s :\n", mess);
		for(int i = 0; i < emp.length; i++) {
			System.out.println(i + ")" + "\t" + emp[i].getNAS() + "\t" + emp[i].getsalaire() + "$");
			
		}    		   
	    System.out.printf("\n\n");
	}
	
	static void trier (Employe[] emp, int nbEtud) // pour trier selon l'annee de naissance 
	{
		for(int i = 0; i < nbEtud-1; i++)
		{
			int indMin = i ;
			for(int j = i+1; j < nbEtud; j++)
				if ( emp[j].getNAS().compareTo(emp[indMin].getNAS()) < 0)
					         indMin = j;
		    if (indMin != i)
		    {
		    	Employe tempo = emp[i];
		    	emp[i] = emp[indMin];
		    	emp[indMin] = tempo;
		    }
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		Employe emp1 = new Employe("250 642 753", 1234.56), 
		        emp2 = new Employe("123 456 789"), // par défaut 1250.25$
		        emp3 = new Employe("250 343 678", 40.00, 25.75),
		        // salHebdo = 40 heures par semaine x taux d’horaire 25.75$
		        emp4 = new Employe("450 279 321", 1750.75);

		
		 // afficher toutes les infos de emp3:
	      emp3.afficher("2- Information de l'employé 3 : \n");
	      System.out.printf("\n\n");
	      
	      // afficher toutes les infos de emp4:
	      emp4.afficher("2- Information de l'employé 4 : \n");
	      System.out.printf("\n\n");
	      
		  emp2.setsalaire(emp3.getsalaire()+emp1.getsalaire());
		// afficher toutes les infos de emp4:
	      emp2.afficher("3- Information de l'employé 2 : \n");
	      System.out.printf("\n\n");
		
	      /*
	      i        emp[i]
          0       "250 642 753"        1234.25$
          1       "123 456 789"        1250.25$ (par défaut)
          2       "250 343 654"        40 hrs au taux de 17.25$ de l’heure
          3       "231 467 890"        1671.50$
          4       "478 343 689"        1750.75$
          5       "371 238 432"        50 hrs au taux de 20.25$ de l’heure

	        
	       */
	      Employe [] emp  = {new Employe ("250 642 753", 1234.56), 
	    		  			 new Employe ("123 456 789", 1250.25), 
	    		  			 new Employe ("250 343 654", 40, 17.25), 
	    		  			 new Employe ("231 467 890", 1671.50), 
	    		  			 new Employe ("478 343 689", 1750.75), 
	    		  			 new Employe ("371 238 432", 50, 20.25)};
		
		
	      int nbEtud = emp.length;
	      afficher (emp, "\n1- Au debut");
	      System.out.printf("%s", emp[0]);
	      System.out.printf("%s", emp[1]);
	      System.out.printf("%s", emp[2]);
	      System.out.printf("%s", emp[3]);
	      System.out.printf("%s", emp[4]);
	      System.out.printf("%s", emp[5]);
	      
	      
	      
	      
	      trier(emp, nbEtud);
	      afficher(emp, "\n4- Apres le tri selon NAS");
		   
	}

}
