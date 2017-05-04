package system.def;



import java.util.LinkedList;
import java.util.Random;



public abstract class Agent extends ObservableAgent {


    public String Name;
    public IGrid Grid;
    public int EnergyLevel;
    private TypeOfOrganism _type;
    protected ILocation Location;
    protected int _increaseEnergyValue;
    protected int _decreaseEnergyValue;
    private Status _status;
    protected TrophicLevel Level;
    private Double REPRODUCE_PROBABILITY;
    private AgentConfiguration _configuration;
    private IAgentObserver _observer;



    protected Agent(AgentConfiguration configuration, IAgentObserver observer) {

        _type = configuration.SetType();
        _configuration = configuration;
        _increaseEnergyValue = configuration.SetIncreaseEnergyValue();
        _decreaseEnergyValue = configuration.SetDecreaseEnergyValue();
        _status = system.def.Status.Active;
        _observer = observer;

        EnergyLevel = configuration.SetInitialEnergyLevel();
        Grid = configuration.GetGrid();
        SetLocation(configuration.GetLocation());
        Level = configuration.Setlevel();
        REPRODUCE_PROBABILITY = configuration.R_Probability();
        addObserver(observer);

    }


    public TypeOfOrganism GetType()
    {
        return _type;
    }


    public ILocation CurrentLocation()
    {
        return Location;
    }


    public int GetEnergyLevel() { return EnergyLevel; }


    public void IncreaseEnergyLevel()
    {
        EnergyLevel += _increaseEnergyValue;
    }


    public void DecreaseEnergyLevel()
    {

        EnergyLevel -= _decreaseEnergyValue;

        if (EnergyLevel < 0)
        {
            Die();
        }
    }


    @Override
    public Status GetStatus() { return _status; }


    public void SetStatus(Status status) {
        _status = status;
        setChanged();
        notifyStatusChange(status);
    }

    public LinkedList<Agent> GetAgentsInSameSquare()
    {
        ILocation square = this.CurrentLocation();
        LinkedList<Agent> AgentsInCurrentGrid = this.Grid.GetAgentsInSquare(square);
        return AgentsInCurrentGrid;
    }


    public void Die()
    {
        Status status = Status.Dead;
        SetStatus(status);
    }


    protected boolean CanReproduce()
    {
        try {
            Random randomNumber = new Random(1);
            Double randomProbability = randomNumber.nextDouble() * 2 - 1;
            return randomProbability >= REPRODUCE_PROBABILITY ;
        }
        catch (Exception e)
        {
            e.fillInStackTrace();

        }

        return false;
    }




    @Override
    public ILocation GetLocation() {
        return Location;
    }


    public void SetLocation(ILocation location) {
         Location = location;

    }

    public void Move()
    {
        AgentMovement.RandomSingleStep(this, Grid);
    }

    //To allow implementation in concrete classes.
    //Was going to implement a template pattern.
    public abstract void ExecuteSteps();


    public abstract void Reproduce();



}
