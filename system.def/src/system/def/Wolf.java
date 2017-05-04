package system.def;

import java.util.LinkedList;


public class Wolf extends Agent implements MobileAgent, IPredator   {

    private AgentConfiguration _configuration;
    private IAgentObserver _observer;


    public Wolf(AgentConfiguration configuration, IAgentObserver observer) {

        super(configuration, observer);
        _configuration = configuration;
        _observer = observer;
    }


    @Override
    public void ExecuteSteps() {

        Move();
        Eat();
        Reproduce();
        DecreaseEnergyLevel();

    }



    public void Eat() {

        LinkedList<Agent> agentsInCurrentSquare = GetAgentsInSameSquare();

        if (agentsInCurrentSquare != null)
        {
            for(int i = 0; i < agentsInCurrentSquare.size(); i++)
            {
                Agent currentAgent = agentsInCurrentSquare.get(i);

                if(IsEatable(currentAgent))
                {
                    agentsInCurrentSquare.get(i).Die();
                    IncreaseEnergyLevel();
                    break;
                }

            }
        }
    }

    public void Reproduce() {

        if (CanReproduce())
        {
            _configuration.SetLocation(CurrentLocation());
            Grid.Add(new Wolf(_configuration, _observer));
        }
    }



    @Override
    public boolean IsEatable(Agent prey) {

        boolean eatable = false;

        if (this.Level.NumericValue() > prey.Level.NumericValue() & prey.GetType() != TypeOfOrganism.Plant) {

            eatable = true;
        }

        return eatable;

    }


}
