package system.def;

/**
 * Created by anthonylawal on 21/04/2017.
 */
public class Grass extends Predator  {

    private IDefaultConfiguration configuration = new WolfConfiguration();

    protected Grass(TrophicLevel level, String name, int energyLevel, TypeOfOrganism type, ILocation location, int IncreaseEnergyValue, int DescreaseEnergyValue) {
        super(level, name, energyLevel, type, location, IncreaseEnergyValue, DescreaseEnergyValue);
    }

    protected Grass(IDefaultConfiguration configuration) {
        super(configuration);
    }


}
