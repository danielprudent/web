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
	  
	  
	
	
	public static void main(String[] args) {

	       String telUDM = "5143436111", telJean = "4503861504";
	 
			char c = '3', b= '1', a= '4';
	 
	       int regUDM = Integer.parseInt( telUDM.substring(0,3));
	       int regJean = Integer.parseInt( telJean.substring(0,3));
	       int echangeUDM = Integer.parseInt( telUDM.substring(3,6));
	       int echangeJean = Integer.parseInt( telJean.substring(3,6));
	       int numeroUDM = Integer.parseInt( telUDM.substring(6));
	       int numeroJean = Integer.parseInt( telJean.substring(6));
	 
	 
	      System.out.printf("1- Téléphone d’UdM   : (%d)%d-%d\n", regUDM, echangeUDM, numeroUDM );
	      System.out.printf("1- Téléphone de Jean : (%d)%d-%d\n",regJean, echangeJean, numeroJean );
	      
	      System.out.println("2- Il y a " + compt(c, telUDM) + " X le chiffre " + c + " dans téléphone UdM.");
		  System.out.println("2- Il y a " + compt(b, telUDM) + " X le chiffre " + b + " dans téléphone UdM.");              
	      System.out.println("2- Il y a " + compt(a, telJean) + " X le chiffre " + a + " dans téléphone de Jean.");                            
	 
	 
	    }
	

	 
	 
	 
	    }
		// TODO Auto-generated method stub

 
