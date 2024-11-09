package org.example;


public interface ClinicOperations {
    void initializeDermatologists();

    void initializeTreatments();

    void makeAppointment();

    String generateAppointmentID(int docIndex, String date, String time);

    void viewAvailableTimes();

    void generateBill();

    void searchAppointment();




}


