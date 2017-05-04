package system.def;

import java.util.LinkedList;

/**
 * Created by anthonylawal on 18/04/2017.
 */
public class Grid implements IGrid{


    private LinkedList<Agent>[][] _grid;
    private int _lenght;
    private int _width;


    protected Grid(int x, int y)
    {
        _lenght = x;
        _width = y;
        _grid = new LinkedList[_lenght][_width];
    }


    public void Update()
    {

    }


    public void Add(Agent agent ) {
        try {
            int y = agent.CurrentLocation().GetY();
            int x = agent.CurrentLocation().GetX();
            agent.Grid = this;

            if (_grid[x][y] == null) {
                _grid[x][y] = new LinkedList<Agent>();

            }

            if (!_grid[x][y].contains(agent))
                _grid[x][y].add(agent);
            agent.setChanged();
            agent.notifyObserverAboutNewAgent();
        }
        catch (Exception e) {

        }
    }


    @Override
    public LinkedList<Agent> GetAgentsInSquare(ILocation location)
    {
        return _grid[location.GetX()][location.GetY()];
    }


    @Override
    public void RemoveAgentInSquare(Agent agent, ILocation location) {
        LinkedList<Agent> agentsInSquare = _grid[location.GetX()][location.GetY()];

        if (agentsInSquare.contains(agent)) {
            boolean isRemoved = agentsInSquare.remove(agent);
        }
    }


    @Override
    public int GetLenght()
    {
        return _lenght;
    }


    @Override
    public int GetWidth()
    {
        return _width;
    }




}
