package org.example;

import java.util.Scanner;

public class ClinicSystem {
    private final ClinicManager clinicManager = new ClinicManager();
    Scanner scanner = new Scanner(System.in);
    public void displayMenu() {
        while (true) {
            System.out.println("1. Make an Appointment");
            System.out.println("2. Patient Registration");
            System.out.println("3. View Available Times");
            System.out.println("4. Search Patient");
            System.out.println("5. Generate Bills");
            System.out.println("6. Update existing appointment");
            System.out.println("7. Search Appointment by Date");
            System.out.println("0. Exit");
            int choice = clinicManager.scanner.nextInt();
            clinicManager.scanner.nextLine();

            switch (choice) {
                case 1 -> clinicManager.makeAppointment();
                case 2 -> clinicManager.registerPatient();
                case 3 -> clinicManager.viewAvailableTimes();
                case 4 -> clinicManager.searchAppointment();
                case 5 -> clinicManager.generateBill();
                case 6 -> clinicManager.updateAppointment();
                case 7 -> clinicManager.filterAppointmentsByDate();
                case 0 -> {
                    System.out.println("Exiting system.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        ClinicSystem system = new ClinicSystem();
        system.displayMenu();
    }
}
