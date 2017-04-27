package system.def;
import java.util.Collections;
import java.util.List;

/**
 * Created by anthonylawal on 23/04/2017.
 */

public class ProbabilisticScheduler implements IScheduler  {

    private List<Agent> _agents;

    protected ProbabilisticScheduler(List<Agent> agents)
    {
        _agents = agents;
    }

    @Override
    public Agent PickAgent() {

        Collections.shuffle(_agents);
        return _agents.get(0);
    }
}
