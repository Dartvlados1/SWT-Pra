package org.example;

public class Participant {
    private String name;
    int id;
    private int age;
    private int ageLevel;
    private String gender;

    private String kitchen;
    private int foodPreference;
    private int kitchenWidth;
    private int kitchenHeight;
    private String address;
    boolean succesor;
    //kitchen class
    //Enum

    public Participant(String name, int age, String gender, String kitchen, int foodPreference, int kitchenWidth, int kitchenHeight, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.kitchen = kitchen;
        this.foodPreference = foodPreference;
        this.kitchenWidth = kitchenWidth;
        this.kitchenHeight = kitchenHeight;
        this.address = address;
        ageLevel = getAgeLevel();
    }

    public int getAgeLevel(){

        if (age <= 17) {
            return 0;
        } else if (age >= 18 && age <= 23) {
            return 1;
        } else if (age >= 24 && age <= 27) {
            return 2;
        } else if (age >= 28 && age <= 30) {
            return 3;
        } else if (age >= 31 && age <= 35) {
            return 4;
        } else if (age >= 36 && age <= 41) {
            return 5;
        } else if (age >= 42 && age <= 46) {
            return 6;
        } else if (age >= 47 && age <= 56) {
            return 7;
        } else return 8;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAgeLevel(int ageLevel) {
        this.ageLevel = ageLevel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKitchen() {
        return kitchen;
    }

    public void setKitchen(String kitchen) {
        this.kitchen = kitchen;
    }

    public int getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(int foodPreference) {
        this.foodPreference = foodPreference;
    }

    public int getKitchenWidth() {
        return kitchenWidth;
    }

    public void setKitchenWidth(int kitchenWidth) {
        this.kitchenWidth = kitchenWidth;
    }

    public int getKitchenHeight() {
        return kitchenHeight;
    }

    public void setKitchenHeight(int kitchenHeight) {
        this.kitchenHeight = kitchenHeight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
