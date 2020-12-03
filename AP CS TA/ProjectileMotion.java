import java.awt.*;
import java.util.*;

public class ProjectileMotion{
    public static double V=30.0;
    public static double a=-9.81;

    public static void main(String[] args){
        
        //input
        Scanner console = new Scanner(System.in);
        System.out.print("Please enter the start angle in degrees: ");
        double start=console.nextDouble();
        System.out.print("Please enter the final angle in degrees: ");
        double end=console.nextDouble();
        System.out.print("Please enter the step size in degrees:   ");
        double step=console.nextInt();
        
        //conversions
        Math.toRadians(start);
        Math.toRadians(end);
        Math.toRadians(step);

        //drawing
        DrawingPanel panel=new DrawingPanel(1000,600);
        Graphics g=panel.getGraphics();
        trajectory(start, end, step, g);
    
        console.close();
    }
    public static void trajectory(double first, double last, double steps, Graphics g){
        for (double i=first; i<=last;i+=steps){
            int substeps=500;
            //trig
            double Vx=V*Math.cos(i);
            double Vy=V*Math.sin(i);
            double duration=-2.0*Vy/a;
            double timestep=duration/substeps;
            double xspace=Vx*timestep;
            
            //constants
            double x=0.0;
            double y=0.0;
            double t=0.0;
            
            for(int j=1; j<=substeps;j++){
                t+=timestep;
                x+=xspace;
                y=Vy*t+0.5*a*t*t;
                g.fillOval((int)(10.5*x), (int)(600-(y*12)), 2, 2);
            }
            
        }
    }
}
