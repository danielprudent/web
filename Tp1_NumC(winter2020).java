class Employe {
	
	private String Nas; // 200 101 122 Numero Ass Social 
	double Salaire; // ex : 40$/h ou 4000$ par semaine (default)
			                    
			
	public Employe(String Nas, double Salaire)
			{
		this.Nas  = Nas; // ce this est obligatoire
		this.Salaire = Salaire; // ce this est obligatoire
	//	this.globale  = globale; // ce this est optionnel (facultatif)
			}
	
	public Employe(String Nas, double horaire, double heure)
	{
		this.Nas = Nas;
		this.Salaire = horaire * heure;
		 

		// ou   this(nomPre, cP,0.30 * tps + 0.30 * intra + 0.40 * exFinal);
	}
	public Employe(String Nas)
	{
		this(Nas,1250.25); // Salaire par défaut
	}

	public void afficher(String message)  { // message pour le tableau
	  	System.out.printf(" %sNas : %s | Salaire : %.2f", message , Nas, Salaire);
	 }
	
	public void setSalaire(double sal)
	{
		this.Salaire =  sal;
		 

		
	}
	public double getSalaire()
	{
		return Salaire ;
		 

		
	}
			} // Fin class employe 
public class TestEmploye {

	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Employe emp1 = new Employe("250 642 753", 1234.56), 
		        emp2 = new Employe("123 456 789"), // par défaut 1250.25$
		        emp3 = new Employe("250 343 678", 40.00, 25.75),
		        // salHebdo = 40 heures par semaine x taux d’horaire 25.75$
		        emp4 = new Employe("450 279 321", 1750.75);

		
		 // afficher toutes les infos de emp3:
	      emp3.afficher("2- Information de l'employé 3 : \n");
	      System.out.printf("\n\n");
	      
	      // afficher toutes les infos de emp4:
	      emp4.afficher("2- Information de l'employé 4 : \n");
	      System.out.printf("\n\n");
	      
		  emp2.setSalaire(emp3.getSalaire()+emp1.getSalaire());
		// afficher toutes les infos de emp4:
	      emp2.afficher("3- Information de l'employé 2 : \n");
	      System.out.printf("\n\n");
		
		
		
		// TODO Auto-generated method stub

	}

}
