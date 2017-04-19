package system.def;

import java.util.LinkedList;

/**
 * Created by anthonylawal on 18/04/2017.
 */
public class Grid {

    private LinkedList<? extends Agent>[][] _grid;

    protected Grid(int x, int y)
    {
        _grid = new LinkedList[x][y];

    }

    public void Update()
    {

    }

    public LinkedList<? extends Agent> GetSquare(Square location)
    {
        return _grid[location.GetX()][location.GetY()];
    }

}
