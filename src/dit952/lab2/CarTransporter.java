package dit952.lab2;
import java.awt.Color;
public class CarTransporter extends Car{
private Platform platform=new Platform();
private CarLoad  load=new CarLoad();

public CarTransporter(int x, int y){        
        super(x,y);
        size=100;
        nrDoors = 2;
        color = Color.black;
        enginePower = 125;
        modelName="Transporter";
    }

    /**Loads a car to the car transporter*/
        public void load(Car c){

            if(platform.getAngle()==0){                
                load.load(c,x,y);        
            }
            else{
                System.out.println("The platform must be down before loading");
            }

        }

    /**Unloads a car from the car transporter FILO*/
    public void unload(){
        if(platform.getAngle()==0){
            load.unloadLast();   
        }
            
        
    }
    
    /**Decreases the angle to 0 if the car is not moving(currentSpeed=0)*/
    public void decreaseAngle(){
        if(currentSpeed==0)
        {            
            platform.setMinAngle();  
        }
        else
        { 
            System.out.println("Can not lower the ramp when the car transporter is moving");
        }     
    }
    /**Moves the car transporter and updates the coordinates of the cars inside*/
    public void move(){
        super.move();
        load.updateCoordinates(x,y);
    }
     /**Increases the angle as long as the current angle os within the range [0,69] and current speed is equal to 0*/
    public void increaseAngle(){                    
        platform.setMaxAngle();                    
    }

    @Override
    public double speedFactor() {
        return enginePower;
    }
    
     /**Sets current speed to 0.1*/
    @Override
    public void startEngine(){
      if(platform.getAngle()==0){
          currentSpeed = 0.1;
      }
      else{
          
      }
      
    }
    /**Gas can only increase the currentSpeed given an amount within [0,1]*/
    @Override
    public void gas(double amount){
        if(amount<0 || amount>1)
        {      
            throw new IllegalArgumentException("Outside of [0,1]");
        }
        else if(platform.getAngle()!=0){
            System.out.println("Can not gas when the platform is down");
        }
        else{
            incrementSpeed(amount); 
        }
        
    }

}
