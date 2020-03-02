import java.io.*;

public class TestPays {
	
	private String continent ;
	private String   capital ;
	private int  population, superficie;
	//private int    numero;
	
	public TestPays(String continent, String capital, int population, int superficie)
	{
		this.continent = continent;
		this.capital  = capital;
		this.population = population;
		this.superficie = superficie;
		//this.numero = numero;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    static int lireRemplir(String nomFichier)
	           throws IOException
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
              String nP = uneLigne.substring(0, 30);
              char sexe = uneLigne.charAt(30);

              double taille = Double.parseDouble(uneLigne.substring(37,41).trim()),
                     poids  =  Double.parseDouble(uneLigne.substring(50,56).trim());
              int numero = Integer.parseInt(uneLigne.substring(64).trim())       ;
              pays[n++] = new Pays(continent, capital, population, superficie);

            }
        }
      entree.close();

   }
 return n;
}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
