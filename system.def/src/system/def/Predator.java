package system.def;

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


    public void Move(ILocation destination) {

        Grid.RemoveAgentInSquare(this, GetLocation());
        SetLocation(destination);
        setChanged();
        notifyLocationChange();

    }

    public void MoveToNeighbouringSquare()
    {

     //        north = currentPos - gridSize; y + 1
     //        east = currentPos + 1; x + 1
     //        south = currentPos + gridSize; y - 1
     //        west = currentPos - 1; x - 1



    }


    private boolean IsSpaceAvailableInDirection(int Direction)
    {

        boolean isSpaceAvailable = false;
        int gridBreath = Grid.GetBreath();
        int gridLenght = Grid.GetLenght();
        ILocation currentLocation = GetLocation();


        switch (Direction) {

            case 1:
               isSpaceAvailable = (gridBreath - currentLocation.GetY()) > 0;
               break;

            case 2:
                isSpaceAvailable = (gridBreath - currentLocation.GetY()) < currentLocation.GetY();
                break;

            case 3:
                isSpaceAvailable = (gridLenght - currentLocation.GetX()) > 0;
                break;

            case 4:
                isSpaceAvailable = (gridLenght - currentLocation.GetX()) < currentLocation.GetX();
                break;

        }

        return isSpaceAvailable;
    }

    /*private Square GetNextSquare()
    {
        int direction = new Random().nextInt(4);

        switch (direction) {
            case 1:

                break;

        }

       // if (GetLocation().GetX())
    }
   */

    public void Eat(Agent prey) {

        Status status = Status.Dead;

        if (this.Level.NumericValue() > prey.Level.NumericValue() & prey.GetType() != TypeOfOrganism.Plant)
            prey.SetStatus(status);

        else if (prey.GetType() == TypeOfOrganism.Plant) {



        }
    }
}
