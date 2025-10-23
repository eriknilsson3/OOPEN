package Inlämningsuppgift2;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GymManager {
    private List<Member> members = new ArrayList<>();

    /*
    Viktigt!! br.readLine(); är till för att hoppa över exempel raden som är först i filen, sedan läser den av alla
    medlemmar från gym_medlemmanr.txt enligt formatten namn, perspnnummer, sista betalningen och medlemskapstyp
     */
    public void loadFile(String fileName) {
        members.clear();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();
            String line;
            while ((line = br.readLine())  != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(";");
                if (parts.length < 7) continue;

                String name  = parts[0];
                String personnummer = parts[3];
                LocalDate lastPayment = LocalDate.parse(parts[5], formatter);
                String membershipType = parts[6];

                members.add(new Member(name, personnummer, lastPayment, membershipType));

            }
        } catch (IOException e) {
            System.out.println("Fel vid inläsning: " + e.getMessage());
        }
    }

    //Här jämförs input med filens innehål
    public Member findMember(String input) {
        String lowered = input.toLowerCase();
        for (Member m : members) {
            if (m.getName().toLowerCase().contains(lowered) || m.getPersonnummer().equals(lowered)) {
                return m;
            }
        }
        return null;
    }

    //Medlemmar som har aktivt medlemskap appendas till filen "traningslogg.txt" via denna metod i main.
    public void logVisit(Member m, String logFilename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFilename, true))) {
            writer.write(m.getName() + ";" + m.getPersonnummer() + ";" + LocalDate.now());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Fel vid loggning: " + e.getMessage());
        }
    }
}
