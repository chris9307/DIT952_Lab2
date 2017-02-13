package dit952.lab2;
//package dit952.lab1;
import java.awt.*;

public class Saab95 extends Car{
    private boolean turboOn;
     
    public Saab95(int x,int y){
        super(x,y);
        size=1;
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }
    
   
/**Sets the turbo on, making the car move faster when the gas method is being called*/
    public void setTurboOn(){
	    turboOn = true;
    }

/**Sets the turbo off, making the car move slower when the gas method is being called*/
    public void setTurboOff(){
	    turboOn = false;
    }
/** returns the resulting speedfactor
 */    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    


 

}
