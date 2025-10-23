package Inlämningsuppgift2;

import java.time.LocalDate;

public class Member {
    private String name;
    private String personnummer;
    private LocalDate LastPaymentDate;
    private String membershipType;

    public Member(String name, String personnummer, LocalDate LastPaymentDate, String membershipType) {
        this.name = name;
        this.personnummer = personnummer;
        this.LastPaymentDate = LastPaymentDate;
        this.membershipType = membershipType;
    }

    public String getName() {
        return name;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public LocalDate getLastPaymentDate() {
        return LastPaymentDate;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public boolean isCurrentlyMember() {
        return getLastPaymentDate().plusYears(1).isAfter(LocalDate.now());
    }
}
