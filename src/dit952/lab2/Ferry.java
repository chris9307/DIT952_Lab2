/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit952.lab2;

public class Ferry extends Vehicle {
private CarLoad load=new CarLoad();
public Ferry(int x, int y){
    super(x,y);
}
    /**Loads a car to the Ferry*/
    public void load(Car c,int x,int y){
        load.load(c,x,y);
    }
    /**Unloads a car from the Ferry FIFO*/
    public void unload(){        
        load.unloadFirst();        
    }
    
    
    /**Moves the car transporter and updates the coordinates of the cars inside*/
    public void move(){
        super.move();
        load.updateCoordinates(this.x,this.y);
    }
    @Override
    public double speedFactor() {
        return enginePower*0.6;
    }
    
}
