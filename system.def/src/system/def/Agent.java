package system.def;

/**
 * Created by anthonylawal on 18/04/2017.
 */
public abstract class Agent
{

    private int _energyLevel;
    private TypeOfOrganism _type;
    private Square _location;
    private int _increaseEnergyValue;
    private int _descreaseEnergyValue;

    protected Agent(int energyLevel, TypeOfOrganism type, Square location, int IncreaseEnergyValue, int DescreaseEnergyValue) {
        _energyLevel = energyLevel;
        _type = type;
        _location = location;
        _increaseEnergyValue = IncreaseEnergyValue;
        _descreaseEnergyValue = DescreaseEnergyValue;
    }

    private Agent(IDefaultConfiguration config)
    {
        _energyLevel = config.EnergyLevel;
        _type = config.Type;
        _location = config.Location;
        _increaseEnergyValue = config.IncreaseEnergyValue;
        _descreaseEnergyValue = config.DescreaseEnergyValue;

    }


    public TypeOfOrganism GetType()
    {
        return _type;
    }

    public Square CurrentLocation()
    {
        return _location;
    }

    public int GetEnergyLevel() { return _energyLevel; }

    public void IncreaseEnergyLevel()
    {
        _energyLevel += _increaseEnergyValue;
    }

    public void DescreaseEnergyLevel()
    {
        _energyLevel -= _descreaseEnergyValue;
    }
}
