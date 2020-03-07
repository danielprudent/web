import java.io.*;

class Pays{
	
	//1- Déclaration des Attributs :
	private char continent ;
	private String pays, capital;
	private double population, superficie;
	//private int    numero;
	
	//2- Les Constructeurs
	public Pays(char continent, String pays, String capital, double population, double superficie)
	{
		this.continent  = continent;
		this.pays       = pays;
		this.capital    = capital;
		this.population = population;
		this.superficie = superficie;
		//this.numero = numero;
	}
	
	//3- Getters & Setters
	public char getCont() 	{	return continent;	}
	public String getPays() {	return pays;		}
	public String getCap()	{	return capital;		}
	public double getPop()	{	return population;	}
	public double getSup()	{	return superficie;	}
	
}
	public String toString()
{
		return String.format("%-30s %8d %7.2f %9.1f %6c", continent, pays, capital, population, superficie);
}


public class TestPays {
	
	
	  static int lireRemplir(String nomFichier, Pays pays[]) throws IOException
	  {
		   boolean existeFichier = true ; // à ajuster après
		   int n = 0;
		
		   FileReader fr = null; // initialiser pour Java
		
		    // essayer de LOCALISER le fichier à partir de son nom
		    try {
		              fr = new FileReader (nomFichier) ;
		    }
		    // intercepter l'erreur si le fichier n'existe pas
		    catch ( java.io.FileNotFoundException erreur) {
		       System.out.println("Probleme d'ouvrir le fichier " +
		          nomFichier);
		       existeFichier = false ; // ajuster
		    }
		
		    if (existeFichier) {
		
		    	// construire l'objet d'entrée qui va permettre
		    	// d'appliquer la lecture d'une ligne de texte
		
				 BufferedReader entree = new BufferedReader(fr);
				 boolean finFichier = false ;
		
				 while ( !finFichier ) {
		
					 // lire une ligne
					 String uneLigne = entree.readLine();
					 if (uneLigne == null)
						 finFichier = true ;
					 else {
						 char cont  = uneLigne.charAt(0);
						 String p   = uneLigne.substring(1, 36);
						 String cap = uneLigne.substring(36, 62);
						 double pop = Double.parseDouble(uneLigne.substring(62, 75).trim()),
								sup = Double.parseDouble(uneLigne.substring(75).trim());
						 //double numero = Integer.parseInt(uneLigne.substring(64).trim())       ;
						 pays[n++] = new Pays( cont, p, cap, pop, sup );
		
		            }
		        }
		      entree.close();
		
		   }
		 return n;
		}
	  static void afficher(Personne[] pers, int nbPers, String message)
	    {
	    	System.out.printf("Contenu du tableau de %d personnes %s :\n", nbPers, message);
	    	System.out.printf("  i  Nom et Prénom                      numéro taille    poids    sexe\n");

	    	for(int i = 0; i < nbPers; i++)
	    		System.out.printf("%3d) %s\n", i, pers[i]);
	    	System.out.printf("\n\n");
	    }

	
	 
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int MAX_NB_PAYS=250;
		Pays pays [] = new Pays[MAX_NB_PAYS];
		int nbP = lireRemplir("pays.txt", pays);
		
		System.out.printf("1- Nombre de pays lue = %d\n\n", nbP);
	}
