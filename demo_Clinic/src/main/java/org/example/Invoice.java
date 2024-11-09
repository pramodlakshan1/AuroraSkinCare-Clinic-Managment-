package org.example;

// Invoice.java
import java.util.List;

public class Invoice extends ClinicManager{
    private Appointment appointment;
    private List<Treatment> treatments;
    private final double taxRate = 2.5;
    private final double registrationFee = 500.00;
    private double totalAmount;

    public Invoice(Appointment appointment, List<Treatment> treatments) {
        this.appointment = appointment;
        this.treatments = treatments;
        this.totalAmount = calculateTotal();
    }

    private double calculateTotal() {
        double total = registrationFee;
        for (Treatment treatment : treatments) {
            total += treatment.getTreatmentPrice();
        }
        return total * (1 + taxRate / 100);
    }

    public void generateInvoice() {
        System.out.println("Invoice for Appointment ID: " + appointment.getAppointmentID());
        System.out.println("Patient: " + appointment.getPatient().length());
        System.out.println("Registration Fee: " + registrationFee);
        for (Treatment treatment : treatments) {
            System.out.println("Treatment: " + treatment.getTreatmentName() + " - Price: LKR " + treatment.getTreatmentPrice());
        }
        System.out.println("Total (including tax): LKR " + totalAmount);
    }
}

