/*
Decription generale: cette classe appelle Point CP4 est une classe qui contient a la fois les coordonnes cartesiennes et polaire.
ce qui signifie qu'elle a 4 variables d'instances soit (X, Y) et (Rho, Theta)
Cette methode fait simplement retourne les donnes cartesiennes et polaires ca veut dire qu'elle n'enregistre pas de valeur et ceci explique pourquoi les deux methodes de stockage
n'ont pas de retour soit ils sont des methodes void.
*/
public class PointCP4 {



/**
* Contient le type de donnee soit cartesienne ou polaire, C --> cartesienne et P --> polaire
*/
private char typeCoord;

/**
* Contient la valeur de Rho
*/
private double rho;

/**
* Contient la valeur de theta
*/
private double theta;
/**
* Contient la valeur de x
*/
private double x;

/**
* Contient la valeur de y
*/
private double y;

//Constructeurs


public PointCP4(char coordType, double xOrRho, double yOrTheta) {
							if (coordType != 'C' && coordType != 'P')
															throw new IllegalArgumentException();
							if (coordType == 'C') {
															this.x = xOrRho;
															this.y = yOrTheta;
															this.rho = (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
															this.theta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
							} else {
															this.rho= xOrRho;
															this.theta= yOrTheta;
															this.x = (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
															this.y = (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
							}
							typeCoord= coordType;
}


public double getX(){
return x;

//return typeCoord == 'C' ? x : getRho();
}

public double getY(){
return y;
//return typeCoord == 'C' ? y : getTheta();
}

public double getRho(){
return rho;
//	return typeCoord == 'P' ? rho : getX();
}

public double getTheta(){
return theta;
//	return typeCoord == 'P' ? theta : getX();
}

public char getType(){
return typeCoord;
}

private void setType(char type){
typeCoord = type;
}
/**
* Convertit cartesien --> polaire, le retour est void comme on n'enregistre rien
*/
public void convertStorageToPolar(){
if(getType()=='C'){
	setType('P');
}
}

/**
* Convertit polaire --> cartesien, le retour est void comme on n'enregistre pas rien
*/

public void convertStorageToCartesian(){
if(getType()=='P'){
	setType('C');
}
}

/**
* Calculates the distance in between two points using the Pythagorean
* theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
*
* @param pointA The first point.
* @param pointB The second point.
* @return The distance between the two points.
*/
public double getDistance(PointCP4 pointB){
return Math.sqrt((Math.pow(getX() - pointB.getX(), 2) +
									Math.pow(getY() - pointB.getY(), 2)));
}

/**
* Rotates the specified point by the specified number of degrees.
* Not required until E2.30
*
* @param point The point to rotate
* @param rotation The number of degrees to rotate the point.
* @return The rotated image of the original point.
*/
//not sure how to do this one
public PointCP4 rotatePoint(double rotation){
double newTheta = getTheta()+rotation;
return new PointCP4('P',getRho(),newTheta);}

/**
* Returns information about the coordinates.
*
* @return A String containing information about the coordinates.
*/
public String toString(){

							return "Stored as " + (typeCoord == 'C'
							? "Cartesian  (" + getX() + "," + getY() + ")"
							: "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
}



}
