package system.def;

/**
 * Created by anthonylawal on 24/04/2017.
 */
public class AgentManager implements IAgentObserver{

    private Grid _grid;
   // private Agent _agent;

    public AgentManager(Grid grid) {
        _grid = grid;
    }


    @Override
    public void updateStatus(ObservableAgent agent, Status status) {

        Agent castAgent = (Agent)agent;

        if (status == Status.Dead) {
            _grid.RemoveAgentInSquare(castAgent, agent.GetLocation());
        }
    }

    @Override
    public void LocationChanged(ObservableAgent agent) {

        ReduceEnergyLevel(agent);
    }

    @Override
    public void ReduceEnergyLevel(ObservableAgent agent) {
        Agent localAgent = (Agent)agent;
        localAgent.DecreaseEnergyLevel();
    }

}
