/* Auteurs : Daniel Prudent IFT-1810
But d'afficher un tableau avant le tri 
Rep a des question exemple l'age minimal des employes,
le nombre minimal de cafe consomme 
d'afficher et de compteles diviseur de 6,20,720 un a la suite
de l'autre 
Ne pas oublier de calculer et afficher avec une fonction
avant le main et avec un retour et de finalement
afficher le tableau apres le tri en prenant compte
de l'age minimal d'un employe 
Traduire en Java le programme qui 
etait initialement en C 
*/

public class ConversionJava {
	
	static int combien(int age[], int nbPers, int limit )					//int fonction combien, integer du tableau age, entier du nbpersonne et de la limite
	  { int i;														// initialiser l entier i 
	  	int n = 0;													// initialiser le n a zero
	  	for( i = 0; i < nbPers; i++)								//
	  	   if(age[i] >= limit)										// tableau d'age depasser la limite de 25
	  	        n++;												// chercher d'autre age depassant 25
	  	return n;													// le retour du N 
	}
	  	
	int combienb(int nbcafe[], int nbPers, int limitb )				// fonction pour savoir la moy de consomation par jour de cafe avec return
	  { int i;
	  	int n = 0;
	  	for( i = 0; i < nbPers; i++)
	  	   if(nbcafe[i] >= limitb)
	  	        n++;
	  	return n;    
	}
	  	
	  	
	static int min (int nbcafe[], int nbPers, int borne)					// consomation minimal de cafe fonctiion avec return
	  {
	  	//int n = 0;
	  	int i = 0;
	  	for( i = 0; i < nbPers; i++)
	  	   if(nbcafe[i]< borne)
		      borne = nbcafe[i];								// nbcafe prend borne resultat
			//	n=borne;
	  	return borne;       
	  }

	  	
	static int minb (int age[], int nbPers, int borneb)				// fonction avec return age min des employes integer
	  {
	  //	int n = 0;
	  	int i = 0;
	  	for(i = 0; i < nbPers; i++)
	  	   if(age[i]< borneb)
		        borneb = age[i];								// age prend borneb resultat
				// n=borneb;
	  	return borneb;       
	  }
	  
	static int nbDivi (int nombre) {						// fonction avec return pour avant le main pour les compter et combien le nombre a de diviseur
		int candi, compteur = 0;
		for( candi = 1 ; candi <= nombre; candi++)
			if (nombre % candi == 0)
				compteur++;

		return compteur;
	}

	static void diviseur (int nb){							// fonction pour compter et affiche le nombre de diviseur
		int increment, compteur = 0;
		System.out.printf ("2-");
	    System.out.printf ("Les diviseurs de %3d sont : ",nb);
		for(increment = 1 ; increment <= nb; increment++)
			if (nb % increment== 0)
			System.out.printf ("%d ",increment);
			
	    System.out.printf ("\n");
		
	}

	 static double moyenne(int tableau[], int nbElem )  		// fonction pour la moyenne de l'age avec un return en double et cons min cafe 
	 {  int i;
	    double somme = 0.0;
	    for( i = 0; i < nbElem; i++) 
	         somme += tableau[i];
	    return somme / nbElem;     
	  }
	 
		
		
	  static void afficher(char [] poste, int nbcafe[], int age[], int nbPers, String quand )  // fonction pour afficher les tableau avant triage et apres
	    {
	    	int i=0;											// initialisation du i 
			System.out.printf("3 | 7- Contenu des 3 tableaux %s :\n", quand); // aff contenue des 3 tableau
			System.out.printf("nbcafe  age   	poste\n");					// aff du nbcafe afe et poste au debut
	    	for( i = 0; i < nbPers; i++)						// parcourir les personnes 
	    	{
			  System.out.printf("%d)%d  %5d ",i, nbcafe[i], age[i]);		// entier tableau age et cafe
			  switch( poste[i])									// switch du poste
			  {
			  	case 'A' : System.out.printf("     Analyste"); break ;		// aff analyste
			  	case 'P' : System.out.printf("     Programmeur"); break ;	// aff programmeur
			  	case 'O' : System.out.printf("     Operateur"); break ;	// aff operateur
			  	default  : System.out.printf("     autre") ;				// no case 
			  };
			  System.out.printf("\n");										// passer une ligne 
		    }
			System.out.printf("\n\n")  ;									// Passer deux ligne
	    	
		}
	static void trier(char [] poste, int nbcafe[],int age[], int nbPers) // Trier le tableau pas rapport a l'age 
	    {   int i = 0;											// Commencer par le poste, nbcafe , l'age et le nombre de personne 
	    	for(i = 0; i < nbPers-1; i++)
	    	{
	    		int indMin = i;
				int j = 0;									// Trier par rapport a l'age 
	    		for(j = i+1; j < nbPers; j++)
	    		   if (age[j] < age[indMin])
	    		      indMin = j;
	    		if (indMin != i)      
	    		{
	    			char tempo = poste[i];						// Initialisation du poste en caractere
	    			poste[i]= poste[indMin];
	    			poste[indMin]= tempo;
	    			
	    			tempo = (char) age[i];								// initialisation de l'age 
	    			age[i]= age[indMin];
	    			age[indMin]= tempo;
	    			
	    			int tempo2 = nbcafe[i];						// initialisation du nombre de cafe
	    			nbcafe[i] = nbcafe[indMin];
	    			nbcafe[indMin] = tempo2;
	    			
	    			
				}
			}
	    	
	    	
		}
	 

	public static void main(String[] args) {
		char poste[] = { 'A', 'P', 'O', 'P', 'A' ,'A', 'P', 'P'};   // caractere pour les poste P = Programmeur, A = Analyste , O = Operateur
		int nbcafe[] = { 3, 6, 2, 1, 5, 3, 0, 3 },					// nb cafe consommer par personne
			  age [] = {25, 18, 23, 20, 49, 24, 56, 29};			// L'age des employe
		int nbPers   = age.length ;					// size of pour afficher age
		int i; 														// indice pour parcourir les tableaux

		


		System.out.printf("1- Le nombre 6 a %3d diviseurs\n", nbDivi(6));		// compter et afficher combien de diviseur 6 

		System.out.printf("1- Le nombre 20 a %2d diviseurs\n", nbDivi(20));		// compter et afficher combien de diviseur 20

		System.out.printf("1- Le nombre 720 a %d diviseurs\n", nbDivi(720));	// compter et afficher combien de diviseur 720
		System.out.printf("\n\n")  ;											// Passer deux ligne a la fin
		
		diviseur(6);												// afficher les diviseur a la suite
		diviseur(20);												// afficher les diviseur a la suite
		diviseur(720);												// afficher les diviseur a la suite
		System.out.printf("\n\n")  ;											// Passer deux lignes
		afficher(poste, nbcafe, age, nbPers, "avant le tri");		// afficher le tableau avant le tri
		System.out.printf("4- L age moyenne des employes sont : %.2f \n", moyenne(age, nbPers));	// age moyen employe en double
		System.out.printf("4- La consommation moyen de cafes des employes sont : %.1f cafes\n\n",moyenne(nbcafe, nbPers));	// consommaiton moyenne de cafe en double
		System.out.printf("5- Il y a %d pers. qui ont plus de 25 ans \n", combien(age, nbPers, 25));	// employe ayant 25+
		System.out.printf("5- Il y a %d pers. qui consomme plus de 2 cafes par jour \n\n", combien(nbcafe, nbPers, 2)); // aff employe consomant 2+ /jour
		System.out.printf("6- Consommation la plus petite de cafe est : %d \n", min(nbcafe, nbPers,40 ));	// affichage consommation minimal cafe
		System.out.printf("6- Age minimal de tous les employes : %d \n\n", minb(age, nbPers, 40)); // affichage age minimal employe
		trier(poste, nbcafe, age, nbPers);							// tri le tableau par rapport a lage
		afficher(poste, nbcafe ,age, nbPers, "apres le tri");		// afficher le tableau apres le tri de l'age
		
		
		
		return;													// retour a zero de la fonction main 
// TODO Auto-generated method stub

	}

}
/*
 Execution du programme en C conversion Java :
1- Le nombre 6 a   4 diviseurs
1- Le nombre 20 a  6 diviseurs
1- Le nombre 720 a 30 diviseurs


2-Les diviseurs de   6 sont : 1 2 3 6 
2-Les diviseurs de  20 sont : 1 2 4 5 10 20 
2-Les diviseurs de 720 sont : 1 2 3 4 5 6 8 9 10 12 15 16 18 20 24 30 36 40 45 48 60 72 80 90 120 144 180 240 360 720 


3 | 7- Contenu des 3 tableaux avant le tri :
nbcafe  age   	poste
0)3     25      Analyste
1)6     18      Programmeur
2)2     23      Operateur
3)1     20      Programmeur
4)5     49      Analyste
5)3     24      Analyste
6)0     56      Programmeur
7)3     29      Programmeur


4- L age moyenne des employes sont : 30,50 
4- La consommation moyen de cafes des employes sont : 2,9 cafes

5- Il y a 4 pers. qui ont plus de 25 ans 
5- Il y a 6 pers. qui consomme plus de 2 cafes par jour 

6- Consommation la plus petite de cafe est : 0 
6- Age minimal de tous les employes : 18 

3 | 7- Contenu des 3 tableaux apres le tri :
nbcafe  age   	poste
0)6     18      Programmeur
1)1     20      Programmeur
2)2     23      Operateur
3)3     24      Analyste
4)3     25      Analyste
5)3     29      Programmeur
6)5     49      Analyste
7)0     56      Programmeur


*/