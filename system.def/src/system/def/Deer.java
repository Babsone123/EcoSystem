package system.def;

import java.util.LinkedList;

/**
 * Created by anthonylawal on 21/04/2017.
 */

public class Deer extends Agent implements MobileAgent,  IPredator {

    private IDefaultConfiguration configuration = new WolfConfiguration();

    protected Deer(TrophicLevel level,
                   String name,
                   int energyLevel,
                   TypeOfOrganism type,
                   ILocation location,
                   int IncreaseEnergyValue,
                   int DescreaseEnergyValue, double reproProbability) {
        super(level, name, energyLevel, type, location, IncreaseEnergyValue, DescreaseEnergyValue, reproProbability);
    }

    protected Deer(IDefaultConfiguration configuration) {
        super(configuration);
    }


@Override
public void ExecuteSteps() {

        Move();
        Eat();
        Reproduce();
        DecreaseEnergyLevel();

}


@Override
public void Reproduce() {

        if (CanReproduce())
        {
            Grid.Add(new Deer(configuration));
        }
    }


    public boolean IsEatable(Agent prey)
    {
        boolean eatable = false;

        if (this.Level.NumericValue() > prey.Level.NumericValue() & prey.GetType() == TypeOfOrganism.Plant) {

            eatable = true;
        }

        return eatable;

    }


    public void Eat() {

        LinkedList<Agent> agentsInCurrentSquare = GetAgentsInSameSquare();

        for(int i = 0; i < agentsInCurrentSquare.size(); i++)
        {
            Agent currentAgent = agentsInCurrentSquare.get(i);

            if(IsEatable(currentAgent))
            {
                agentsInCurrentSquare.get(i).DecreaseEnergyLevel();
                IncreaseEnergyLevel();
                break;
            }
        }
    }
}
