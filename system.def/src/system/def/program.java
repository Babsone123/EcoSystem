package system.def;

import system.def.AgentHelperClass.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthonylawal on 18/04/2017.
 */
public class program {
    public static void main(String[] args) {

        IGrid grid  = new Grid(10, 10);
        IScheduler scheduler = new ProbabilisticScheduler();
        AgentFactory agentFactory = new AgentFactory(grid, scheduler);
        agentFactory.AddNewDearToList(1);
       /* agentFactory.AddNewGrassToList(20);
        agentFactory.AddNewWolfToList(20);*/

        EcoController controller = new EcoController(grid, scheduler, agentFactory.GetAgents());
        controller.InitiateSession();
    }
}
