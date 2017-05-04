package system.def;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;



public  class AgentMovement {


    private static ILocation nextLocation;

    public static void RandomSingleStep(Agent agent, IGrid grid)
    {
        grid.RemoveAgentInSquare(agent, agent.CurrentLocation());
        GetRandomAvailableSquare(agent, grid);
        agent.SetLocation(nextLocation);
        grid.Add(agent);

    }


    public static void Spread(Agent agent, IGrid grid)
    {
        agent = agent;
        grid = agent.Grid;

        GetRandomAvailableSquare(agent, grid);
        agent.SetLocation(nextLocation);

    }


    /*private static void NotifyObserver(Agent agent)
    {
        agent.setChanged();
        agent.notifyLocationChange();
    }

*/
    private static void GetRandomAvailableSquare(Agent agent, IGrid grid)
    {

        Direction[] directions = new Direction[]
                {
                        Direction.North,
                        Direction.South,
                        Direction.East,
                        Direction.West
                };

        Collections.shuffle(Arrays.asList(directions));

        for (Direction direction : directions) {
            if (IsSpaceAvailableInDirection(direction, agent, grid)) {
                nextLocation = GetSquare(direction, agent);
                break;
            }

        }
    }

    private static Square GetSquare(Direction direction, Agent agent)
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


    private static boolean IsSpaceAvailableInDirection(Direction Direction, Agent agent, IGrid grid)
    {

        boolean isSpaceAvailable = false;
        int gridWidth = grid.GetWidth();
        int gridLenght = grid.GetLenght();
        ILocation currentLocation = agent.GetLocation();


        switch (Direction) {

            case North:
                isSpaceAvailable = (gridWidth - currentLocation.GetY()) > 0;
                break;

            case South:
                isSpaceAvailable = (gridWidth - currentLocation.GetY()) < currentLocation.GetY();
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