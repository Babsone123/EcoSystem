package system.def;

//Modified and implemented Java observer object.

import java.util.Vector;


public abstract class ObservableAgent {


    private boolean changed = false;
    private Vector<IAgentObserver> observers;

    public abstract void IncreaseEnergyLevel();


    public abstract void DecreaseEnergyLevel();


    public abstract ILocation GetLocation();


    public abstract Status GetStatus();


    public abstract int GetEnergyLevel();


    public abstract void SetStatus(Status status);


    public ObservableAgent() {
        observers = new Vector<>();
    }


    public synchronized void addObserver(IAgentObserver o) {
        if (o == null)
            throw new NullPointerException();
        if (!observers.contains(o)) {
            observers.addElement(o);
        }
    }


    public synchronized void deleteObserver(IAgentObserver o) {
        observers.removeElement(o);
    }


    public void notifyObserverAboutNewAgent()
    {
        Vector<IAgentObserver> arrLocal;

        synchronized (this) {

            if (!changed)
                return;
            arrLocal = observers;
            clearChanged();
        }

        for (int i = arrLocal.size()-1; i >= 0; i--)
            arrLocal.get(i).NotifyAboutNewAgent(this);
    }

    public void notifyStatusChange(ObservableAgent agent, Status status) {

        Vector<IAgentObserver> arrLocal;

        synchronized (this) {

            if (!changed)
                return;
            arrLocal = observers;
            clearChanged();
        }

        for (int i = arrLocal.size()-1; i >= 0; i--)
            arrLocal.get(i).updateStatus(agent, status);
    }


    public void notifyStatusChange(Status status) {

        notifyStatusChange(this, status);

    }


    /*public void notifyLocationChange() {

        Vector<IAgentObserver> arrLocal;

        synchronized (this) {

            if (!changed)
                return;
            arrLocal = observers;
            clearChanged();
        }

        for (int i = arrLocal.size()-1; i>=0; i--)
            try {
                arrLocal.get(i).LocationChanged(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

*/
    public synchronized void deleteObservers() {
        observers.removeAllElements();
    }


    protected synchronized void setChanged() {
        changed = true;
    }


    protected synchronized void clearChanged() {
        changed = false;
    }


    public synchronized boolean hasChanged() {
        return changed;
    }


    public synchronized int countObservers() {
        return observers.size();
    }


    public void notifyLocationChange() {

        Vector<IAgentObserver> arrLocal;

        synchronized (this) {

            if (!changed)
                return;
            arrLocal = observers;
            clearChanged();
        }

        for (int i = arrLocal.size()-1; i >= 0; i--)
            arrLocal.get(i).updateLocation(this, this.GetLocation());
    }
    }

