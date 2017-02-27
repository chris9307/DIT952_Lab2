package dit952.lab2.Model;
//package dit952.lab1;
import java.awt.*;

public class Volvo240 extends Car{
 public final static double trimFactor = 1.25;
    public Volvo240(int x, int y){
        super(x,y);
        size=1;
        nrDoors = 4;
        color = Color.black;
        enginePower = 125;
        modelName = "Volvo240";
        stopEngine();
    }

/** returns the resulting speedfactor
 */  
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

 
}
