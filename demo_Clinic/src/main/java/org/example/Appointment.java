package org.example;

// Appointment.java
public class Appointment {
    private static int appointmentCounter = 1;
    private String appointmentID;
    private Patient patient; // Changed to Patient type
    private Dermatologist dermatologist; // Changed to Dermatologist type
    private String appointmentDate;
    private String appointmentTime;
    private boolean isPaid;


    public Appointment(String appointmentId, String doctor, String day, String selectedTime, Patient patient) {
    }


    public String getAppointmentID() {
        return appointmentID;
    }

    public Patient getPatient() {
        return patient;
    }

    public Dermatologist getDermatologist() {
        return dermatologist;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setAppointmentDate(String date) {
        this.appointmentDate = date;
    }

    public void setAppointmentTime(String time) {
        this.appointmentTime = time;
    }


    public void updateDetails(String date, String time, Dermatologist dermatologist) {
        this.appointmentDate = date;
        this.appointmentTime = time;
        this.dermatologist = dermatologist;
    }


    public void markAsPaid() {
        this.isPaid = true;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentID +
                "\nPatient: " + patient.getName() +
                "\nDermatologist: " + dermatologist.getName() +
                "\nDate: " + appointmentDate +
                "\nTime: " + appointmentTime +
                "\nIs Paid: " + (isPaid ? "Yes" : "No");
    }


}
