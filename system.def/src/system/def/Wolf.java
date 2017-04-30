package system.def;

import java.util.LinkedList;



public class Wolf extends Agent   {

    private IDefaultConfiguration configuration = new WolfConfiguration();

    protected Wolf( TrophicLevel level, String name, int energyLevel, TypeOfOrganism type, ILocation location, int IncreaseEnergyValue, int DescreaseEnergyValue, double probability) {
        super(level, name, energyLevel, type, location, IncreaseEnergyValue, DescreaseEnergyValue, probability);
    }

    protected Wolf(IDefaultConfiguration configuration) {
        super(configuration);
    }


    @Override
    public void ExecuteSteps() {

        Move();
        Eat();

    }


    public void Eat() {

        LinkedList<Agent> agentsInCurrentSquare = GetAgentsInSameSquare();

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

    @Override
    public void Reproduce() {

        if (CanReproduce())
        {
            Grid.Add(new Wolf(configuration));
        }
    }

    @Override
    protected boolean IsEatable(Agent prey) {
        boolean eatable = false;

        if (this.Level.NumericValue() > prey.Level.NumericValue() & prey.GetType() != TypeOfOrganism.Plant) {

            eatable = true;
        }

        return eatable;

    }


    public void Move() {
        AgentMovement.RandomSingleStep(this);

    }


//Delete
    public void Move(ILocation square) {
        this.Grid.RemoveAgentInSquare(this, this.CurrentLocation());
        this.SetLocation(square);

    }
}
