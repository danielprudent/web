import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.w3c.dom.ranges.RangeException;

class Pays {
	
	//1- Déclaration des Attributs :
	private char continent ;
	private String pays, capital;
	private double population, superficie;
	
	//2- Les Constructeurs
	public Pays(char continent, String pays, String capital, double population, double superficie) {
		this.setContinent(continent);
		this.setPays(pays);
		this.setCap(capital);
		this.setPopulation(population);
		this.setSuperficie(superficie);
		//this.numero = numero;
	}
	
	//3- Getters & Setters
	public char getCont() 	{	return continent;	}
	public String getPays() {	return pays;		}
	public String getCap()	{	return capital;		}
	public double getPop()	{	return population;	}
	public double getSup()	{	return superficie;	}
	
	public void setContinent(char c) {
		this.continent = c;
	}
	
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public void setCap(String c) {
		this.capital = c;
	}
	
	public void setPopulation(double p) {
		this.population = p;
	}
	
	public void setSuperficie(double p) {
		this.superficie = p;
	}
//}
	public String toString() {  
		return String.format("%-30c %8s %7s %7.0f %7.0f", continent, pays, capital, population, superficie);
	}
	
	public boolean equals(Object obj) {
		//Redéfinition de la méthode equals
		if (this == obj) return true;
		else {
			if (!(obj instanceof Pays)) return false;
			else {
				Pays autre = (Pays) obj;
				return this.pays.trim().equalsIgnoreCase(autre.pays.trim());
			}
		}
	}
	
	
		
}

public class Application {

	static Pays pays [];
	static int nbPays;
	

	
	static void nomPaysEgalNomCap(Pays [] pays, int nbPays) {
		//4. Afficher les pays dont le nom est identique au nom de la capitale (exemple	Luxembourg)
		
		//1- Parcourir le tableau
		//2- Comparer les capitale de chaque pays avec son nom
		//3- Afficher
		String s = "";
		for(int i=0; i<nbPays; i++) {	//1- Parcourir le tableau
			if ( pays[i].getPays().trim().equals( pays[i].getCap().trim() )){//2- Comparer les capitale de chaque pays avec son nom
				s += pays[i] + "\n";	// Générer la chaine des noms de pays
			}
		}
		//3- Afficher
		if (s.equals("")) System.out.printf("\nAucun pays n'a le nom de sa capitale !!!");
		else	
			System.out.printf("\n4- Les pays dont le nom égal au nom de sa capitale sont :\n%s", s);
		System.out.printf("\n\n");
	}
	
	static int lireRemplir(String nomFichier) throws IOException {
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
	  static void afficher(Pays pays[], int nbP, String message) { // afficher tableau avec message 
	    	System.out.printf("Contenu du tableau de %d personnes %s :\n", nbP, message);
	    	System.out.printf("  i  continent                      pays capital    population    superficie\n");

	    	for(int i = 0; i < nbP; i++)
	    		System.out.printf("%3d) %s\n", i, pays[i]);
	    	System.out.printf("\n\n");
	   }
	  
	  static void afficherDixPremier() {
		  for(int i = 0; i < 10; i++) {
			  System.out.println(pays[i].toString());
		  }
	  }
	
	static Pays getPaysByName(String n) {
		Pays p = null;
		for (int o = 0; o < nbPays; o++) {
			if(pays[o].getPays().trim().equals(n)) {
				return pays[o];
			}
		}
		return null;
	}
	
	  static void afficherHuitPremier() {
		  for(int i = 0; i < 8; i++) {
			  System.out.println(pays[i].toString());
		  }
	  }
		static int partitionner ( Pays[]T, int debut, int fin)
		{ int g = debut , d = fin  ;
	      String valPivot  = T[debut].getPays();
	      Pays tempo ;

	  	  do
		  {   while ( g <= d && (T[g].getPays().compareTo(valPivot)<=0)) g++;
		      while ( T[d].getPays().compareTo(valPivot)> 0) d--;

			  if ( g < d )
			  	// echanger(T, g, d);

			  { tempo = T[g];
				T[g] = T[d];
				T[d] = tempo;
	          }
	 }	while ( g <= d ) ;
		  // echanger(T, debut, d);

		  tempo = T[debut];
		  T[debut] = T[d];
		  T[d] = tempo;

		  return d;
		}
	  
	  static void quickSort (Pays [] T, int gauche, int droite)
	  {  if (droite > gauche) /* au moins 2 ?l?ments */
			{
			  int indPivot = partitionner ( T, gauche, droite);
			  quickSort ( T, gauche, indPivot - 1 );
			  quickSort ( T, indPivot + 1, droite);
			}
	  }
	  static int indDicho(String aChercher, int nbElem, Pays[] t)
	   {
	    int mini = 0, maxi = nbElem - 1;

	    while (mini <= maxi) {
	               int milieu = (mini + maxi) / 2 ;
	               if ( aChercher.trim().compareToIgnoreCase(t[milieu].getPays().trim()) < 0)
	                    maxi = milieu - 1 ;
	               else  if (aChercher.trim().compareToIgnoreCase(t[milieu].getPays().trim()) > 0)
	                             mini = milieu + 1 ;
	                     else return milieu;
	     }
	    return -1 ; // non trouvé
	   }
		static void creerTexte(char paysVoulu, Pays[] pays, int nbPers, String nomACreer)
				throws IOException
			{

				boolean probleme = false;
				FileWriter fw = null;
				try
				{
				    fw = new FileWriter(nomACreer);
				} catch (java.io.FileNotFoundException erreur)
				{
					System.out.println("Problème de préparer l'écriture\n");
					probleme = true;
				}
				if (!probleme)
				{
					System.out.println("Début de la création du fichier\n");
					PrintWriter aCreer = new PrintWriter( fw );

					for (int i = 0; i < nbPers; i++)
						if (pays[i].getPays().equals(paysVoulu))
							aCreer.printf("%s\n", pays[i]);

					aCreer.close();
					System.out.println("Fin de la création du fichier " +
									      nomACreer + "\n\n");
				}

			}
public static void main(String[] args) throws IOException {
	
	int MAX_NB_PAYS=250;
	pays = new Pays[MAX_NB_PAYS];

	try {
		nbPays = lireRemplir("pays.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.printf("1) Nombre de pays lue = %d\n\n", nbPays);
	afficherDixPremier();
	System.out.printf("3) Population d allemagne x10 : ");
	getPaysByName("ALLEMAGNE").setPopulation(getPaysByName("ALLEMAGNE").getPop() * 10);
	System.out.println(getPaysByName("ALLEMAGNE").getPop());
	afficherHuitPremier();
	
	//4. Afficher les pays dont le nom est identique au nom de la capitale (exemple	Luxembourg)
	nomPaysEgalNomCap(pays, nbPays);
	
	//5. Trier (rapide) selon les noms des pays et d’afficher les 10 premiers pays après le tri
	 quickSort(pays, 0, nbPays-1);
     afficherDixPremier();//(pays, nbPays, "apres le tri");
     creerTexte('5', pays, nbPays, "Europe.txt");
 	 creerTexte('3', pays, nbPays, "Asie.txt");
     String[] aChercher = { "Canada", "France", "Japon", "Mexique" };
     int nbPersRecherchee = aChercher.length;

     for(int i = 0; i < nbPersRecherchee ; i++)
     {
     	 System.out.printf("La recherche dichotomique de %s\n", aChercher[i]);
     	 int k = indDicho(aChercher[i], nbPays, pays);
     	 if ( k < 0)
     	 	System.out.printf("On ne trouve pas cette personne\n\n");
     	 else
     	 {
     	 	// à expliquer en classe
     	 	int debut = k, fin = k ;
     	 	while(debut >= 0 && pays[debut].equals(pays[k])) debut--;
     	 	debut++;

     	 	while(fin < nbPays && pays[fin].equals(pays[k])) fin++;
     	 	fin--;

     	 	if (debut == fin)
                  System.out.printf("L'unique personne trouvee :\n%s\n", pays[k]);
           else
           	   for(int z = debut; z <= fin ; z++)
           	   	  System.out.printf("%5d) %s\n", z, pays[z]);
     	 	
     	 }
     }
  
	
}//main
}
