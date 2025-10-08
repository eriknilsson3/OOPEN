package inlämningsuppgift1;

public class Flytrap extends Plant {
    public Flytrap(double length, String name) {
        super(length, name);
    }

    @Override
    public String waterPlants() {
        double amount = 0.1+(0.2*length);
        return amount + "L " +  WaterTypes.PROTEINDRYCK.toString().toLowerCase();
    }
}
