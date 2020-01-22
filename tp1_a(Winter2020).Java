/* Realiser par Daniel Prudent , IFT 1170A
 * faire un tableau avec les declaration du tp
 * poste et nbcafe
 * 1- afficher les contenu de ces deux tableau 
 * 2- compter et afficher selon les directives donnees 
 * 3- calculer et afficher consommaiton moyenne de cafe programmeur avec un chiffre real
 * 4- determiner et afficher la consommation max cafe analystes
 * 5- determiner et afficher consommation mininal cafe operateur 
 */
public class NumA {
	
	   static int nombre ( char statutVoulu, char[] statut, int nbPers) // compteur pour operateur et analystes et secretaires 
	   {
	       int n = 0 ;
	       for(int i = 0; i < nbPers; i++)
	           if (statut[i] == statutVoulu)
	               n++;
	       return n;
	    }  
	
	   static int nombreP ( char statutVoulu, char[] statut, int [] nbcafe, int nbPers) // methode pour prog consomment 3+ cafes 
	   {
	       int n = 0 ;
	       for(int i = 0; i < nbPers; i++)
	           if (statut[i] == statutVoulu && nbcafe [i] <=3)
	               n++;
	       return n;
	    }  
	   
	   static double moyenne (int[] nbcafe,char statutVoulu, char[] statut, int nbElem) // methode pour la moyenne 
	    {
	      double somme = 0.0;
	     double comp = 0.0;
	      for (int i = 0; i < nbElem ; i++) {
	    	  if (statut[i] == statutVoulu) {
	          somme += nbcafe[i];
	      	  comp ++;
	    	  }
	      }
	      return  somme/comp ;
	    }

	   static double maxi (int[] nbcafe,char statutVoulu, char[] statut, int nbElem) // methode pour la consommation maxi 
	    {
		   double plusGrand =-Double.MAX_VALUE;
	      for (int i = 0; i < nbElem ; i++) 
	    	  if (nbcafe[i] > plusGrand) 
	          plusGrand = nbcafe[i];
	      	  
	    	  
	    
	      return  plusGrand ;
	    }
	   static double min (int[] nbcafe,char statutVoulu, char[] statut, int nbElem) // methode pour la consommation minimale 
	    {
		   double plusPetit =+ Double.MAX_VALUE;
	      for (int i = 0; i < nbElem ; i++) 
	    	  if (nbcafe[i] < plusPetit) 
	          plusPetit = nbcafe[i];
	      	  
	    	  
	    
	      return  plusPetit ;
	    }
	   
	 static void afficher(char[] statut, int [] nbcafe, int nbPers, String mess) // affichage et parametre du tableau 
	    {

	      System.out.printf("1- Contenu des 3 tableaux %s :\n", mess);
	      System.out.printf("Indice  Nbcafe	Poste     \n");
	      for (int i = 0; i < nbPers; i++)
	      {
	        System.out.printf("%d) 	%d", i, nbcafe [i]);
	        switch (statut[i])
	        {
	            case 'P' : System.out.printf("  	Programmeurs\n"); break; 
	            case 'O' : System.out.printf("  	Operateurs\n"); break;
	            case 'A' : System.out.printf("  	Analystes\n"); break;
	            default : System.out.printf("  	autre\n"); break;
	        }	
	       }
	      System.out.printf("\n"); // passer une ligne 


	    }
	public static void main(String[] args) {// fonction main 
	
		// initialer le tableau 
			int[] nbcafe = { 3, 1, 4, 0, 4, 2, 2, 5, 1};
			char[] poste = { 'P', 'P', 'O', 'P', 'A' ,'A', 'O','A', 'P' };  // caractere pour les poste P = Programmeur, A = Analyste , O = Operateur
			int nbEmp = poste.length;			 // vaut 9 										
		
				
				// l'appel des fonctions avec les variantes demandé dans le TP 
				afficher(poste, nbcafe, nbEmp, "au debut");
				System.out.printf("2- a)Le nombre de d'operateur : %d\n", nombre('O', poste, nbEmp));
				System.out.printf("2- b)Le nombre d'analystes : %d\n", nombre('A', poste, nbEmp));
				System.out.printf("2- c)Le nombre de secretaires : %d\n", nombre('S', poste, nbEmp));
				System.out.printf("2- d)Le nombre de programmeurs qui consomment plus de 3 cafes : %d\n", nombreP('P', poste, nbcafe,nbEmp));
				System.out.printf("3- Le nombre moyen de programmeurs qui consomment du cafe : %.2f\n", moyenne(nbcafe,'P', poste, nbEmp));
				System.out.printf("4- La consommation maximale de cafés des analystes : %.2f\n", maxi (nbcafe,'A', poste, nbEmp));
				System.out.printf("5- La consommation minimale de cafés des opérateurs : %.2f\n", min (nbcafe,'O', poste, nbEmp));
	}
}

 /*
 1- Contenu des 3 tableaux au debut :
Indice  Nbcafe	Poste     
0) 	3  	Programmeurs
1) 	1  	Programmeurs
2) 	4  	Operateurs
3) 	0  	Programmeurs
4) 	4  	Analystes
5) 	2  	Analystes
6) 	2  	Operateurs
7) 	5  	Analystes
8) 	1  	Programmeurs

2- a)Le nombre de d'operateur : 2
2- b)Le nombre d'analystes : 3
2- c)Le nombre de secretaires : 0
2- d)Le nombre de programmeurs qui consomment plus de 3 cafes : 4
3- Le nombre moyen de programmeurs qui consomment du cafe : 1.25
4- La consommation maximale de cafés des analystes : 5.00
5- La consommation minimale de cafés des opérateurs : 0.00
  */


