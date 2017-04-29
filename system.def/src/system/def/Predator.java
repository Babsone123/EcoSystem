package system.def;

import com.sun.tools.doclets.formats.html.PackageUseWriter;

import java.util.Random;

/**
 * Created by anthonylawal on 19/04/2017.
 */
public class Predator extends Agent {


    protected Predator(TrophicLevel level,String name, int energyLevel, TypeOfOrganism type, ILocation location, int IncreaseEnergyValue, int DescreaseEnergyValue) {
        super(level, name, energyLevel, type, location, IncreaseEnergyValue, DescreaseEnergyValue );

    }


    protected Predator(IDefaultConfiguration configuration) {
        super(configuration);

    }

    @Override
    public void ExecuteSteps() {

    }



    public void Eat(Agent prey) {

        if (this.Level.NumericValue() > prey.Level.NumericValue() & prey.GetType() != TypeOfOrganism.Plant) {
            prey.Die();
            IncreaseEnergyLevel();
        }

        else if (prey.GetType() == TypeOfOrganism.Plant) {

        }
    }
}
