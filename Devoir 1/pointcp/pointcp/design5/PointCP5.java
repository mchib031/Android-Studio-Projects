// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */

 /* Decsription generale: la classe PointCP5 est une classe abstraite qui a comme sous classe CP2 et CP3. Donc pour trouver les coordonnes cartesiennes et polaires ca depend de la classe concrete qui va etre utilise.


 */
abstract class PointCP5{

/**
 * Contient le type des coordonnes soit cartesienne ou polaire
 */
private char typeCoord;

/**
 * Contient soit x ou rho dependamment du type de coordonnes
 */
private double xOrRho;

/**
 * Contient y or theta dependamment du type de coordonnes
 */
private double yOrTheta;


//Constructeurs


public PointCP5(char type, double xOrRho, double yOrTheta){

								if(type != 'C' && type != 'P'){
											throw new IllegalArgumentException();
								}
								this.xOrRho = xOrRho;
								this.yOrTheta = yOrTheta;
								typeCoord = type;
}



public abstract double getX();

public abstract double getY();

public abstract double getRho();

public abstract double getTheta();


/**
 * Convertit cartesien --> polaire
 */
public abstract PointCP5 convertStorageToPolar();

/**
 * Convertit polaire ---> cartesienne
 */
public abstract PointCP5 convertStorageToCartesian();

/**
 * Calculates the distance in between two points using the Pythagorean
 * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
 *
 * @param pointA The first point.
 * @param pointB The second point.
 * @return The distance between the two points.
 */
public double getDistance(PointCP5 pointB){

	double x = getX() - pointB.getX();
  double y = getY() - pointB.getY();

  return Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
}

/**
 * Rotates the specified point by the specified number of degrees.
 * Not required until E2.30
 *
 * @param point The point to rotate
 * @param rotation The number of degrees to rotate the point.
 * @return The rotated image of the original point.
 */

public abstract PointCP5 rotatePoint(double rotation);

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
