package system.def;

import java.util.List;

/**
 * Created by anthonylawal on 21/04/2017.
 */

public class Wolf extends Agent implements IMobileAgent  {

    private IDefaultConfiguration configuration = new WolfConfiguration();

    protected Wolf( TrophicLevel level, String name, int energyLevel, TypeOfOrganism type, ILocation location, int IncreaseEnergyValue, int DescreaseEnergyValue) {
        super(level, name, energyLevel, type, location, IncreaseEnergyValue, DescreaseEnergyValue);
    }

    protected Wolf(IDefaultConfiguration configuration) {
        super(configuration);
    }


    @Override
    public void ExecuteSteps() {

        Move();


    }


    @Override
    public void Move() {
        AgentMovement.RandomSingleStep(this);
        DecreaseEnergyLevel();
    }
}
