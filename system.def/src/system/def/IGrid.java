package system.def;

import java.util.LinkedList;

/**
 * Created by anthonylawal on 30/04/2017.
 */

public interface IGrid {
    LinkedList<Agent> GetAgentsInSquare(ILocation location);
    void Add(Agent agent );
    void RemoveAgentInSquare(Agent agent, ILocation location);
    int GetLenght();
    int GetWidth();

}
