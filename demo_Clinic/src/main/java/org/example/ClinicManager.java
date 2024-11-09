package org.example;

import java.util.*;

public class ClinicManager implements ClinicOperations {

    private final Map<String, Integer> dailySlots = new HashMap<>();
    public final Scanner scanner = new Scanner(System.in);
    private final List<String> doctors = Arrays.asList("Dr. Smith", "Dr. Doe");
    private final Map<String, List<String>> availableSessions = new HashMap<>();
    private final Map<String, Appointment> appointments = new HashMap<>();
    private final List<Patient> patients = new ArrayList<>();
    private final List<Dermatologist> dermatologists = new ArrayList<>();
    private final List<Treatment> treatments = new ArrayList<>();

    public ClinicManager() {
        initializeDermatologists();
        initializeTreatments();
        initializeAvailableSessions();
        generateAppointmentSlots();
    }

    @Override
    public void initializeDermatologists() {

    }

    @Override
    public void initializeTreatments() {
        treatments.add(new Treatment("Acne Treatment", 2750.00));
        treatments.add(new Treatment("Skin Whitening", 7650.00));
        treatments.add(new Treatment("Mole Removal", 3850.00));
        treatments.add(new Treatment("Laser Treatment", 12500.00));
    }

    private void initializeAvailableSessions() {
        availableSessions.put("Monday", new ArrayList<>(Arrays.asList("10:00 AM", "10:15 AM", "10:30 AM", "10:45 AM",
                "11:00 AM","11:15 AM","11:30 AM","11:45 AM","12:00 AM","12:15 PM","12:30 PM","12:45 PM")));
        availableSessions.put("Wednesday", new ArrayList<>(Arrays.asList("2:00 PM", "2:15 PM", "2:30 PM", "2:45 PM"
        ,"3:00 PM", "3:15 PM", "3:30 PM", "3:45 PM","4:00 PM", "4:15 PM", "4:30 PM", "4:45 PM")));
        availableSessions.put("Friday", new ArrayList<>(Arrays.asList("4:00 PM", "4:15 PM", "4:30 PM", "4:45 PM","5:00 PM",
         "5:15 PM", "5:30 PM", "5:45 PM","6:00 PM", "6:15 PM", "6:30 PM", "6:45 PM","7:00 PM", "7:15 PM", "7:30 PM", "7:45 PM")));
        availableSessions.put("Saturday", new ArrayList<>(Arrays.asList("9:00 AM", "9:15 AM", "9:30 AM", "9:45 AM",
                "10:00 AM", "10:15 AM", "10:30 AM", "10:45 AM","11:00 AM", "11:15 AM", "11:30 AM", "11:45 AM","12:00 AM",
                "12:15 AM", "12:30 AM", "12:45 AM")));
    }

    private void generateAppointmentSlots() {
        dailySlots.put("Monday", calculateSlots(3));
        dailySlots.put("Wednesday", calculateSlots(3));
        dailySlots.put("Friday", calculateSlots(4));
        dailySlots.put("Saturday", calculateSlots(4));
    }

    private int calculateSlots(int hours) {
        return (hours * 60) / 15;
    }

    public void registerPatient() {
        System.out.print("Enter NIC for registration: ");
        String nic = scanner.nextLine();

        for (Patient patient : patients) {
            if (patient.getNic().equals(nic)) {
                System.out.println("Patient already registered.");
                return;
            }
        }

        System.out.println("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Patient mobile number: ");
        String mobile = scanner.nextLine();
        System.out.println("Enter Patient email" );
        String email = scanner.nextLine();
        Patient newPatient = new Patient(name, nic, email,mobile);
        patients.add(newPatient);
        System.out.println("Patient registered successfully.");
    }

    @Override
    public void makeAppointment() {
        System.out.print("Enter NIC for registration: ");
        String nic = scanner.nextLine();

        for (Patient patient : patients) {
            if (patient.getNic().equals(nic)) {
                System.out.println("Patient already registered.");
                return;
            }
        }

        System.out.println("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Patient mobile number: ");
        String mobile = scanner.nextLine();
        System.out.println("Enter Patient email" );
        String email = scanner.nextLine();
        Patient newPatient = new Patient(name, nic, email,mobile);
        patients.add(newPatient);
        System.out.println("Patient registered successfully.");


        System.out.println("Select Doctor:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i));
        }
        int doctorIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        String doctor = doctors.get(doctorIndex);

        System.out.println("Available days for " + doctor + ": " + dailySlots.keySet());
        System.out.print("Enter desired day (e.g., Monday): ");
        String day = scanner.nextLine();

        if (!availableSessions.containsKey(day)) {
            System.out.println("Invalid day selected. Try again.");
            return;
        }

        List<String> sessions = availableSessions.get(day);
        System.out.println("Available slots:");
        for (int i = 0; i < sessions.size(); i++) {
            System.out.println((i + 1) + ". " + sessions.get(i));
        }

        System.out.print("Select a time slot number: ");
        int slotIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (slotIndex < 0 || slotIndex >= sessions.size()) {
            System.out.println("Invalid slot. Try again.");
            return;
        }

        String selectedTime = sessions.get(slotIndex);
        String appointmentId = generateAppointmentID(doctorIndex, day, String.valueOf(slotIndex + 1));

        Patient patient = null;
        Appointment newAppointment = new Appointment(appointmentId, doctor, day, selectedTime, patient);
        appointments.put(appointmentId, newAppointment);
        sessions.remove(slotIndex);

        System.out.println("Appointment confirmed with ID: " + appointmentId);
        System.out.println("Doctor: " + doctor);
        System.out.println("Day: " + day);
        System.out.println("Time: " + selectedTime);
    }

    @Override
    public String generateAppointmentID(int docIndex, String date, String time) {
        return "d" + (docIndex + 1) + date.substring(0, 1).toUpperCase() + time;
    }


    @Override
    public void viewAvailableTimes() {
        System.out.println("Doctors' Available Times:");
        for (Map.Entry<String, List<String>> entry : availableSessions.entrySet()) {
            String day = entry.getKey();
            List<String> times = entry.getValue();
            System.out.println(day + ": " + String.join(", ", times));
        }
    }

    @Override
    public void generateBill() {
        System.out.println("Enter Appointment ID:");
        String appointmentId = scanner.nextLine();

        Appointment appointment = appointments.get(appointmentId);
        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }

        double registrationFee = 500.0;
        System.out.println("Registration Fee: LKR " + registrationFee);

        System.out.println("Select Treatments (enter numbers separated by commas):");
        for (int i = 0; i < treatments.size(); i++) {
            System.out.println((i + 1) + ". " + treatments.get(i).getTreatmentName() + " - LKR " + treatments.get(i).getTreatmentPrice());
        }
        String[] selected = scanner.nextLine().split(",");

        List<Treatment> selectedTreatments = new ArrayList<>();
        double totalTreatmentCost = 0.0;
        for (String s : selected) {
            int index = Integer.parseInt(s.trim()) - 1;
            Treatment treatment = treatments.get(index);
            selectedTreatments.add(treatment);
            totalTreatmentCost += treatment.getTreatmentPrice();
        }

        double taxRate = 0.025;  // 2.5% tax
        double taxAmount = totalTreatmentCost * taxRate;
        double totalAmount = registrationFee + totalTreatmentCost + taxAmount;

        System.out.println("\n--- Invoice ---");
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient: " + appointment.getPatient().getName());
        System.out.println("Registration Fee: LKR " + registrationFee);

        System.out.println("\nSelected Treatments:");
        for (Treatment treatment : selectedTreatments) {
            System.out.println("- " + treatment.getTreatmentName() + " : LKR " + treatment.getTreatmentPrice());
        }

        System.out.println("Total Treatment Cost: LKR " + totalTreatmentCost);
        System.out.println("Tax (2.5%): LKR " + taxAmount);
        System.out.println("Total Payable Amount: LKR " + totalAmount);
        System.out.println("--- End of Invoice ---");
    }



    @Override
    public void searchAppointment() {
        System.out.print("Enter Patient Name or Appointment ID: ");
        String query = scanner.nextLine();

        boolean found = false;
        for (Appointment appointment : appointments.values()) {
            if (!(!appointment.getAppointmentID().equalsIgnoreCase(query) &&
                    !appointment.getPatient().getName().equalsIgnoreCase(query))) {
                System.out.println(appointment);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments found for the given input.");
        }
    }

    public void updateAppointment() {
        System.out.print("Enter Appointment ID to update: ");
        String id = scanner.nextLine();
        Appointment appointment = appointments.get(id);

        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }

        System.out.print("Enter new day: ");
        String newDay = scanner.nextLine();
        if (!availableSessions.containsKey(newDay)) {
            System.out.println("Invalid day. Try again.");
            return;
        }

        System.out.println("Available times for " + newDay + ":");
        List<String> times = availableSessions.get(newDay);
        for (int i = 0; i < times.size(); i++) {
            System.out.println((i + 1) + ". " + times.get(i));
        }

        System.out.print("Choose new time slot: ");
        int newTimeIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (newTimeIndex < 0 || newTimeIndex >= times.size()) {
            System.out.println("Invalid time slot.");
            return;
        }

        appointment.setAppointmentDate(newDay);
        appointment.setAppointmentTime(times.get(newTimeIndex));
        System.out.println("Appointment updated successfully.");
    }
    public void filterAppointmentsByDate() {
        System.out.print("Enter day to filter (e.g., Monday): ");
        String day = scanner.nextLine();

        for (Appointment appointment : appointments.values()) {
            if (appointment.getDay().equalsIgnoreCase(day)) {
                System.out.println(appointment);
            }
        }
    }
}
