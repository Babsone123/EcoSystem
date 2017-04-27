package system.def;

/**
 * Created by anthonylawal on 21/04/2017.
 */
public interface IDefaultConfiguration {
    public int SetInitialEnergyLevel();
    public TrophicLevel Setlevel();
    public TypeOfOrganism SetType();
    public ILocation SetLocation();
    public int SetIncreaseEnergyValue();
    public int SetDecreaseEnergyValue();
}
