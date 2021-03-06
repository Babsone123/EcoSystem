package system.def;

import java.util.Random;

/**
 * Created by anthonylawal on 21/04/2017.
 */
public class DeerConfiguration extends AgentConfiguration {


    private  final int INITIALENERGYLEVEL = 40;
    private  final TypeOfOrganism TYPE = TypeOfOrganism.Herbivore;
    private  int INCREASEENERGYVALUE = 10;
    private  int DECREASEENERGYVALUE = 20;

    public DeerConfiguration(IGrid grid)
    {
        super(grid);
    }


    @Override
    public int SetInitialEnergyLevel() {
        return INITIALENERGYLEVEL;
    }


    @Override
    public TrophicLevel Setlevel() {
        return TrophicLevel.HERBIVOUR;
    }


    @Override
    public TypeOfOrganism SetType() {
        return TYPE;
    }


    @Override
    public ILocation GetLocation() {
        return LOCATION;
    }


    @Override
    public void SetLocation(ILocation location) {

        LOCATION  = location;
    }


    @Override
    public int SetIncreaseEnergyValue() {
        return INCREASEENERGYVALUE;
    }


    @Override
    public int SetDecreaseEnergyValue() {
        return DECREASEENERGYVALUE;
    }


    @Override
    public Double R_Probability() {
        return 0.3;
    }


}
