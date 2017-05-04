package system.def.AgentHelperClass;

import system.def.*;

import java.util.ArrayList;
import java.util.List;


public class AgentFactory {

    IAgentObserver _observer;
    IGrid _grid;
    List<Agent> setOfAgents;


    public  AgentFactory(IGrid grid, IAgentObserver observer){

        _grid = grid;
        _observer = observer;
        setOfAgents = new ArrayList<>();
    }

    public List<Agent> GetAgents()
    {
        return setOfAgents;
    }

    public void AddNewDearToList(int numberOfDeer)
    {
        for(int i = 0; i < numberOfDeer; i++)
        {
            setOfAgents.add(new Deer(new DeerConfiguration(_grid), _observer));
        }
    }

    public void AddNewWolfToList(int numberOfWolf)
    {
        for(int i = 0; i < numberOfWolf; i++)
        {
            setOfAgents.add(new Wolf(new WolfConfiguration(_grid), _observer));
        }
    }

    public void AddNewGrassToList(int numberOfGrass)
    {
        for(int i = 0; i < numberOfGrass; i++)
        {
            setOfAgents.add(new Grass(new GrassConfiguration(_grid), _observer));
        }
    }



}
