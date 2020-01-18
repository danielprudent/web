
public class NumB {
	 
	 
	 
	 
	 static int compt(char c,String tel) // methode compteur pour afficher nombre de fois un nombre X en present dans un des deux num tel 
	 {
	     int count = 0;
	     
	     for (int i=0; i < tel.length(); i++)
	     {
	         if (tel.charAt(i) == c)
	         {
	              count++;
	         }
	     }
	     return count;
	 }
	  
	  
	 static void afficherImpairs(String telJean, String nom) // methode pour afficher les chiffres impairs
	    {
	      System.out.printf("3- Les chiffres impairs dans %10s : ",nom);
	      for(char c = '1' ; c <= '9'; c+=2) // +2
	      	if (telJean.indexOf(c) >= 0) // doit etre trouvable
	      	   System.out.printf("%c ", c);
	      System.out.printf("\n");
	    }
	 
	 static void afficherPairs(String telUDM, String nom) // methode pour afficher les chiffres pairs
	    {
	      System.out.printf("3- Les chiffres pairs dans %10s : ",nom);
	      for(char c = '0' ; c <= '9'; c+=2) // de 0 a 9 (0 + 2) chiffre pair 
	      	if (telUDM.indexOf(c) >= 0) // trouvable 
	      	   System.out.printf("%c ", c);
	      System.out.printf("\n");
	    }
	 static void commun(String telJean, String telUDM) // methode pour chiffre en commum 
	 { 
		    for(int i=0;i<telJean.length();i++){ // vaut 10 
		        for(int j=0;j<telUDM.length();j++){ // vaut 10 
		            if(telJean.charAt(i)==telUDM.charAt(j))
		            	System.out.printf( "%c", telJean.charAt(i));

		        }

		    }
		}
	 
	 static char maxi(String telUDM)// methode plus grand chiffre du teludem 
	    {
	    	char plusGrandChif = '0' ;
	    	for(int i = 0; i < telUDM.length(); i++)
	    		if (telUDM.charAt(i) > plusGrandChif)
	    			  plusGrandChif = telUDM.charAt(i);
	        return plusGrandChif;
	    }
	 
	 static char min (String telJean) // methode pour chiffre minimum teljean
	    {
	    	char plusPetitChif = '0' ;
	    	for(int i = 0; i < telJean.length(); i++)
	    		if (telJean.charAt(i) < plusPetitChif)
	    			  plusPetitChif -= telJean.charAt(i);
	        return plusPetitChif;
	    }

	public static void main(String[] args) { // fonction main 

	       String telUDM = "5143436111", telJean = "4501897654"; // les deux numeros en string 
	 
			char c = '3', b= '1', a= '2'; // les chiffre qu'on doit analyser numero 1) du tp 
	 
	       int regUDM = Integer.parseInt( telUDM.substring(0,3)); // code regional des telephone udem et jean substring
	       int regJean = Integer.parseInt( telJean.substring(0,3));
	       int echangeUDM = Integer.parseInt( telUDM.substring(3,6));// echange des telephone udem et jean substring
	       int echangeJean = Integer.parseInt( telJean.substring(3,6));
	       int numeroUDM = Integer.parseInt( telUDM.substring(6));// numero des telephone udem et jean substring 
	       int numeroJean = Integer.parseInt( telJean.substring(6));
	 
	 
	      System.out.printf("1- Téléphone d’UdeM   : (%d)%d-%d\n", regUDM, echangeUDM, numeroUDM ); // affichage ddes numero
	      System.out.printf("1- Téléphone de Jean : (%d)%d-%d\n",regJean, echangeJean, numeroJean );
	      
	      System.out.println("2- Il y a " + compt(c, telUDM) + " fois le chiffre " + c + " dans téléphone UdM."); // affichage de combien de fois
		  System.out.println("2- Il y a " + compt(b, telUDM) + " fois le chiffre " + b + " dans téléphone UdM.");       // revien le nombre X        
	      System.out.println("2- Il y a " + compt(a, telJean) + " fois le chiffre " + a + " dans téléphone de Jean.");                            
	      afficherImpairs(telJean,"telJean"); // afficher chiffres impairs
	      afficherPairs(telUDM,"telUDM"); // afficher chiffres pairs
	      commun(telUDM, telJean);// afficher nombre commum dans les deux numero 
	      System.out.printf("\n5- Le chiffre le plus grand dans le numero %s est %c\n", telUDM, maxi(telUDM)); // chiffre maxi afficher 
	       System.out.printf("5- Le chiffre le plus petit dans le numero %s est %c\n", telJean, min(telJean)); // chiffre min afficher 
	 
	    }
	

	 
	 
	 
	    }
		// TODO Auto-generated method stub

	


