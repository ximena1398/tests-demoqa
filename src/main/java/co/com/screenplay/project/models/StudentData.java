package co.com.screenplay.project.models;

import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class StudentData {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobile;
    private String dateOfBirth;
    private String subjects;
    private List<Target> hobby;
    private String picturePath;
    private String address;
    private String state;
    private String city;


    public StudentData(String firstName, String lastName, String email, String gender, String mobile, String dateOfBirth,
                       String subjects, List<Target> hobby, String picturePath, String address, String state, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        this.subjects = subjects;
        this.hobby = hobby;
        this.picturePath = picturePath;
        this.address = address;
        this.state = state;
        this.city = city;
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

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSubjects() {
        return subjects;
    }

    public List<Target> getHobby() {
        return hobby;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
