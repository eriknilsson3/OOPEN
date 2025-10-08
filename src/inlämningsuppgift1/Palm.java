package inlämningsuppgift1;

public class Palm extends Plant {
    public Palm(double length, String name) {
        super(length, name);
    }

    @Override
    public String waterPlants() {
        double amount = 0.5*length;
        return amount + "L " + WaterTypes.KRANVATTEN.toString().toLowerCase();
    }
}
