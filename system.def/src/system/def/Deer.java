package system.def;

/**
 * Created by anthonylawal on 21/04/2017.
 */
public class Deer extends Predator  {

    private IDefaultConfiguration configuration = new WolfConfiguration();

    protected Deer(TrophicLevel level, String name, int energyLevel, TypeOfOrganism type, ILocation location, int IncreaseEnergyValue, int DescreaseEnergyValue) {
        super(level, name, energyLevel, type, location, IncreaseEnergyValue, DescreaseEnergyValue);
    }

    protected Deer(IDefaultConfiguration configuration) {
        super(configuration);
    }


}
