package model;

import java.io.File;

public class StudentData {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String birthMonth;
    private String birthYear;
    private String birthDay;
    private String gender;
    private String hobby;
    private String currAddress;
    private String subject;
    private String photo;
    private String state;
    private String city;

    public StudentData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StudentData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentData withEmail(String email) {
        this.email = email;
        return this;
    }

    public StudentData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public StudentData withBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
        return this;
    }

    public StudentData withBirthDay(String birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public StudentData withBirthYear(String birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public StudentData withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public StudentData withHobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

    public StudentData withCurrAddress(String currAddress) {
        this.currAddress = currAddress;
        return this;
    }

    public StudentData withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public StudentData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public StudentData withState(String state) {
        this.state = state;
        return this;
    }

    public StudentData withCity(String city) {
        this.city = city;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public String getHobby() {
        return hobby;
    }

    public String getCurrAddress() {
        return currAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public File getPhoto() {
        return photo != null ? new File(photo) : null;
    }

    @Override
    public String toString() {
        return "StudentData{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthDay + "." + birthMonth + "." + birthYear + '\'' +
                ", gender='" + gender + '\'' +
                ", hobby='" + hobby + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", address='" + currAddress + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
