// Exemple expliqu� + tap� au cours sur la POO, niveau simple


class Cercle
{ private double rayon ;

  // un constructeur :
  public Cercle(double r)
  {
  	 rayon = r;
  }

  // une m�thode : calcul et retourne le p�rim�tre
  public double perimetre()
  {// 2 x PI x rayon o� PI 3.14159

  	return 2 * Math.PI * rayon;
  }

  // une autre m�thode :calcul et retourne la surface
  public double surface()
  { // PI x (rayon au carr�)

    return Math.PI * Math.pow(rayon, 2);
  }

  // m�thode d'acc�s :
  public double getRayon()
  {
  	return rayon ;
  }

  // m�thode de modification :
  public void setRayon(double nouvRayon)
  {
  	rayon = nouvRayon;
  }

  // afficher un cercle avec un bon en-t�te (voir l'ex�cution)
  public void afficher(String en_tete)
  {
    System.out.printf("%s :\n", en_tete);
    System.out.printf(" - rayon     : %.1f\n", rayon);
    System.out.printf(" - p�rim�tre : %.2f\n", perimetre());
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

		// afficher le p�rim�tre du cercle c1 :
        System.out.printf("Le p�rim�tre du cercle c1 : %.1f\n",
                  c1.perimetre()) 		;
        System.out.printf("La surface   du cercle c1 : %.1f\n",
                  c1.surface()) 		;
        c1.afficher("Infos du premier cercle");
        c2.afficher("Coordonn�es du cercle c2");

        // afficher le rayon du cercle c1:
        System.out.printf("Le rayon du cercle c1 : %.1f\n",
             c1.getRayon());
        // modifier le rayon du cercle c2, c'est le double
        // du rayon de c1
        c2.setRayon(2 * c1.getRayon()) ;
        c2.afficher("Infos de c2 apr�s avoir modifi� son rayon");
    }
}
/* Ex�cution :

--------------------Configuration: <Default>--------------------
Le p�rim�tre du cercle c1 : 35,8
La surface   du cercle c1 : 102,1
Infos du premier cercle :
 - rayon     : 5,7
 - p�rim�tre : 35,81
 - surface   : 102,07

Coordonn�es du cercle c2 :
 - rayon     : 10,2
 - p�rim�tre : 64,09
 - surface   : 326,85

Le rayon du cercle c1 : 5,7
Infos de c2 apr�s avoir modifi� son rayon :
 - rayon     : 11,4
 - p�rim�tre : 71,63
 - surface   : 408,28


Process completed.
*/