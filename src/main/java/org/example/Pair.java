package org.example;

public class Pair {
    private Participant participant1;
    private Participant participant2;
    private Participant kitchenProvider;
    private Participant kitchenGuest;

    private int foodPreference;
    private int preferenceDeviation;
    private double genderDiversity;
    private int ageDifference;
    private int routeLength;
    private int distanceParty;
    private int groupNumber;
    private int groupClusterNumber;
    boolean succesor;


    public Participant getParticipant1() {
        return participant1;
    }

    public void setParticipant1(Participant participant1) {
        this.participant1 = participant1;
    }

    public Participant getParticipant2() {
        return participant2;
    }

    public void setParticipant2(Participant participant2) {
        this.participant2 = participant2;
    }

    public Participant getKitchenProvider() {
        return kitchenProvider;
    }

    public void setKitchenProvider(Participant kitchenProvider) {
        this.kitchenProvider = kitchenProvider;
    }

    public int getKitchen_height() {
        return kitchenProvider.getKitchenHeight();
    }


    public int getKitchen_width() {
        return kitchenProvider.getKitchenWidth();
    }


    public int getFoodPreference() {
        if (participant1.getFoodPreference() == participant2.getFoodPreference() ) {
            return participant1.getFoodPreference();
        } else if (participant1.getFoodPreference() < participant2.getFoodPreference()) {
            return participant2.getFoodPreference();
        }
        return 0;
    }

    public int getPreferenceDeviation() {
        return Math.abs(participant1.getFoodPreference() - participant2.getFoodPreference());
    }

    public double getGenderDiversity() {
        if (participant1.getGender().equals(participant2.getGender())) {
            return 0;
        }
        return 0.5;
    }
    public int getAgeDifference() {
        return Math.abs(participant1.getAgeLevel() - participant2.getAgeLevel());
    }

    public int getRouteLength() {
        return routeLength;
    }

    public void setRouteLength(int routeLength) {
        this.routeLength = routeLength;
    }

    public int getDistanceParty() {
        return distanceParty;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getGroupClusterNumber() {
        return groupClusterNumber;
    }

    public void setGroupClusterNumber(int groupClusterNumber) {
        this.groupClusterNumber = groupClusterNumber;
    }


}
