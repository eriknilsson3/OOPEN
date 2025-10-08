package inlämningsuppgift1;

interface Water{
    String waterPlants();
}

enum WaterTypes {
    KRANVATTEN,
    MINERALVATTEN,
    PROTEINDRYCK
}


abstract class Plant implements Water{
    //Två stycken inkapslingar som används i alla subklasser av Plant
    protected String name;
    protected double length;

    public Plant(double length, String name){
        this.name = name;
        this.length = length;
    }

    public String getName(){
        return name;
    }
}



