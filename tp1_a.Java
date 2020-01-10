
public class NumA {
	
	   static int nombre ( char statutVoulu, char[] statut, int nbPers)
	   {
	       int n = 0 ;
	       for(int i = 0; i < nbPers; i++)
	           if (statut[i] == statutVoulu)
	               n++;
	       return n;
	    }  
	
	   static int nombreP ( char statutVoulu, char[] statut, int [] nbcafe, int nbPers)
	   {
	       int n = 0 ;
	       for(int i = 0; i < nbPers; i++)
	           if (statut[i] == statutVoulu && nbcafe [i] <=3)
	               n++;
	       return n;
	    }  
	   
	   static double moyenne(double[] tableau, int nbElem)
	    {
	      double somme = 0.0;
	      for (int i = 0; i < nbElem ; i++)
	          somme += tableau[i];

	      return somme / nbElem ;
	    }

	
	//   static double 
	   
	   
	   
	 static void afficher(char[] statut, int [] nbcafe, int nbPers, String mess)
	    {

	      System.out.printf("Contenu des 3 tableaux %s :\n", mess);
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
	      System.out.printf("\n");


	    }
	public static void main(String[] args) {
	
		
			int [] nbcafe = { 3, 1, 4, 0, 4, 2, 2, 5, 1};
			char[] poste = { 'P', 'P', 'O', 'P', 'A' ,'A', 'O', 'P', 'P' };  // caractere pour les poste P = Programmeur, A = Analyste , O = Operateur
				int nbEmp = poste.length;													
		
				
				
				afficher(poste, nbcafe, nbEmp, "au debut");
				System.out.printf("Le nombre de d'operateur : %d\n", nombre('O', poste, nbEmp));
				System.out.printf("Le nombre d'analystes : %d\n", nombre('A', poste, nbEmp));
				System.out.printf("Le nombre de secretaires : %d\n", nombre('S', poste, nbEmp));
				System.out.printf("Le nombre de programmeurs qui consomment plus de 3 cafes : %d\n", nombreP('P', poste, nbcafe,nbEmp));
				System.out.printf("Le nombre moyen de programmeurs qui consomment du cafe : %d\n", moyenne(nbcafe, nbEmp));
	}
}

 
