package system.def;


import java.awt.image.ImageObserver;
import java.util.LinkedList;

/**
 * Created by anthonylawal on 21/04/2017.
 */
public class Grass extends Agent  {


    private AgentConfiguration _configuration;
    private IAgentObserver _observer;

    public Grass(AgentConfiguration configuration, IAgentObserver observer) {

        super(configuration, observer);
        _configuration = configuration;
        _observer = observer;
    }


    @Override
    public void ExecuteSteps() {
        IncreaseEnergyLevel();
        Move();
        Reproduce();
    }


    @Override
    public boolean CanReproduce()
    {

        LinkedList<Agent> agentsInCurrentSquare = GetAgentsInSameSquare();
        boolean isGrassInCurrentSquare = true;

        if (agentsInCurrentSquare != null) {
            for (int i = 0; i < agentsInCurrentSquare.size(); i++) {
                if (agentsInCurrentSquare.get(i).GetType() == TypeOfOrganism.Plant) {
                    isGrassInCurrentSquare = false;
                    break;
                }

            }
        }

        return isGrassInCurrentSquare;
    }


    @Override
    public void Reproduce() {

        if (CanReproduce())
        {
            Grid.Add(new Grass(_configuration, _observer));
        }
    }


    @Override
    public void Move()
    {
        AgentMovement.Spread(this, Grid);
    }

}
