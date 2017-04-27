package system.def;

import java.util.LinkedList;

/**
 * Created by anthonylawal on 18/04/2017.
 */

class Square implements ILocation {

    private int _x;
    private int _y;
   /* private LinkedList<? extends Agent> _listOfAgents; */


    protected Square (int x, int y)
    {
        _x = x;
        _y = y;
    }

    @Override
    public int GetX()
    {
        return _x;
    }


    @Override
    public int GetY()
    {
        return _y;
    }


   /* public void ChangeLocation(int x, int y) {

        _x = x;
        _y = y;
*/






}
