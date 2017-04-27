package system.def;

/**
 * Created by anthonylawal on 21/04/2017.
 */
public class WolfConfiguration implements IDefaultConfiguration {


    private static final int INITIALENERGYLEVEL = 40;
    private static final TypeOfOrganism TYPE = TypeOfOrganism.Carnivore;
    private static ILocation LOCATION = new Square(0, 6);
    private static int INCREASEENERGYVALUE = 10;
    private static int DECREASEENERGYVALUE = 20;


    @Override
    public int SetInitialEnergyLevel() {
        return INITIALENERGYLEVEL;
    }


    @Override
    public TrophicLevel Setlevel() {
        return TrophicLevel.CARNIVORE;
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
}
