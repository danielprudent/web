// Exemple expliqué + tapé au cours sur la POO, niveau simple


class Cercle
{ private double rayon ;

  // un constructeur :
  public Cercle(double r)
  {
  	 rayon = r;
  }

  // une méthode : calcul et retourne le périmètre
  public double perimetre()
  {// 2 x PI x rayon où PI 3.14159

  	return 2 * Math.PI * rayon;
  }

  // une autre méthode :calcul et retourne la surface
  public double surface()
  { // PI x (rayon au carré)

    return Math.PI * Math.pow(rayon, 2);
  }

  // méthode d'accès :
  public double getRayon()
  {
  	return rayon ;
  }

  // méthode de modification :
  public void setRayon(double nouvRayon)
  {
  	rayon = nouvRayon;
  }

  // afficher un cercle avec un bon en-tête (voir l'exécution)
  public void afficher(String en_tete)
  {
    System.out.printf("%s :\n", en_tete);
    System.out.printf(" - rayon     : %.1f\n", rayon);
    System.out.printf(" - périmètre : %.2f\n", perimetre());
    System.out.printf(" - surface   : %.2f\n", surface());
    System.out.printf("\n");
  }


} // fin de Cercle

public class Ex_Cercle_A19
{
	public static void main(String [] args)
	{
		// instancier un cercle de rayon 5.7
		Cercle c1 = new Cercle(5.7),
			   c2 = new Cercle(10.2);

		// afficher le périmètre du cercle c1 :
        System.out.printf("Le périmètre du cercle c1 : %.1f\n",
                  c1.perimetre()) 		;
        System.out.printf("La surface   du cercle c1 : %.1f\n",
                  c1.surface()) 		;
        c1.afficher("Infos du premier cercle");
        c2.afficher("Coordonnées du cercle c2");

        // afficher le rayon du cercle c1:
        System.out.printf("Le rayon du cercle c1 : %.1f\n",
             c1.getRayon());
        // modifier le rayon du cercle c2, c'est le double
        // du rayon de c1
        c2.setRayon(2 * c1.getRayon()) ;
        c2.afficher("Infos de c2 après avoir modifié son rayon");
    }
}
/* Exécution :

--------------------Configuration: <Default>--------------------
Le périmètre du cercle c1 : 35,8
La surface   du cercle c1 : 102,1
Infos du premier cercle :
 - rayon     : 5,7
 - périmètre : 35,81
 - surface   : 102,07

Coordonnées du cercle c2 :
 - rayon     : 10,2
 - périmètre : 64,09
 - surface   : 326,85

Le rayon du cercle c1 : 5,7
Infos de c2 après avoir modifié son rayon :
 - rayon     : 11,4
 - périmètre : 71,63
 - surface   : 408,28


Process completed.
*/