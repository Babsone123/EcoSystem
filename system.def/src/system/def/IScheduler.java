package system.def;

import java.util.List;

/**
 * Created by anthonylawal on 26/04/2017.
 */
public interface IScheduler extends IAgentObserver {

     Agent PickAgent();
     List<Agent> GetAgents();
}
