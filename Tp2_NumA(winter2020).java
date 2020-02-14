/*
 * Fait par Daniel Prudent ; IFT1170
 * polymorphisme, this, toString, fichier de type texte : a utiliser durant
 * Ce TP
 * On dispose de la classe incomplète Employe suivante : 
		class Employe et aussi TestPErsonne qui contient le main 
		1)  Écrivez les constructeurs utilisant de this pour instancier les 4 employés suivants :

2) Écrivez la méthode afficher appropriée puis on l’utilise pour afficher les informations de emp3 et 
    emp4;

3) Modifiez le salaire de emp2 : c’est la somme de salaires de emp1 et emp3. On affiche les 
     informations de emp2 ;

4) Écrivez la déclaration et l’initiation d’un tableau de 6 employés dont le contenu est le 
  suivant :
5) Écrivez de méthode(s) et leur(s) appel(s) pour compter puis afficher le nombre 
    d’employés : 
a) qui gagnent moins de 1300.00$ par semaine dont le NAS contient  ‘5’ 
b) qui gagnent moins de 750.00$ par semaine dont le NAS contient ‘3’
6) Triez le tableau (le tri par sélection) selon les NAS de ces 6 employés;

7) Créez le fichier texte "empTri.dta" dont le format est à votre imagination.
Les 7 numero sont parfaitement inscrit durant l'execution et en commentaire 
*/
class Employe {
	

	private String NAS; // 200 101 122 Numero Ass Social 
	double salaire; // ex : 40$/h ou 4000$ par semaine (default)
			                    
			
	public Employe(String NAS, double salaire)
	{
		this.NAS  = NAS; // ce this est obligatoire
		this.salaire = salaire; // ce this est obligatoire
	//	this.globale  = globale; // ce this est optionnel (facultatif)
	}
	
	public Employe(String NAS, double horaire, double heure) // constructeur pour deux variable horaire et heure 
	{
		this.NAS = NAS;
		this.salaire = horaire * heure;
		 
	}
	public Employe(String NAS) // constructeur pour salaire par defaut 
	{
		this(NAS,1250.25); // salaire par défaut
	}

	public void afficher(String message)  { // message pour le tableau
	  	System.out.printf(" %sNAS : %s | salaire : %.2f", message , NAS, salaire);
	 }
	
	public void setSalaire(double sal) // constructeur pour modifier salaire
	{
		this.salaire =  sal;
		 

		
	}
	public double getSalaire() // constructeur pour l'acces salaire
	{
		return salaire ;
		 

		
	}
	public String getNAS() // constructeur pour NAS employe , access
	{
		return NAS;
	}
	
	public String toString() { // redefinitionn tableau object NAS et salaire 
		return String.format("\n	%s  -	%.2f", NAS, salaire);
	}
	
	public boolean estInferieur() // constructeur pour le compareTo
	{		
		return NAS.compareTo(NAS) < 0;
	}
} // Fin class employe


public class TestEmploye { // debut mainn (TestPersonne)

	static void afficher (Employe[] emp, String mess) { // methode pour afficher les employe tableau 
	    System.out.printf("Contenu du tableau %s :\n", mess);
		for(int i = 0; i < emp.length; i++) {
			System.out.println(i + ")" + "\t" + emp[i].getNAS() + "\t" + emp[i].getSalaire() + "$");
			
		}    		   
	    System.out.printf("\n\n");
	}
	
	static void trier (Employe[] emp, int nbEtud) // methode pour trier selon le NAS
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
	
	 static int nombre (Employe [] emp, int nbPers, double val, char c) // methode pour compter 
	 // et pour afficher selon les indication 
	   {
	       int n = 0 ;
	       for(int i = 0; i < nbPers; i++)
	           if (emp[i].getSalaire()<=val && emp[i].getNAS().indexOf(c) >= 0)
	               n++;
	       return n;
	    }  
	
	
	
	public static void main(String[] args) { // main fonction
		
		Employe emp1 = new Employe("250 642 753", 1234.56), // instancier employer
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
	      
		  emp2.setSalaire(emp3.getSalaire()+emp1.getSalaire());
		// afficher toutes les infos de emp4:
	      emp2.afficher("3- Information de l'employé 2 : \n");
	      System.out.printf("\n\n");
		
	      /* Gabarit pour le tableau ci-dessous
	      i        emp[i]
          0       "250 642 753"        1234.25$
          1       "123 456 789"        1250.25$ (par défaut)
          2       "250 343 654"        40 hrs au taux de 17.25$ de l’heure
          3       "231 467 890"        1671.50$
          4       "478 343 689"        1750.75$
          5       "371 238 432"        50 hrs au taux de 20.25$ de l’heure
	        
	       */
	      Employe [] emp  = {new Employe ("250 642 753", 1234.56),  	// tableau employe
	    		  			 new Employe ("123 456 789", 1250.25), 		// par defaut
	    		  			 new Employe ("250 343 654", 40, 17.25), 	// le taux * horaire deja instancier
	    		  			 new Employe ("231 467 890", 1671.50), 		//normale
	    		  			 new Employe ("478 343 689", 1750.75),		// normale 
	    		  			 new Employe ("371 238 432", 50, 20.25)}; 	// taux * horaire deja instancier
		
		
	      int nbEtud = emp.length; 					// important pour tableau la longueur
	      afficher (emp, "\n1- Au debut"); 			// pour afficher le tableau 
	      System.out.printf("%s", emp[0]);			// indice 0 du toString redefinition
	      System.out.printf("%s", emp[1]);			// indice 1 du toString redefinition
	      System.out.printf("%s", emp[2]);			// indice 2 du toString redefinition
	      System.out.printf("%s", emp[3]);			// indice 3 du toString redefinition
	      System.out.printf("%s", emp[4]);			// indice 4 du toString redefinition
	      System.out.printf("%s", emp[5]);			// indice 5 du toString redefinition
	      
	      
	      
	      
	      trier(emp, nbEtud);						// trier le tableau 
	      afficher(emp, "\n4- Apres le tri selon NAS");	// afficher le tableau apres le tri 
		  
	      double val=1300.0; char c='5';				// variable pour la condition methode nombre moins que 1300. et avoir le chiffre 5
	      System.out.printf("\n5- Le nombre d'employé qui gagne moins que %.2f & dont le NAS contient %c est : %d\n", val, c, nombre (emp, nbEtud, val, c));
	      // l'affichage methode nombre
	      val=750.0; c='3';								// variable pour la condition methode nombre moins que 750 et avoir le chiffre 3
	      System.out.printf("\n5- Le nombre d'employé qui gagne moins que %.2f & dont le NAS contient %c est : %d\n", val, c, nombre (emp, nbEtud, val, c));
	      // affichage methode nombre
	}

}

