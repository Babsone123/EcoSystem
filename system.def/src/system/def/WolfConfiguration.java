package system.def;

import java.util.Random;


public class WolfConfiguration extends AgentConfiguration  {


    private static final int INITIALENERGYLEVEL = 40;
    private static final TypeOfOrganism TYPE = TypeOfOrganism.Carnivore;
    private static int INCREASEENERGYVALUE = 10;
    private static int DECREASEENERGYVALUE = 20;


    public WolfConfiguration(IGrid grid)
    {
        super(grid);
    }


    public int SetInitialEnergyLevel() {
        return INITIALENERGYLEVEL;
    }


    public TrophicLevel Setlevel() {
        return TrophicLevel.CARNIVORE;
    }


    public TypeOfOrganism SetType() {
        return TYPE;
    }


    public ILocation GetLocation() {
        return LOCATION;
    }


    @Override
    public void SetLocation(ILocation location) {

        LOCATION  = location;
    }


    public int SetIncreaseEnergyValue() {
        return INCREASEENERGYVALUE;
    }


    public int SetDecreaseEnergyValue() {
        return DECREASEENERGYVALUE;
    }


    public Double R_Probability() {
        return 5.0;
    }
}
