package Inlämningsuppgift2;

import java.util.Scanner;

public class Examinerande2 {
    public static void main(String[] args) {
        GymManager manager = new GymManager();
        manager.loadFile("gym_medlemmar.txt");

        Scanner scan = new Scanner(System.in);
        boolean end = false;

        System.out.println("Välkommen manager. För att avsluta programmet, skriv \"exit\".\n");
        while (end != true) {
            System.out.print("Ange namn eller personnummer: ");
            String input = scan.nextLine();

            if (input.trim().equals("exit")) {
                System.out.println("Stänger ned programmet.");
                end = true;
                break;
            }

            Member m = manager.findMember(input);
            if (m == null) {
                System.out.println("Person finns ej i systemet.\n");
            } else if (m.isCurrentlyMember()) {
                System.out.println(m.getName() + " är en medlem (" + m.getMembershipType() + ").\n");
                manager.logVisit(m, "traningslogg.txt");

            }else {
                System.out.println(m.getName() + " är en före detta medlem.\n");
            }
        }
        scan.close();
    }
}
