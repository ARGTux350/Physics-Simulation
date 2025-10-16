import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
       
        SomeEquations m = new SomeEquations();
 
        double t = 0, v = 0, V = 0, a = -9.8, A = 0, d = 0, vx = 0;
        Scanner n = new Scanner(System.in);
 
        System.out.println("Choose what you want to solve for:");
        System.out.println("1. Time");
        System.out.println("2. Starting velocity");
        System.out.println("3. Distance");
        System.out.println("4. Ending velocity");
        System.out.println("5. Angle");
        System.out.println("6. I have all the info\n");
 
        int choice = n.nextInt();
 
        if (choice != 1) {
            System.out.print("Enter time in seconds: ");
            t = n.nextDouble();
        }
 
        if (choice != 2) {
            System.out.print("Enter starting velocity (m/s): ");
            v = n.nextDouble();
        }
 
        if (choice != 3) {
            System.out.print("Enter total distance (m): ");
            d = n.nextDouble();
        }
 
        if (choice != 4) {
            System.out.print("Enter ending velocity (m/s): ");
            V = n.nextDouble();
        }
 
        if (choice != 5) {
            System.out.print("Enter angle (degrees): ");
            A = n.nextDouble();
        }
       
        if (choice != 6) {
            System.out.print("Enter horizontal velocity (m/s): ");
            vx = n.nextDouble();
        }
 
        switch (choice) {
            case 1: t = m.getTime(V, v, a); break;
            case 2: v = m.getVelocityO(V, a, t); break;
            case 3: d = m.getDistance(v, t); break;
            case 4: V = m.getVelocity(v, a, t); break;
            case 5: A = m.getAngle(v, vx); break;
            case 6:
                System.out.println("You have all the required information.");
                break;
            default:
                System.out.println("Invalid option.");
                n.close();
                return;
        }
 
        System.out.printf("\nResults:\n");
        System.out.printf("Time: %.2f s\n", t);
        System.out.printf("Starting Velocity: %.2f m/s\n", v);
        System.out.printf("Distance: %.2f m\n", d);
        System.out.printf("Ending Velocity: %.2f m/s\n", V);
        System.out.printf("Angle: %.2f degrees\n", A);
        System.out.println("Using gravity acceleration: -9.8 m/s^2\n");
 
 
        double vx0 = v * Math.cos(m.getAngleInRadians(A));
        double vy0 = v * Math.sin(m.getAngleInRadians(A));
 
        double totalFlightTime = (vy0 + Math.sqrt(vy0 * vy0 + 2 * 9.8 * 0)) / 9.8;
       
        totalFlightTime = (2 * vy0) / 9.8;
 
        if (t <= 0) {
            t = totalFlightTime;
        }
 
        int numberPoints = 0;
        do {
            System.out.print("Input number of points to be displayed on the graph: ");
            numberPoints = n.nextInt();
        } while (numberPoints < 3);
        System.out.println();
       
        numberPoints--;
       
        double[] T = new double[numberPoints + 1];
 
        for (int i = 0; i <= numberPoints; i++) {
            T[i] = t * (i / (double) numberPoints);
        }
 
        double[] x = new double[T.length];
        double[] y = new double[T.length];
 
        for (int i = 0; i < T.length; i++) {
            double ti = T[i];
            x[i] = vx0 * ti;
            y[i] = m.getYPosition(vy0, -9.8, ti);
 
            if (y[i] < 0) {
                y[i] = 0;
            }
        }
 
        ProjectilePlotter.plot(x, y, "Projectile Trajectory");
 
        n.close();
    }
}