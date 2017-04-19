package system.def;

import java.util.List;

/**
 * Created by anthonylawal on 19/04/2017.
 */
public interface IPredator {
     List<? extends Agent> ListOfPrey();
     void Move(Square destination);
     void Eat(Agent prey);


}
