package system.def;

/**
 * Created by anthonylawal on 24/04/2017.
 */

//https://en.wikipedia.org/wiki/Trophic_level

public enum TrophicLevel {
    PLANTS(100), HERBIVOUR(200), CARNIVORE(300), CARNIVORE2(400), APEXPREDATOR(500);

    private int numericValue;

    TrophicLevel(int numVal) {
        this.numericValue = numVal;
    }

    public int NumericValue() {
        return numericValue;
    }
}
