package system.def;

import java.util.LinkedList;



public class Deer extends Agent implements MobileAgent,  IPredator {

    private AgentConfiguration _configuration;
    private IAgentObserver _observer;

    public Deer(AgentConfiguration configuration, IAgentObserver observer) {

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


    public void Reproduce() {

        if (CanReproduce())
        {
            _configuration.SetLocation(CurrentLocation());
            Grid.Add(new Deer(_configuration, _observer));
        }

    }


    public boolean IsEatable(Agent prey)
    {
        boolean eatable = false;

        if (this.Level.NumericValue() > prey.Level.NumericValue() & prey.GetType() == TypeOfOrganism.Plant) {

            eatable = true;
        }

        return eatable;

    }


    public void Eat() {

        LinkedList<Agent> agentsInCurrentSquare = GetAgentsInSameSquare();

        if (agentsInCurrentSquare != null) {

            for (int i = 0; i < agentsInCurrentSquare.size(); i++) {
                Agent currentAgent = agentsInCurrentSquare.get(i);

                if (IsEatable(currentAgent)) {
                    agentsInCurrentSquare.get(i).DecreaseEnergyLevel();
                    IncreaseEnergyLevel();
                    break;
                }
            }
        }
    }

}
