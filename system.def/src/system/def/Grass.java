package system.def;

import java.util.LinkedList;

/**
 * Created by anthonylawal on 21/04/2017.
 */
public class Grass extends Agent  {

    private IDefaultConfiguration configuration = new WolfConfiguration();

    protected Grass(TrophicLevel level, String name, int energyLevel, TypeOfOrganism type, ILocation location, int IncreaseEnergyValue, int DescreaseEnergyValue, double probability) {
        super(level, name, energyLevel, type, location, IncreaseEnergyValue, DescreaseEnergyValue, probability);
    }

    protected Grass(IDefaultConfiguration configuration) {
        super(configuration);
    }

    @Override
    public void ExecuteSteps() {



    }

    @Override
    public boolean CanReproduce()
    {

        LinkedList<Agent> agentsInCurrentSquare = GetAgentsInSameSquare();
        boolean isGrassInCurrentSquare = true;


        for(int i = 0; i < agentsInCurrentSquare.size(); i++)
        {
            if(agentsInCurrentSquare.get(i).GetType() == TypeOfOrganism.Plant)
            {
                isGrassInCurrentSquare = false;
                break;
            }

        }

        return isGrassInCurrentSquare;
    }


    @Override
    public void Reproduce() {

        if (CanReproduce())
        {
            Grid.Add(new Grass(configuration));
        }
    }
}
