package fr.codevallee.formation.health;

/**
 * @author Maxime REVEL
 * @date 19/10/2017
 */

public class Employee {
    /**
     * Java instance of an employee (got from database).
     */
    private String familyName;
    private String firstName;
    private String gender;
    private String job;
    private String service;
    private String email;
    private String phone;
    private String CV;

    @Override
    public String toString() {
        return "Employee{" +
                "familyName='" + familyName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                ", service='" + service + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", CV='" + CV + '\'' +
                '}';
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

    public Employee(String familyName, String firstName, String gender, String job, String service,
                    String email, String phone, String CV) {
        this.familyName = familyName;
        this.firstName = firstName;
        this.gender = gender;
        this.job = job;
        this.service = service;
        this.email = email;
        this.phone = phone;
        this.CV = CV;
    }
}
