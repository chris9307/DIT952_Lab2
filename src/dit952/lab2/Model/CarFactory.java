package dit952.lab2.Model;

/**
 * Created by chrba on 2017-02-23.
 */
public class CarFactory{
    public static Car createSaab95(int x, int y){
        return new Saab95(x,y);
    }
    public static Car createVolvo240(int x, int y){
        return new Volvo240(x,y);
    }
    public static Car createScania(int x, int y){
        return new Scania(x,y);
    }
    public static Car createCarTransporter(int x, int y){
        return new CarTransporter(x,y);
    }
}
