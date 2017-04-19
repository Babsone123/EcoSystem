package system.def;

/**
 * Created by anthonylawal on 18/04/2017.
 */
class Square {

    private int _x;
    private int _y;

    protected Square (int x, int y)
    {
        _x = x;
        _y = y;
    }

    public int GetX()
    {
        return _x;
    }

    public int GetY()
    {
        return _y;
    }

    public void Change(int x, int y)
    {
        _x = x;
        _y = y;
    }

}
