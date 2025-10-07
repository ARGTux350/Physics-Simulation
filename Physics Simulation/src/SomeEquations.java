import java.lang.Math;

public class SomeEquations {
	
	public SomeEquations() {
		// lower case v is starting velocity
		// upper case V is ending velocity
		
		// lower case a is angle
		// upper case A is acceleration
	}
	
	//the simple ones :)
	
	public double getTime(double V, double v, double A) {
		return (V - v) / A;
	}
	
	public double getVelocityO(double V, double A, double t) {
		return V - (A * t);
	}
	
	public double getDistance(double vxorVx, double t) {
		return vxorVx / t;
	}
	
	public double getVelocity(double v, double A, double t) {
		return v + (A * t);
	}
	
	public double getAcceleration(double V, double v, double t) {
		return (V - v) / t;
	}
	
	//the not so simple ones :l
	
	public double getVelocityX(double vorV, double a){
		return vorV * Math.cos(Math.toRadians(a));
	}
	
	public double getVelocityY(double vorV, double a){
		return vorV * Math.sin(Math.toRadians(a));
	}
	
	//formerly known as getYwithT
	public double getHeight(double Vy, double vy) {		
		return ((Vy * Vy) - (vy * vy)) / (-19.6);						
	}
	
	public double getAngleInRadians(double a) {
		return Math.toRadians(a);
	}
	
	//this method is completely pointless. In the final code, this will show up ZERO times. It has NO PURPOSE.
	public double pieTimes(double num) {
		return Math.toRadians(num) * 180;
	}
}
