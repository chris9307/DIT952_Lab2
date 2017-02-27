package dit952.lab2.Model;

import java.awt.*;

/**
 * Created by chrba on 2017-02-23.
 */
public class StateRight implements IStateDirection {

    @Override
    public Point move(int x, int y, double currentSpeed){
        return new Point(x+(int)currentSpeed,y);
    }

}
