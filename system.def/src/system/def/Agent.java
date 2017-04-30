package system.def;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by anthonylawal on 18/04/2017.
 */
public abstract class Agent extends ObservableAgent {


    public String Name;
    public Grid Grid;
    public int EnergyLevel;
    private TypeOfOrganism _type;
    protected ILocation Location;
    protected int _increaseEnergyValue;
    protected int _decreaseEnergyValue;
    private Status _status;
    protected TrophicLevel Level;
    private Double R_Probability;


    protected Agent(TrophicLevel level, String name, int energyLevel, TypeOfOrganism type,
                    ILocation location, int IncreaseEnergyValue, int DescreaseEnergyValue,
                    double r_Probability) {

        EnergyLevel = energyLevel;
        _type = type;
        SetLocation(location);
        _increaseEnergyValue = IncreaseEnergyValue;
        _decreaseEnergyValue = DescreaseEnergyValue;
        _status = system.def.Status.Active;
        Level = level;
        Name = name;
        R_Probability = r_Probability;
    }


    protected Agent(IDefaultConfiguration configuration) {

        EnergyLevel = configuration.SetInitialEnergyLevel();
        _type = configuration.SetType();
        SetLocation(configuration.SetLocation());
        _increaseEnergyValue = configuration.SetIncreaseEnergyValue();
        _decreaseEnergyValue = configuration.SetDecreaseEnergyValue();
        _status = system.def.Status.Active;
        Level = configuration.Setlevel();
        R_Probability = configuration.R_Probability();
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
        EnergyLevel = -1;
        SetStatus(status);
    }


    protected boolean CanReproduce()
    {
        Random randomNumber = new Random(1);
        Double randomProbability = randomNumber.nextDouble();
        return randomProbability >= R_Probability ;
    }


    @Override
    public ILocation GetLocation() {
        return Location;
    }


    public void SetLocation(ILocation location) {
         Location = location;
         if (Grid != null)
         Grid.Add(this);

    }

    public void Move()
    {
        AgentMovement.RandomSingleStep(this);
    }

    //To allow implementation in concrete classes.
    //Was going to implement a template pattern.
    public abstract void ExecuteSteps();

    public abstract void Reproduce();

    //protected abstract boolean IsEatable(Agent prey);

}
