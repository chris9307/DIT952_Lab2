package dit952.lab2;
//package dit952.lab1;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Volvo240 extends Car{
 public final static double trimFactor = 1.25;
    public Volvo240(int x, int y){
        super(x,y);
        size=1;
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

/** returns the resulting speedfactor
 */  
    public double speedFactor(){
        double turbo=1;
        return enginePower * 0.01 * trimFactor*turbo;
    }

 
}
