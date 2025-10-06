import java.lang.Math;

public class Equations {
	private double a,la,vo,v,voy,vox,vy,vx,sh,t,d,dy,dx,angleX;
		
		public Equations() {
			
			a = -9.8;
		}
		//finds time
		public double getTime(double vy, double voy) {
			t = (voy-vy)/a;			
			return t;
		}
		//finds Y coordinate using time
		public double getYwithT(double voy,double t) {
			vy = voy + (a*t);		
			dy = ((vy*vy)-(voy*voy))/(2*a);						
			return dy;
		}
		//finds x using time
		public double getX(double vox,double t) {
			dx = voy*t;					
			return dx;
		}
		//finds voy and vox
		public void findVoyVox(double angleY,double velo) {
			angleX = 180 - angleY - 90;			
			vox = (Math.sin(Math.toRadians(angleX))) * velo;
			voy = (Math.sin(Math.toRadians(angleY))) * velo;			
		}
		
}
