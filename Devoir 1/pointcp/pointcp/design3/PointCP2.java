/*
Description de ce programme: le programme de point CP2 fait le stockage des donnees polaire seulement.
Les donnees cartesienne peuvent etre trouves a l'aide de calcule mais ces donnees ne vont pas etre stocker par la suite.
Comme ce programme est specialement concu pour les coordonnes polaire alors les variables d'instances seront bien evidamment RHO et THETA

*/
public class PointCP2 {

	/**
	 * Contient C pour (cartesian) ou P pour (polar) pour identifier le tye de donnees dans cette variable.
	 */
	private char typeCoord;

	/**
	 * Contient la valeur de RHO
	 */
	private double rho;

	/**
	 * Contient la valeur de THETA
	 */
	private double theta;

//Constructeurs

	public PointCP2(char type, double xOrRho, double yOrTheta) {
    if (type != 'C' && type != 'P')
      throw new IllegalArgumentException();

    if (type == 'C') {
      rho = (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
      theta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
    } else {
      rho = xOrRho;
      theta = yOrTheta;
    }
    typeCoord = 'P';
  }
//Instance methods **************************************************

	public double getX() {
		return (Math.cos(Math.toRadians(theta)) * rho);
	}

	public double getY() {
		return (Math.sin(Math.toRadians(theta)) * rho);
	}

	public double getRho() {
		return rho;

	}

	public double getTheta() {
		return theta;
	}

	/**
	 * Cette methode permet la conversion a polaire
	 */
	 public void convertStorageToPolar()
   {
    /* if(typeCoord != 'P')
     {
       //Calculate RHO and THETA
       double temp = getRho();
       theta = getTheta();
       rho = temp;

       typeCoord = 'P';  //Change coord type identifier
     }*/
   }

   /**
    * Converts Polar coordinates to Cartesian coordinates.
    */
   public void convertStorageToCartesian()
   {
     if(typeCoord != 'C')
     {
       //Calculate X and Y
       double temp = getX();
       theta = getY();
       rho = temp;

       typeCoord = 'C';	//Change coord type identifier
     }
	}

	/**
	 * Calculates the distance in between two points using the Pythagorean theorem
	 * (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	 *
	 * @param pointA The first point.
	 * @param pointB The second point.
	 * @return The distance between the two points.
	 */
	public double getDistance(PointCP2 pointB) {

		return Math.sqrt((Math.pow(getX() - pointB.getX(), 2) + Math.pow(getY() - pointB.getY(), 2)));
	}

	/**
	 * Calculates the distance in between two points using the Pythagorean theorem
	 * (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	 *
	 * @param pointA The first point.
	 * @param pointB The second point.
	 * @return The distance between the two points.
	 */

	/**
	 * Rotates the specified point by the specified number of degrees. Not required
	 * until E2.30
	 *
	 * @param point    The point to rotate
	 * @param rotation The number of degrees to rotate the point.
	 * @return The rotated image of the original point.
	 */

	public PointCP2 rotatePoint(double rotation) {
		return new PointCP2(typeCoord,
				(Math.cos(Math.toRadians(rotation)) * getX()) - (Math.sin(Math.toRadians(rotation)) * getY()),
				(Math.sin(Math.toRadians(rotation)) * getX()) + (Math.cos(Math.toRadians(rotation)) * getY()));
	}

	/**
	 * Returns information about the coordinates.
	 *
	 * @return A String containing information about the coordinates.
	 */
	public String toString() {
		return "Stored as " + (typeCoord == 'C' ? "Cartesian  (" + getX() + "," + getY() + ")"
				: "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
	}

}
