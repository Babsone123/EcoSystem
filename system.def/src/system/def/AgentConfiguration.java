package system.def;

import java.util.Random;

/**
 * Created by anthonylawal on 21/04/2017.
 */
public class AgentConfiguration {


    private  final int INITIALENERGYLEVEL = 40;
    private  final TypeOfOrganism TYPE = TypeOfOrganism.Plant;
    protected  ILocation LOCATION;
    private  int INCREASEENERGYVALUE = 10;
    private  int DECREASEENERGYVALUE = 20;
    protected IGrid _grid;


    public AgentConfiguration(IGrid grid)
    {
        int maxLenght = grid.GetLenght();
        int maxWidth = grid.GetWidth();
        _grid = grid;

        Random random = new Random();
        int x = random.nextInt(maxLenght);
        int y = random.nextInt(maxWidth);
        LOCATION  = new Square(x, y);
    }


    public int SetInitialEnergyLevel() {
        return INITIALENERGYLEVEL;
    }


    public TrophicLevel Setlevel() {
        return TrophicLevel.HERBIVOUR;
    }


    public TypeOfOrganism SetType() {
        return TYPE;
    }


    public ILocation GetLocation() {
        return LOCATION;
    }


    public void SetLocation(ILocation location) {

        LOCATION  = location;
    }


    public IGrid GetGrid()
    {
        return _grid;
    }


    public int SetIncreaseEnergyValue() {
        return INCREASEENERGYVALUE;
    }


    public int SetDecreaseEnergyValue() {
        return DECREASEENERGYVALUE;
    }


    public Double R_Probability() {
        return 0.5;
    }


}
