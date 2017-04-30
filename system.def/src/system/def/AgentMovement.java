package system.def;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthonylawal on 27/04/2017.
 */

public class AgentMovement {


    private static Grid grid;
    private static Agent agent;
    private static ILocation nextLocation;

    public static void RandomSingleStep(Agent agent)
    {

        agent = agent;
        grid = agent.Grid;


        agent.Grid.RemoveAgentInSquare(agent, agent.CurrentLocation());
        GetRandomAvailableSquare();
        agent.SetLocation(nextLocation);
        NotifyObserver();
    }


    private static void NotifyObserver()
    {
        agent.setChanged();
        agent.notifyLocationChange();
    }


    private static void GetRandomAvailableSquare()
    {

        Direction[] directions = new Direction[]
                {
                Direction.North,
                Direction.South,
                Direction.East,
                Direction.West
                };


        for (Direction direction : directions) {
            if (IsSpaceAvailableInDirection(direction)) {
                nextLocation = GetSquare(direction);
                break;
            }
        }
    }

    private static Square GetSquare(Direction direction)
    {

        Square nextSquare = null;
        int x = agent.CurrentLocation().GetX();
        int y = agent.CurrentLocation().GetY();

        switch (direction)
        {
            case North:
                y = y += 1;
                nextSquare = new Square(x, y);
                break;

            case South:
                y = y -= 1;
                nextSquare = new Square(x, y);
                break;

            case East:
                x = x += 1;
                nextSquare = new Square(x, y);
                break;

            case West:
                x = x -= 1;
                nextSquare = new Square(x, y);
                break;

        }

        return nextSquare;
    }


    private static boolean IsSpaceAvailableInDirection(Direction Direction)
    {

        boolean isSpaceAvailable = false;
        int gridBreath = grid.GetBreath();
        int gridLenght = grid.GetLenght();
        ILocation currentLocation = agent.GetLocation();


        switch (Direction) {

            case North:
                isSpaceAvailable = (gridBreath - currentLocation.GetY()) > 0;
                break;

            case South:
                isSpaceAvailable = (gridBreath - currentLocation.GetY()) < currentLocation.GetY();
                break;

            case East:
                isSpaceAvailable = (gridLenght - currentLocation.GetX()) > 0;
                break;

            case West:
                isSpaceAvailable = (gridLenght - currentLocation.GetX()) < currentLocation.GetX();
                break;

        }

        return isSpaceAvailable;

    }

}
