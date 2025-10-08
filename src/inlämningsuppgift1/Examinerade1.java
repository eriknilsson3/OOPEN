package inlämningsuppgift1;

import javax.swing.*;
import java.util.*;

public class Examinerade1 {
    public static void main(String[] args) {

        boolean plantFound = false;
        List<Plant> plants = new ArrayList<Plant>();


        plants.add(new Cactus(0.2, "Igge"));
        plants.add(new Palm(5, "Laura"));
        plants.add(new Flytrap(0.7, "Meatloaf"));
        plants.add(new Palm(1, "Olof"));

        String input = JOptionPane.showInputDialog(null, "Vilken växt ska vattnas?");


        for(Plant plant : plants){
            if (plant.getName().equalsIgnoreCase(input.trim())){
                String message = plant.getName() + " behöver " + plant.waterPlants() + " per dag";
                JOptionPane.showMessageDialog(null, message);
                plantFound = true;
                break;
            }
        }
        if (!plantFound){
            JOptionPane.showMessageDialog(null, "Växten, " + "\"" + input + "\"" + ", hittades inte.");
        }
    }
}
