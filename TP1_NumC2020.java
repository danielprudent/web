class Etudiant {
	
	private String date; // "29/06/1996"
	private int cafe; // 2.0 cafe
                     


public Etudiant(String date, int cafe)
{
this.date  = date; // ce this est obligatoire

this.cafe  = cafe; // ce this est optionnel (facultatif)
}

public Etudiant(String date)
{
this(date, 1); // note globale par défaut
}

//	public int rangMois()
//	{
//	return Integer.parseInt( date.substring(3,6)) % 50 ;
//	}

//	public String getMois()
//	{
//	String[] nomMois = { "Janvier", "Février", "Mars", "Avril", "Mai",
//	                   "Juin", "Juillet", "Août", "Septembre",
//	                   "Octobre", "Novembre", "Décembre"};
//	return nomMois[rangMois()-1];
//	
//	}
//	public int getdate()
//	{
//	return Integer.parseInt(date.substring(0,3));
//	}



//	public int getJour()
//	{
//	return Integer.parseInt(date.substring(0,3));
//	}

//	public int getAnnee()
//	{
//	return  Integer.parseInt(date.substring(7));
//	}

	//public String getSexe()
	//{
	//return date.charAt(6) >= '5' ? "féminin":"masculin";
	//}


	public void afficher()
	{
	System.out.printf("%s date: %s  cafe : %d %s %d globale : %.1f\n",
		date, cafe);
	}

	public String getDT()
	{
	return date;
	}

	public int getCF()
	{
	return cafe;
	}
	public void setGlobale(int nouvGlobale)
	{ cafe = nouvGlobale;
	if (cafe > 100)
		   cafe = 100;
	if (cafe < 0)
		    cafe = 0;
	
	}

	
	
}
public class TestPersonne {
	
	
	 static void demo2() {
    System.out.printf("\nIndice	Date	Café :\n");
    Etudiant[] etud = { new Etudiant("	16/05/1992", 2),
                        new Etudiant("	02/01/1990"), // 1 tasse par defaut
                        new Etudiant("	23/05/1990", 5),
                        new Etudiant("	19/02/1985", 0),
                        new Etudiant("	30/05/1991", 2),
                        new Etudiant("	31/01/1990", 4)};
    int nbEtud = etud.length;
    
	 

//    static void trier(Etudiant[] etud, int nbEtud)
//    {
//    	for(int i = 0; i < nbEtud-1; i++)
//    	{
//    		int indMin = i ;
//    		for(int j = i+1; j < nbEtud; j++)
//    			if (etud[j].getCF() < etud[indMin].getCF())
//    				         indMin = j;
//    	    if (indMin != i)
//    	    {
//    	    	Etudiant tempo = etud[i];
//    	    	etud[i] = etud[indMin];
//    	    	etud[indMin] = tempo;
//    	    }
//    	}
//    }
     afficher (etud, "au début");
    // System.out.printf("Le nombre d'étudiants nés au mois de septembre : %d\n",
     //         nombre(etud, nbEtud,9))  ;
     //trier(etud, nbEtud); // selon les notes globales

     afficher(etud, "après le tri selon les notes globales");
     //System.out.printf("\nLe min de cafe consommer: %.1f", min(etud, nbEtud));
     

     
     //etud[min(etud, nbEtud)].
    int m = min(etud, nbEtud);
    

	

	System.out.println(m + ")" + "\t" + etud[m].getDT() + "\t" + etud[m].getCF() + " tasses");
     

}
	 
	 
static void afficher (Etudiant[] etud, String mess) {
    System.out.printf("Contenu du tableau %s :\n", mess);
	for(int i = 0; i < etud.length; i++) {
		System.out.println(i + ")" + "\t" + etud[i].getDT() + "\t" + etud[i].getCF() + " tasses");
		//System.out.printf("%3d) %s \n", i,etud[i].getDT(),etud[i].getCF() + "\t" + etud[i].get + " tasses");
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

static int minOLD(Etudiant[]  etud, int nbP)    { // condition pour le cafe plus grand et les infos de la personne
	int pluspetit = 1000000;
	for(int i = 0; i < nbP; i++)
   	 	if (etud[i].getCF() < pluspetit)
   	 		pluspetit = etud[i].getCF();

   return pluspetit;

}


	 
	
	public static void main(String[] args) {
		
		demo2();

		System.out.printf("\n\n");      
		
	 
		
		 
	      
	      
	



		
		
	}
}
