package system.def;


import java.util.Observable;

/**
 * Created by anthonylawal on 23/04/2017.
 */
public interface IAgentObserver {
    void updateStatus(ObservableAgent agent, Status status);
    void LocationChanged(ObservableAgent agent);
    void ReduceEnergyLevel(ObservableAgent agent);
}