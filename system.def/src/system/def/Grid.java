package system.def;

import java.util.LinkedList;

/**
 * Created by anthonylawal on 18/04/2017.
 */
public class Grid{


    private LinkedList<Agent>[][] _grid;
    private int _lenght;
    private int _breath;


    protected Grid(int x, int y)
    {
        _lenght = x;
        _breath = y;
        _grid = new LinkedList[_lenght][_breath];
    }


    public void Update()
    {
        //<capture<?extends Agent>>
    }


    public void Add(Agent agent )
    {
try {
    int y = agent.CurrentLocation().GetY();
    int x = agent.CurrentLocation().GetX();
    agent.Grid = this;

    if (_grid[x][y] == null) {
        _grid[x][y] = new LinkedList<Agent>();
    }

    _grid[x][y].add(agent);
}
         catch(Exception e)
         {

    }
    }


    public LinkedList<Agent> GetAgentsInSquare(ILocation location)
    {
        return _grid[location.GetX()][location.GetY()];
    }


    public void RemoveAgentInSquare(Agent agent, ILocation location) {
        LinkedList<Agent> agentsInSquare = _grid[location.GetX()][location.GetY()];

        if (agentsInSquare.contains(agent)) {
            agentsInSquare.remove(agent);
        }
    }


    public int GetLenght()
    {
        return _lenght;
    }


    public int GetBreath()
    {
        return _breath;
    }




}
