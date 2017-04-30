package system.def;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthonylawal on 18/04/2017.
 */
public class program {
    public static void main(String[] args) {

        //Grid g = new Grid(10, 10);
        Wolf w = new Wolf(new WolfConfiguration());
        Grass g = new Grass(new GrassConfiguration());
        Deer d = new Deer(new DeerConfiguration());


        List<Agent> agents = new ArrayList<>();
        agents.add(w);
        agents.add(g);
        agents.add(d);


        EcoController c = new EcoController(agents, 10, 10);
        c.Start();
    }
}
