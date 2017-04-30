package system.def;

import java.util.ArrayList;
import java.util.List;


public class AgentFactory {

    int _numberOfWolves;
    int _numberOfDeer;
    int _numberOfGrasses;
    List<Agent> setOfAgents;

    public void AgentFactory(int numberOfWolves, int numberOfDeer, int numberOfGrasses){
        numberOfDeer = _numberOfDeer;
        numberOfGrasses = _numberOfGrasses;
        numberOfWolves = _numberOfWolves;
        setOfAgents = new ArrayList<>();
    }

    public List<Agent> CreateAgents()
    {
        AddDearToAgentList();
        AddGrassToAgentList();
        AddWolvesToAgentList();

        return setOfAgents;
    }

    private void AddDearToAgentList()
    {
        for(int i = 0; i < _numberOfDeer; i++)
        {
            setOfAgents.add(new Deer(new DeerConfiguration()));
        }
    }

    private void AddGrassToAgentList()
    {
        for(int i = 0; i < _numberOfGrasses; i++)
        {
            setOfAgents.add(new Grass(new GrassConfiguration()));
        }
    }

    private void AddWolvesToAgentList()
    {
        for(int i = 0; i < _numberOfWolves; i++)
        {
            setOfAgents.add(new Wolf(new WolfConfiguration()));
        }
    }

}
