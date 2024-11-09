package org.example;

// Treatment.java
public class Treatment {
    private String treatmentName;
    private double treatmentPrice;

    public Treatment(String treatmentName, double treatmentPrice) {
        this.treatmentName = treatmentName;
        this.treatmentPrice = treatmentPrice;
    }

    public double getTreatmentPrice() { return treatmentPrice; }
    public String getTreatmentName() { return treatmentName; }
}

