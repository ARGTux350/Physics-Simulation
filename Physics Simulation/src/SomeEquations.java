public class SomeEquations {

    public SomeEquations() {
        // Constructor
    }

    // Kinematic equations

    public double getTime(double V, double v, double A) {
        return (V - v) / A;
    }

    public double getVelocityO(double V, double A, double t) {
        return V - (A * t);
    }

    public double getDistance(double velocity, double t) {
        return velocity * t;
    }

    public double getVelocity(double v, double A, double t) {
        return v + (A * t);
    }

    public double getAcceleration(double v, double V, double t) {
        return (V - v) / t;
    }
    
    public double getAngle(double v, double vx) {
        return Math.toDegrees(Math.acos(vx / v));
    }

    // Trig and projectile motion helpers

    public double getVelocityX(double velocity, double angleDegrees) {
        return velocity * Math.cos(Math.toRadians(angleDegrees));
    }

    public double getVelocityY(double velocity, double angleDegrees) {
        return velocity * Math.sin(Math.toRadians(angleDegrees));
    }

    public double getAngleInRadians(double degrees) {
        return Math.toRadians(degrees);
    }

    // Correct vertical position formula: y(t) = vy0 * t + 0.5 * a * t^2
    public double getYPosition(double vy0, double a, double t) {
        return vy0 * t + 0.5 * a * t * t;
    }
}
