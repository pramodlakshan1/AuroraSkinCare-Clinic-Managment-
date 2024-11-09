package org.example;

// Patient.java
public class Patient {
    private String nic;
    private String name;
    private String email;
    private String phone;

    public Patient(String nic, String name, String email, String phone) {
        this.nic = nic;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Patient(String name, String nic) {
    }

    public Patient(String name, String nic, String email) {
    }


    public String getNic() {
        return nic;
    }

   public String getName() {
        return name;
   }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String length() {
        return phone;
    }
}
