package org.example;

// Dermatologist.java
import java.util.List;

public class Dermatologist {
    private String name;
    private List<String> availableDays;
    private List<String> availableTimes;

    public Dermatologist(String name, List<String> availableDays, List<String> availableTimes) {
        this.name = name;
        this.availableDays = availableDays;
        this.availableTimes = availableTimes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailableDays(List<String> availableDays) {
        this.availableDays = availableDays;
    }

    public void setAvailableTimes(List<String> availableTimes) {
        this.availableTimes = availableTimes;
    }

    public String getName() { return name; }
    public List<String> getAvailableDays() { return availableDays; }
    public List<String> getAvailableTimes() { return availableTimes; }

    public boolean isAvailable(String day, String time) {
        return availableDays.contains(day) && availableTimes.contains(time);
    }
}
