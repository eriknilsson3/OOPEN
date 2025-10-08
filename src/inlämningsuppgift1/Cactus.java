package inlämningsuppgift1;

public class Cactus extends Plant {
    public Cactus(double length, String name) {
        super(length, name);
        /*
        Här används inkapsling via extend, sedan super keyword för att få tillgång till "length" och "name".
        Man skulle även kunna göra den abstrakta klassen "Plant" public och sedan definerat "length och "name" -
        som private och för att nå dom så använder man samma super keyword.
        */
    }


    //Denna override string är ett exempel av polymorfism, mer specifikt waterPlants() metoden, då den-
    //används på samma sätt, men ger olika returns/värden för varje klass.
    @Override
    public String waterPlants() {
        double amount = 0.02;
        return amount + "CL " + WaterTypes.MINERALVATTEN.toString().toLowerCase();
    }
}
