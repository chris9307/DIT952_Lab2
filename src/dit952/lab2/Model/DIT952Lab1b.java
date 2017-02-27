package dit952.lab2.Model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package dit952.lab1b;

/**
 *
 * @author Asus
 */
public class DIT952Lab1b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CarTransporter ct=new CarTransporter(1,1);
       CarTransporter ct2=new CarTransporter(2,2);
       Ferry f=new Ferry(4,4);
       Car c=new Saab95(3,3);
       Car c2=new Saab95(4,4);       
       Car c3=new Volvo240(22,2);
       Car c4=new Volvo240(2,1);              
       Car c5=new Volvo240(55,55);
       ct.startEngine();       
       System.out.println("Car c:"+c.getXPos()+" "+c.getYPos());
       System.out.println("Car c2:"+c2.getXPos()+" "+c2.getYPos());
       System.out.println("Car c3:"+c3.getXPos()+" "+c3.getYPos());
       System.out.println("Car ct:"+ct.getXPos()+" "+ct.getYPos());
       ct.load(c);
       System.out.println("Loaded car c");
       ct.load(c2);
       System.out.println("Loaded car c2");
       ct.load(c3);
       System.out.println("Loaded car c3");       
       System.out.println("Car c:"+c.getXPos()+" "+c.getYPos());
       System.out.println("Car c2:"+c2.getXPos()+" "+c2.getYPos());
       System.out.println("Car c3:"+c3.getXPos()+" "+c3.getYPos());
       System.out.println("Car ct:"+ct.getXPos()+" "+ct.getYPos());

       ct.gas(1);
       ct.move();
       System.out.println("Moved car transporter");       
       System.out.println("Car c:"+c.getXPos()+" "+c.getYPos());
       System.out.println("Car c2:"+c2.getXPos()+" "+c2.getYPos());
       System.out.println("Car c3:"+c3.getXPos()+" "+c3.getYPos());      
       System.out.println("Car ct:"+ct.getXPos()+" "+ct.getYPos());
       ct.turnLeft();
       ct.turnRight();
       ct.turnRight();
       ct.move();
        System.out.println("Car ct moved right");
         System.out.println("Car c:"+c.getXPos()+" "+c.getYPos());
       System.out.println("Car c2:"+c2.getXPos()+" "+c2.getYPos());
       System.out.println("Car c3:"+c3.getXPos()+" "+c3.getYPos());      
       System.out.println("Car ct:"+ct.getXPos()+" "+ct.getYPos());
       ct.unload();
       ct.decreaseAngle();
       ct.load(ct2);

    }
    
}
