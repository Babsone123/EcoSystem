package system.def;

/**
 * Created by anthonylawal on 21/04/2017.
 */
public class DeerConfiguration implements IDefaultConfiguration {


    private static final int INITIALENERGYLEVEL = 40;
    private static final TypeOfOrganism TYPE = TypeOfOrganism.Herbivore;
    private static ILocation LOCATION = new Square(1, 5);
    private static int INCREASEENERGYVALUE = 10;
    private static int DECREASEENERGYVALUE = 20;


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
    public ILocation SetLocation() {
        return LOCATION;
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
