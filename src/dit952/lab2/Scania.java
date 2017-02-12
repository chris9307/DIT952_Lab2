package dit952.lab2;

import java.awt.Color;


public class Scania extends Car{
    private Platform platform=new Platform();
    public Scania(int x, int y){
        super(x,y);
        size=10;
        nrDoors = 2;
        color = Color.black;
        enginePower = 125;
        modelName="Scania";
    }
    @Override
    public double speedFactor() {
        return enginePower*0.01;
    }

    /**Decreases the angle as long as the current angle is within the range [1,70] and current speed is equal to 0*/
    public void decreaseAngle(){
        if(platform.getAngle()>=1&&platform.getAngle()<=70&&currentSpeed==0)
        {
          platform.decreaseAngle();    
        }
        else
        {
          System.out.println("Outside of valid range");
        }     
    }
    
     /**Decreases the angle as long as the current angle os within the range [0,69] and current speed is equal to 0*/
        public void increaseAngle(){
            if(platform.getAngle()>=0&&platform.getAngle()<=69&&currentSpeed==0)
            {
                platform.increaseAngle();   
            }
            else
            {
                System.out.println("Outside of valid range");
            }     
    }
        
     /**Sets current speed to 0.1*/
    @Override
    public void startEngine(){
      if(platform.getAngle()==0){
          currentSpeed = 0.1;
      }
      else{
          System.out.println("Can't start engine while platform is elevated");
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
    
    public Platform getPlatform(){
        return platform;
    }
    
}
