package fr.codevallee.formation.health.databases;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Maxime REVEL
 * @date 19/10/2017
 */

public class Employee implements Parcelable {
    /**
     * Java instance of an employee (got from database).
     * Parcelable to put it into Intents.
     */
    private Integer id;
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
                "id='" + id.toString() + '\'' +
                ", familyName='" + familyName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                ", service='" + service + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", CV='" + CV + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Employee(Integer id, String familyName, String firstName, String gender, String job,
                    String service, String email, String phone, String CV) {
        this.id = id;
        this.familyName = familyName;
        this.firstName = firstName;
        this.gender = gender;
        this.job = job;
        this.service = service;
        this.email = email;
        this.phone = phone;
        this.CV = CV;
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    protected Employee(Parcel in) {
        readFromParcel(in);
    }

    protected void readFromParcel(Parcel in) {
        this.id = in.readInt();
        this.familyName = in.readString();
        this.firstName = in.readString();
        this.gender = in.readString();
        this.job = in.readString();
        this.service = in.readString();
        this.email = in.readString();
        this.phone = in.readString();
        this.CV = in.readString();
    }

    @Override
    public int describeContents() {
        return 9;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(familyName);
        dest.writeString(firstName);
        dest.writeString(gender);
        dest.writeString(job);
        dest.writeString(service);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(CV);
    }
}
