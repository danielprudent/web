/* Auteur : Daniel Prudent, cour IFT1810 
 * TP3 partie C 
 * Le but de ce lab est premierement ce familiariser avec Java
 * en faisant deux class : TestPersonne et Personne 
 * et construire des constructeurs et des methodes 
 * pour faire fonctionner le programme appris en partie en classe
 * et en TP. Deuxiemement, nous devons ecrire deux constructeur pour 
 * instancier trois personne ; pers1-2-3
 * De plus, ecrire la methode pour avoir acces pour afficher les infos de
 * ces personnes
 * troisiement, nous devons ecrire dans la methode principale (main)
 * un tableau de 5 personnes avec leur date de naissance et leur consommation en cafe
 * par jour ce que nous avons a faire apres etait de 
 * 1- afficher le tableau au debut
 * 2- determiner et afficher la personne qui consomme le plus de cafe par jour
 * 3- reduire de 1 les personnes qui doivent du cafe et
 * reafficher le tableau apres 
 * 5- compter et afficher les personnes qui sont nées en mai dans le tableau 
 * 
 */
  class Personne { // Class personne
 
	//Déclaration des attributs :
	private String nomPre;
	private String naissance;
	private double cafe;
	// constructeurs + méthodes pour appliquer sur une Personne
	public Personne(String nP, double glob)  {
	  	nomPre = nP;
	  	cafe = glob;
	}


	public Personne(String nP, String naiss, int glob)  { // instance pour le tableau plus tard
	  	nomPre = nP;
	  	naissance = naiss;
	  	cafe = glob;
	  	}
	public Personne(String nP, String naiss)  {  // pour modifier cafe de Sage Lisette par défaut.
	  	nomPre = nP;
	  	naissance = naiss;
	  	cafe = 1;               
	}

	public String getNaiss() // instance pour la date de naissance
    {
    	return naissance;
    }
	
	public int getMois() // instance pour le mois
	{
		return Integer.parseInt( naissance.substring(3,5));
	}

	public void afficher(String message)  { // message pour le tableau
	  	System.out.printf("%s :\n Nom et Prénom : %s \n Consommation de cafe par jour : %.1f\n Date de naissance : %s\n ", message , nomPre.toUpperCase(), cafe, naissance);
	 }

	public double getCafe()  				{  	return cafe;  		}
	public void setCafe(double nouvCafe)  	{  	cafe = nouvCafe ; 	}
	public String getNomPre()				{  	return nomPre;  	}
  }




public class TestPersonne {  // Class TestPersonne
	
	static void afficher(Personne[] pers, int nbP, String msg)    { // void pour afficher les tableaux cafes
		
    	System.out.printf("1 & 3 & 4 - Contenu du tableau des %d Personne %s :\n", nbP, msg);
    	for(int i = 0 ; i < nbP ; i++)
    		System.out.printf("%3d) %20s %8.1f\n", i, pers[i].getNaiss(),pers[i].getCafe());
        System.out.printf("\n\n");
    }

    static int max(Personne[]  pers, int nbP)    { // condition pour le cafe plus grand et les infos de la personne
    	int plusGrande = 0;
    	for(int i = 0; i < nbP; i++)
       	 	if (pers[i].getCafe() > pers[plusGrande].getCafe())
       	 	    plusGrande = i;

       return plusGrande ;
    }
    
    static void reduireCafe(Personne [] pers, int nbP, int deCombien){ // pour reduire les cafe du 1 du tableau 
    	for(int  i=0; i<nbP; i++) {
    		if(pers [i].getCafe() > 0)
    		pers[i].setCafe(pers[i].getCafe() - 1);
    	}
    	
    }
    
    static int nombre(Personne[] pers, int nbPers, int mois) { // pour afficher le mois instance
    	  int n = 0;
    	  for (int i = 0; i < nbPers; i++)
    	  	if (pers[i].getMois() == mois) 
    	  		n ++ ;
    	  return n ;
    }   
    
	public static void main(String[] args) {
		  // instancier 3 employés par 3 constructeurs différents
	      // selon votre imagination
	      Personne pers1 = new Personne("Roy Serge","19/05/1997", 3),
	               pers2 = new Personne("Charboneau Jacques","31/12/1990"), // par défaut 1 tasse de cafés
	               pers3 = new Personne("Pilon Lise","08/05/1994", 2);

	      Personne[] pers = { new Personne("Tremblay Veronique","16/11/1992", 2),
                new Personne("Sage Lisette","02/05/1990"), // 1 tasse par defaut 
                new Personne("Choquette Alain","23/05/1996", 5),
                new Personne("Hudon charles", "19/02/1985", 0),
                new Personne("Tremblay Nicole", "30/05/1991", 2)};
            	  
	      int nbP = pers.length;
	      
	      // afficher le tableau avant le tri - tableau original
	      afficher(pers,nbP, ", avant le tri");
	      
	      // afficher la plus grande consommation de cafe de la personne du tableau
	      //System.out.printf("2 - La plus grande consommation de cafe : %.1f\n", max(pers, nbP));
	      pers[max(pers, nbP)].afficher("2 - La plus grande consommation de cafe: \n");
	      
	      
	      //3. Réduire de 1 tasse de moins pour les personnes qui consomment de café. 
	      reduireCafe(pers, nbP, 1);
	      System.out.printf("\n\n");
	    
	      
	      //4. Réafficher   le tableau apres la reduction
	      afficher(pers, nbP, ", Apres la réduction de café");
	      
	     
	    // afficher le nombre de personne du tableau nee en mai 
	      System.out.printf("5 - Nombre de personnes qui sont nées au mois de mai : %d\n",
	               nombre(pers, nbP, 5));
	      System.out.printf("\n\n");
	    
	      
	      // afficher toutes les infos de pers1:
	      pers1.afficher("0 - Information de la personne 1");
	      System.out.printf("\n\n");
	      
	      // afficher toutes les infos de pers2:
	      pers2.afficher("0 - Information de la personne 2");
	      System.out.printf("\n\n");

	      // afficher toutes les infos de pers3:
	      pers3.afficher("0 - Information de la personne 3");
	      System.out.printf("\n\n");

	      
	}
}
	/* Syntaxe et Exécution:
1 & 3 & 4 - Contenu du tableau des 5 Personne , avant le tri :
  0)           16/11/1992      2.0
  1)           02/05/1990      1.0
  2)           23/05/1996      5.0
  3)           19/02/1985      0.0
  4)           30/05/1991      2.0


2 - La plus grande consommation de cafe: 
 :
 Nom et Prénom : CHOQUETTE ALAIN 
 Consommation de cafe par jour : 5.0
 Date de naissance : 23/05/1996
 

1 & 3 & 4 - Contenu du tableau des 5 Personne , Apres la réduction de café :
  0)           16/11/1992      1.0
  1)           02/05/1990      0.0
  2)           23/05/1996      4.0
  3)           19/02/1985      0.0
  4)           30/05/1991      1.0


5 - Nombre de personnes qui sont nées au mois de mai : 3


0 - Information de la personne 1 :
 Nom et Prénom : ROY SERGE 
 Consommation de cafe par jour : 3.0
 Date de naissance : 19/05/1997
 

0 - Information de la personne 2 :
 Nom et Prénom : CHARBONEAU JACQUES 
 Consommation de cafe par jour : 1.0
 Date de naissance : 31/12/1990
 

0 - Information de la personne 3 :
 Nom et Prénom : PILON LISE 
 Consommation de cafe par jour : 2.0
 Date de naissance : 08/05/1994
 



	*/
