package system.def;

/**
 * Created by anthonylawal on 18/04/2017.
 */
public abstract class Agent
{

    private int _energyLevel;
    private TypeOfOrganism _type;
    private Square _location;

    protected Agent(int energyLevel, TypeOfOrganism type, Square location) {
        _energyLevel = energyLevel;
        _type = type;
        _location = location;
    }

    public TypeOfOrganism GetType()
    {
        return _type;
    }

    public Square CurrentLocation()
    {
        return _location;
    }

    //public void Reproduce(Square)
}
