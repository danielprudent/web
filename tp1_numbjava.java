public class NumB {
	 
	 
	 
	 
	 static int compt(char c,String tel)
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
	  
	  
	 static void afficherImpairs(String telJean, String nom)
	    {
	      System.out.printf("3- Les chiffres impairs dans %10s : ",nom);
	      for(char c = '1' ; c <= '9'; c+=2)
	      	if (telJean.indexOf(c) >= 0)
	      	   System.out.printf("%c ", c);
	      System.out.printf("\n");
	    }
	 
	 static void afficherPairs(String telUDM, String nom)
	    {
	      System.out.printf("3- Les chiffres pairs dans %10s : ",nom);
	      for(char c = '0' ; c <= '9'; c+=2)
	      	if (telUDM.indexOf(c) >= 0)
	      	   System.out.printf("%c ", c);
	      System.out.printf("\n");
	    }
	 static void commun(String telJean, String telUDM){
		    for(int i=0;i<telJean.length();i++){
		        for(int j=0;j<telUDM.length();j++){
		            if(telJean.charAt(i)==telUDM.charAt(j))
		            	System.out.printf( "%c", telJean.charAt(i));

		        }

		    }
		}
	 
	 static char maxi(String telUDM)
	    {
	    	char plusGrandChif = '0' ;
	    	for(int i = 0; i < telUDM.length(); i++)
	    		if (telUDM.charAt(i) > plusGrandChif)
	    			  plusGrandChif = telUDM.charAt(i);
	        return plusGrandChif;
	    }
	 
	 static char min (String telJean)
	    {
	    	char plusPetitChif = '0' ;
	    	for(int i = 0; i < telJean.length(); i++)
	    		if (telJean.charAt(i) < plusPetitChif)
	    			  plusPetitChif -= telJean.charAt(i);
	        return plusPetitChif;
	    }

	public static void main(String[] args) {

	       String telUDM = "5143436111", telJean = "4501897654";
	 
			char c = '3', b= '1', a= '2';
	 
	       int regUDM = Integer.parseInt( telUDM.substring(0,3));
	       int regJean = Integer.parseInt( telJean.substring(0,3));
	       int echangeUDM = Integer.parseInt( telUDM.substring(3,6));
	       int echangeJean = Integer.parseInt( telJean.substring(3,6));
	       int numeroUDM = Integer.parseInt( telUDM.substring(6));
	       int numeroJean = Integer.parseInt( telJean.substring(6));
	 
	 
	      System.out.printf("1- Téléphone d’UdeM   : (%d)%d-%d\n", regUDM, echangeUDM, numeroUDM );
	      System.out.printf("1- Téléphone de Jean : (%d)%d-%d\n",regJean, echangeJean, numeroJean );
	      
	      System.out.println("2- Il y a " + compt(c, telUDM) + " X le chiffre " + c + " dans téléphone UdM.");
		  System.out.println("2- Il y a " + compt(b, telUDM) + " X le chiffre " + b + " dans téléphone UdM.");              
	      System.out.println("2- Il y a " + compt(a, telJean) + " X le chiffre " + a + " dans téléphone de Jean.");                            
	      afficherImpairs(telJean,"telJean");
	      afficherPairs(telUDM,"telUDM");
	      commun(telUDM, telJean);
	      System.out.printf("\n5- Le chiffre le plus grand dans le numero %s est %c\n", telUDM, maxi(telUDM));
	       System.out.printf("5- Le chiffre le plus petit dans le numero %s est %c\n", telJean, min(telJean));
	 
	    }
	

	 
	 
	 
	    }
		// TODO Auto-generated method stub

	

