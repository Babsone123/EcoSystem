package system.def;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by anthonylawal on 23/04/2017.
 */

public  class ProbabilisticScheduler implements IScheduler  {

    private List<Agent> _agents;

    protected ProbabilisticScheduler()
    {
        _agents = new ArrayList<>();
    }

    @Override
    public Agent PickAgent() {

        Collections.shuffle(_agents);
        return _agents.get(0);
    }

    @Override
    public List<Agent> GetAgents() {
        return _agents;
    }

    @Override
    public void updateStatus(ObservableAgent agent, Status status) {

        if(status == Status.Dead)
        {
            _agents.remove(agent);
        }
    }

    @Override
    public void NotifyAboutNewAgent(ObservableAgent agent) {
        Agent newAgent = (Agent)agent;
        _agents.add(newAgent);
    }

    @Override
    public void updateLocation(ObservableAgent agent, ILocation iLocation) {

    }


}
