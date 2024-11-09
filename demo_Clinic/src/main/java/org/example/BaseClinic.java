package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class BaseClinic implements ClinicOperations {
    protected final List<Patient> patients = new ArrayList<>();
    protected final List<Dermatologist> dermatologists = new ArrayList<>();
    protected final List<Appointment> appointments = new ArrayList<>();
    protected final List<Treatment> treatments = new ArrayList<>();
    protected final Scanner scanner = new Scanner(System.in);

    public BaseClinic() {
        initializeDermatologists();
        initializeTreatments();
    }

}
