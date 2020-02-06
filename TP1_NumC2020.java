/* Auteur : Daniel Prudent, IFT1170A TP3_NumC 
 * 1.	afficher le contenu du tableau pers au début;
2.	déterminer et afficher les informations d’une personne qui consomme le moins de café
3.   réduire 1 tasse de moins pour les personnes qui consomment de café. 
      On réaffiche le tableau;
      4.  trier le tableau selon l’année de naissance puis réafficher le tableau après le tri.
      5.  compter et afficher le nombre de personnes qui sont nées en 1990

 * 
 * 
 * 
 * 
 */
class Etudiant {// constructeur 
	
	private String date; // "29/06/1996"
	private int cafe; // 2.0 cafe
                     


	public Etudiant(String date, int cafe)
	{
	this.date  = date; // ce this est obligatoire
	
	this.cafe  = cafe; // ce this est optionnel (facultatif)
	}
	
	public Etudiant(String date) // note par defaut 
	{
	this(date, 1); // note globale par défaut
	}
	

	
	
	
		public int getAnnee() // retour l'annee seulement 
		{
		return  Integer.parseInt(date.substring(7));	}
	
		
		public void afficher() // le format d'affichage pour println
		{
		System.out.printf("%s date: %s  cafe : %d %s %d globale : %.1f\n",
			date, cafe);
		}
	
		public String getDT() // pour date de l'etudiant 
		{
		return date;
		}
		
		public String toString() 	//Redéfinition de toString(): Retourne le format d'affichage d'un Objet de la classe
	    { 
			return String.format("%s -	%d tasses", date, cafe);
	    } 
		public int getCF()  // pour cafe 
		{
		return cafe;
		}

	// pour reduire cafe
		
		public int getCafe()  				{  	return cafe;  		}
		public void setCF(int nouvCafe)  	{  	cafe = nouvCafe ; 	}
}


public class TestPersonne { // class TestPersonne
	
	
	
	 
	static void afficher (Etudiant[] etud, String mess) { // methode pour afficher les etudiant tableau 
	    System.out.printf("Contenu du tableau %s :\n", mess);
		for(int i = 0; i < etud.length; i++) {
			System.out.println(i + ")" + "\t" + etud[i].getDT() + "\t" + etud[i].getCF() + " tasses");
			
		}    		   
	    System.out.printf("\n\n");
	}
	static int min(Etudiant[]  etud, int nbP)    { // condition pour le cafe min et les infos de la personne
		int plusPetit = 5;
		for(int i = 0; i < nbP; i++)
	   	 	if (etud[i].getCF() < etud[plusPetit].getCF())
	   	 	    plusPetit = i;
	
	   return plusPetit;
	   
	}
	
	
	
	static void reduireCafe(Etudiant [] etud, int nbP,int deCombien){ // pour reduire les cafe du 1 du tableau 
		for(int  i=0; i<nbP; i++) {
			if(etud [i].getCF() > 0)
			etud[i].setCF(etud[i].getCF() - 1);
		}
		
	}
	
	
	static int nombre(Etudiant[] etud, int nbPers, int annee) { // pour afficher le mois instance
		  int n = 0;
		  for (int i = 0; i < nbPers; i++)
		  	if (etud[i].getAnnee() == annee) 
		  		n ++ ;
		  return n ;
	}   
	
	static void trier(Etudiant[] etud, int nbEtud) // pour trier selon l'annee de naissance 
	{
		for(int i = 0; i < nbEtud-1; i++)
		{
			int indMin = i ;
			for(int j = i+1; j < nbEtud; j++)
				if (etud[j].getAnnee() < etud[indMin].getAnnee())
					         indMin = j;
		    if (indMin != i)
		    {
		    	Etudiant tempo = etud[i];
		    	etud[i] = etud[indMin];
		    	etud[indMin] = tempo;
		    }
		}
	}

	
	public static void main(String[] args) {  // fonction principale 
		
		//demo2();
		
		 //static void demo2() {
			    System.out.printf("\nIndice	Date	Café :\n");
			    Etudiant[] etud = { new Etudiant("	16/05/1992", 2),
			                        new Etudiant("	02/01/1990"), // 1 tasse par defaut
			                        new Etudiant("	23/05/1990", 5),
			                        new Etudiant("	19/02/1985", 0),
			                        new Etudiant("	30/05/1991", 2),
			                        new Etudiant("	31/01/1990", 4)};
			    int nbEtud = etud.length;
			    
				 

//			    for (int i=0; i<nbEtud; i++)
//			    	System.out.printf("\nAnnée : %s ", etud[i].getAnnee());
			    
			     afficher (etud, "\n1- Au début");
			   
			     
			     

			     
			     //Pour afficher information de la personne avec le moins de cafe
			    int m = min(etud, nbEtud);
			
				System.out.printf("2- Information de la personne qui consomme le moins de café: \n\t%s\n", etud[m].toString());
				System.out.printf("\n\n");  

				
				 // Pour reduire le cafe de 1 (tout les etudiants)
				reduireCafe(etud,nbEtud,1);
				  afficher(etud, "\n3- Après la reduction");
				
				// pour trier et afficher apres le tri la methode 
				  trier(etud,nbEtud);
				  afficher(etud, "\n4- Après le tri selon l'année de naissance");
				     
				  // pour compter et afficher le nombre de personne nee en 1990 
				  System.out.printf("5 - Nombre de personnes qui sont nées en 1990 : %d\n",
			               nombre(etud, nbEtud, 1990));

		System.out.printf("\n\n");      // passe deux lignes 
		
	 
		
		 
	      
	      
	



		
		
	}//main
}//TestPersonne


/*
Indice	Date	Café :
Contenu du tableau 
1- Au début :
0)		16/05/1992	2 tasses
1)		02/01/1990	1 tasses
2)		23/05/1990	5 tasses
3)		19/02/1985	0 tasses
4)		30/05/1991	2 tasses
5)		31/01/1990	4 tasses


2- Information de la personne qui consomme le moins de café 
		19/02/1985 -	0 tasses


Contenu du tableau 
3- Après la reduction :
0)		16/05/1992	1 tasses
1)		02/01/1990	0 tasses
2)		23/05/1990	4 tasses
3)		19/02/1985	0 tasses
4)		30/05/1991	1 tasses
5)		31/01/1990	3 tasses


Contenu du tableau 
4- Après le tri selon l'année de naissance :
0)		19/02/1985	0 tasses
1)		02/01/1990	0 tasses
2)		23/05/1990	4 tasses
3)		31/01/1990	3 tasses
4)		30/05/1991	1 tasses
5)		16/05/1992	1 tasses


5 - Nombre de personnes qui sont nées en 1990 : 3




*/
