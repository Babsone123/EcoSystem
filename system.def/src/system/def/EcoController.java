package system.def;

import java.util.*;

/**
 * Created by anthonylawal on 19/04/2017.
 */

public class EcoController   {

    private List<Agent> _agentsInEcoSystem;
    private Grid _grid;
    private IScheduler _scheduler;
    private AgentManager _agentManager;

    public EcoController(List<Agent> setOfAgents, int lenght, int breath)
    {
        _agentsInEcoSystem = setOfAgents;
        _grid = new Grid(lenght, breath);
        _scheduler = new ProbabilisticScheduler(_agentsInEcoSystem);
        _agentManager = new AgentManager(_grid);
        ObserveAgents();
        SetAgentsOnGrid();

    }

    private void SetAgentsOnGrid()
    {
        for (Agent agent : _agentsInEcoSystem) {
            _grid.Add(agent);
        }
    }

    private void ObserveAgents() {
        for (Agent agent : _agentsInEcoSystem) {
            agent.addObserver(_agentManager);

        }
    }

    public void Start()
    {
        Agent agent  = _scheduler.PickAgent();
        Agent agent1 = _scheduler.PickAgent();

    }



    }





