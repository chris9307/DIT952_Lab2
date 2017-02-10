/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit952.lab2;


import java.awt.*;
import java.awt.image.BufferedImage;

abstract public class Vehicle {
     protected int x = 0, y = 0;
     protected double enginePower; // Engine power of the car
     
     protected double currentSpeed; // The current speed of the car
     public enum Direction{UP,RIGHT,DOWN,LEFT};
     public Direction dir=Direction.RIGHT;
    public Vehicle(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
     /**Moves the car towards the right direction*/  
    public void move() {
      if(dir==Direction.LEFT){
        x-=currentSpeed;
      }

      else if(dir==Direction.UP){
        y+=currentSpeed;  
      }
       
      else if(dir==Direction.RIGHT){
        x+=currentSpeed; 
      }
          
      else if(dir==Direction.DOWN){
        y-=currentSpeed;
      }
    }

    /**Changes the direction 90 degrees to the left*/
    public void turnLeft() {
      
      if(dir==Direction.LEFT){
        dir=Direction.DOWN;
      }

      else if(dir==Direction.UP){
        dir=Direction.LEFT;  
      }
       
      else if(dir==Direction.RIGHT){
        dir=Direction.UP; 
      }
          
      else if(dir==Direction.DOWN){
        dir=Direction.RIGHT;
      }
    }

    /**Changes the direction 90 degrees to the right*/
    public void turnRight(){
      if(dir==Direction.LEFT){
        dir=Direction.UP;
      }

      else if(dir==Direction.UP){
        dir=Direction.RIGHT;  
      }
       
      else if(dir==Direction.RIGHT){
        dir=Direction.DOWN; 
      }
          
      else if(dir==Direction.DOWN){
        dir=Direction.LEFT;
      }
    }
     
     /**Returns the engine power of the car */
    public double getEnginePower(){
      return enginePower;
    }

    /**Returns the current speed of the car.*/
    public double getCurrentSpeed(){
      return currentSpeed;
    }
    
     /**Sets current speed to 0.1*/
    public void startEngine(){
      currentSpeed = 0.1;
    }

    /**Sets current speed to 0*/
    public void stopEngine(){
      currentSpeed = 0;
    }   

    /**Gas can only increase the currentSpeed given an amount within [0,1]*/
    public void gas(double amount){
        if(amount<0 || amount>1)
        {
            
            throw new IllegalArgumentException("Outside of [0,1]");
        }
        incrementSpeed(amount);
    }
    
    /**brake can only decrease the currentSpeed given an amount within [0,1]*/
    public void brake(double amount){
        if(amount<0 || amount>1)
        {
            throw new IllegalArgumentException("Outside of [0,1]");
        }
        decrementSpeed(amount);
    }
    
    
    /**Should be implemented in all subclasses to Car to reflect the speed factor of that particular model.*/
    abstract public double speedFactor();

     /**Makes the car go faster by increasing the current speed 
     */
    public void incrementSpeed(double amount){
	 currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    /**Makes the car go slower by decreasing the current speed 
    */

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    
    public int getXPos(){
        return x;
    }
    public int getYPos(){
        return y;
    }
    
    public void setXPos(int x){
        this.x=x;
    }
    
    public void setYPos(int y){
        this.y=y;
    }

    public Point getPos() {
        return new Point(x,y);
    }
    
}
