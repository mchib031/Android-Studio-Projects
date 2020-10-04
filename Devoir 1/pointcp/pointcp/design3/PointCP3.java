/*
Description generale: Ce programme est concu afin de stocker des coordonnes cartesiennes, alors les donnees cartesinnes seront retournes et si l'utilisateur
rentre comme entrer des donnees polaire alors ca sera calcule mais les coordonnes polaires ne seront pas stocker.
En comparant avec le programme precedant, c'est l'inverse de la fonctionalite de Point CP2.



*/
public class PointCP3 {


/**
 * Contient le type de la donnee soit cartesienne (C) ou polaire (P)
 */
private char typeCoord;

/**
 * Contient soit x ou rho dependamment du type de coordonnees
 */
private double x;

/**
 * Contient Y ou theta dependamment du type de coordonnees
 */
private double y;


//Constructeurs


public PointCP3(char type, double xOrRho, double yOrTheta){
								if(type != 'C' && type != 'P')
																throw new IllegalArgumentException();

								if (type == 'P') {
																this.x = (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
																this.y = (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
								} else {
																this.x = xOrRho;
																this.y = yOrTheta;
								}
								typeCoord = 'C';
}



public double getX()
{
								return x;

}

public double getY()
{

								return y;

}

// methode pour trouver la valeur de rho
public double getRho()
{
								return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
}

// methode pour trouver la valeur de theta
public double getTheta()
{
								return (Math.toDegrees(Math.atan2(getTheta(), getRho())));

}

/**
 * conertit les donnees cartesienne en donnee polaire.
 */
public void convertStorageToPolar(){
							//	return new PointCP2(typeCoord, getX(), getY());
							 if(typeCoord != 'P')
					     {
					       //Calculate RHO and THETA
					       double temp = getRho();
					       theta = getTheta();
					       rho = temp;

					       typeCoord = 'P';  //Change coord type identifier
					     }
}


/**
 * convertit les donnees polaire en cartesienne
 */

public void convertStorageToCartesian(){
								return this;
}


/**
 * Calculates the distance in between two points using the Pythagorean
 * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
 *
 * @param pointA The first point.
 * @param pointB The second point.
 * @return The distance between the two points.
 */
public double getDistance(PointCP3 pointB)
{
								// Obtain differences in X and Y, sign is not important as these values
								// will be squared later.

								return Math.sqrt((Math.pow(getX() - pointB.getX(), 2) + Math.pow(getY() - pointB.getY(), 2)));
}

/**
 * Rotates the specified point by the specified number of degrees.
 * Not required until E2.30
 *
 * @param point The point to rotate
 * @param rotation The number of degrees to rotate the point.
 * @return The rotated image of the original point.
 */
public PointCP2 rotatePoint(double rotation)
{
								return new PointCP2('C',
								(Math.cos(Math.toRadians(rotation)) * getX()) - (Math.sin(Math.toRadians(rotation)) * getY()),
								(Math.sin(Math.toRadians(rotation)) * getX()) + (Math.cos(Math.toRadians(rotation)) * getY()));
}

/**
 * Returns information about the coordinates.
 *
 * @return A String containing information about the coordinates.
 */
public String toString()
{
	return "Stored as " + (typeCoord == 'C'
			? "Cartesian  (" + getX() + "," + getY() + ")"
			: "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
}



}
