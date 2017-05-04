package system.def;

import system.def.AgentHelperClass.AgentFactory;
//import system.def.AgentHelperClass.AgentManager;

import java.util.*;



public class EcoController {

    private List<Agent> _agentsInEcoSystem;
    private IGrid _grid;
    private IScheduler _scheduler;


    public EcoController(IGrid grid, IScheduler scheduler, List<Agent> agents)
    {
        _agentsInEcoSystem = agents;
        _grid = grid;
        _scheduler = scheduler;
        ObserveAgents();
        SetAgentsOnGrid();
    }

    private void SetAgentsOnGrid() {
        for (Agent agent : _agentsInEcoSystem) {
            _grid.Add(agent);
        }
    }

    private void ObserveAgents() {
        for (Agent agent : _agentsInEcoSystem) {
            agent.addObserver(_scheduler);

        }
    }

    public void InitiateSession() {

        Agent activeAgent;

        while (Continue())
        {
            try {
                activeAgent = _scheduler.PickAgent();
                activeAgent.ExecuteSteps();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }

    private boolean Continue()
    {
        return _agentsInEcoSystem.size() > 0;
    }


}





