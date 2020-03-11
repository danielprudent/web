/* Auteur : Daniel Prudent cour ; IFT 1170 Java (TP2) 
 * Le projet du tp2 consiste a mettre en 
 * pratique les notions que nous avons appris 
 * toString*(redefinition), this, equals, creatioon fichier
 * lire et remplir, recherche dichotomique et le quickSort en Java 
 * Les numeros sont bien numeroté pour aide votre comprehension 
*/

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.w3c.dom.ranges.RangeException;
// declaration pour le bon fonctionnement du programme 
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

	public String toString() {  // redefinition avec toString
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
	

	
	static void nomPaysEgalNomCap(Pays [] pays, int nbPays) { // methode pays = cap
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
	
	static int lireRemplir(String nomFichier) throws IOException { // lire remplir le fichier methode
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
	  
	  static void afficherDixPremier() { // methode parcourir et afficher 10 premier pays avec toString 
		  for(int i = 0; i < 10; i++) {
			  System.out.println(pays[i].toString());
		  }
	  }
	
	static Pays getPaysByName(String n) { // methode pour l'allemagne changement de valeur 
		Pays p = null;
		for (int o = 0; o < nbPays; o++) {
			if(pays[o].getPays().trim().equals(n)) {
				return pays[o];
			}
		}
		return null;
	}
	
	  static void afficherHuitPremier() {  // methode parcourir afficher 8 premier avec toString 
		  for(int i = 0; i < 8; i++) {
			  System.out.println(pays[i].toString());
		  }
	  }
		static int partitionner ( Pays[]T, int debut, int fin) // adaptation pour le tri rapide 
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
	  
	  static void quickSort (Pays [] T, int gauche, int droite) // methode quickSort 
	  {  if (droite > gauche) /* au moins 2 ?l?ments */
			{
			  int indPivot = partitionner ( T, gauche, droite);
			  quickSort ( T, gauche, indPivot - 1 );
			  quickSort ( T, indPivot + 1, droite);
			}
	  }
	  static int indDicho(String aChercher, int nbElem, Pays[] t) // methode rechercher dicho
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
	    return -1 ; 
	   }
		static void creerTexte(char paysVoulu, Pays[] pays, int nbPers, String nomACreer) // methode pour la creation fichier txt
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
					System.out.println("\n\n7) Début de la création du fichier\n");
					PrintWriter aCreer = new PrintWriter( fw );

					for (int i = 0; i < nbPers; i++)
						if (pays[i].getPays().equals(paysVoulu))
							aCreer.printf("%s\n", pays[i]);

					aCreer.close();
					System.out.println("Fin de la création du fichier " +
									      nomACreer + "\n\n");
				}

			}
public static void main(String[] args) throws IOException { // debut du main 
	
	int MAX_NB_PAYS=250; // pour lire et remplir appel et adaptation MAX 250 pays 
	pays = new Pays[MAX_NB_PAYS];

	try {
		nbPays = lireRemplir("pays.txt"); // lire le fichier txt pays 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.printf("1) Le mombre de pays lue est  %d\n\n", nbPays);
	System.out.printf("2) Les 10 premiers pays sont : \n");
	afficherDixPremier(); // appel fonction afficher
	System.out.printf("\n");
	System.out.printf("3) La population d'allemagne est maintenant de : ");
	getPaysByName("ALLEMAGNE").setPopulation(getPaysByName("ALLEMAGNE").getPop() * 10); // appel changement pop allemagne x10
	System.out.println(getPaysByName("ALLEMAGNE").getPop());
	System.out.printf("\n");
	System.out.printf("3) Les 8 premiers pays sont : \n");
	afficherHuitPremier(); // appel pour le methode afficher les 8 premiers pays 
	
	//4. Afficher les pays dont le nom est identique au nom de la capitale (exemple	Luxembourg)
	nomPaysEgalNomCap(pays, nbPays); // appel de la methode pays = nom capital 
	System.out.printf("5) Le tri selon les pays sont  : \n");
	//5. Trier (rapide) selon les noms des pays et d’afficher les 10 premiers pays après le tri
	 quickSort(pays, 0, nbPays-1); // quickSort -1 pour qui passe de 0 a 197 pays dans le tableau 
     afficherDixPremier();//apres le quickSort afficher les 10 pays 
     
     String[] aChercher = { "Canada", "France", "Japon", "Mexique" }; // chercher les pays decrit 
     int nbPersRecherchee = aChercher.length;

     for(int i = 0; i < nbPersRecherchee ; i++) //  rechercher dichtomique 
     {
     	 System.out.printf("\n\n6) La recherche dichotomique de %s\n\n", aChercher[i]);
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
  
     creerTexte('5', pays, nbPays, "Europe.txt"); // creation appel de la fonciton
 	 creerTexte('3', pays, nbPays, "Asie.txt"); // appel fonction creee
}//fin main 
}
/*
1) Le mombre de pays lue est  197

2) Les 10 premiers pays sont : 
2                              ETATS-UNIS                          WASHINGTON                 9629047 291289535
3                              CHINE                               PEKIN                      9596960 1273111290
5                              RUSSIE                              MOSCOU                     17075400 143954573
4                              AUSTRALIE                           CANBERRA                   7686850 19834248
3                              JAPON                               TOKYO                       377835 12761000
5                              ALLEMAGNE                           BERLIN                      357027 8253700
5                              FRANCE                              PARIS                       543964 61387038
5                              ITALIE                              ROME                        301230 57715620
3                              COREE DU SUD                        SEOUL                        99274 48324000
5                              ROYAUME-UNI                         LONDRES                     244101 58789194

3) La population d'allemagne est maintenant de : 3570270.0

3) Les 8 premiers pays sont : 
2                              ETATS-UNIS                          WASHINGTON                 9629047 291289535
3                              CHINE                               PEKIN                      9596960 1273111290
5                              RUSSIE                              MOSCOU                     17075400 143954573
4                              AUSTRALIE                           CANBERRA                   7686850 19834248
3                              JAPON                               TOKYO                       377835 12761000
5                              ALLEMAGNE                           BERLIN                     3570270 8253700
5                              FRANCE                              PARIS                       543964 61387038
5                              ITALIE                              ROME                        301230 57715620

4- Les pays dont le nom égal au nom de sa capitale sont :
1                              DJIBOUTI                            DJIBOUTI                     22000  460700
3                              KOWEIT                              KOWEIT                       17820 2041961
5                              LUXEMBOURG                          LUXEMBOURG                    2586  442972
5                              MONACO                              MONACO                         195   31842
2                              PANAMA                              PANAMA                       78200 2845647
5                              SAINT MARIN                         SAINT MARIN                     61   27336
1                              SAO TOME                            SAO TOME                      1001  165034


5) Le tri selon les pays sont  : 
3                              AFGHANISTAN                         KABOUL                      652225 29547078
1                              AFRIQUE DU SUD                      PRETORIA                   1219912 42718530
5                              ALBANIE                             TIRANA                       28748 3510484
1                              ALGERIE                             ALGER                      2381740 31763053
5                              ALLEMAGNE                           BERLIN                     3570270 8253700
5                              ANDORRE                             ANDORRA LA VELLA               468   67627
1                              ANGOLA                              LUANDA                     1246700 10766471
2                              ANTIGUA-ET-BARBUDA                  SAINT-JOHNS                    442   67448
2                              ANTILLES NEERLANDAISES              WILLEMSTAD                     800  210000
3                              ARABIE SAOUDITE                     RIYAD                      1960582 23513330


6) La recherche dichotomique de Canada

L'unique personne trouvee :
2                              CANADA                              OTTAWA                     9984670 31499560


6) La recherche dichotomique de France

L'unique personne trouvee :
5                              FRANCE                              PARIS                       543964 61387038


6) La recherche dichotomique de Japon

L'unique personne trouvee :
3                              JAPON                               TOKYO                       377835 12761000


6) La recherche dichotomique de Mexique

L'unique personne trouvee :
2                              MEXIQUE                             MEXICO                     1972550 103400165


7) Début de la création du fichier

Fin de la création du fichier Europe.txt




7) Début de la création du fichier

Fin de la création du fichier Asie.txt



*/
