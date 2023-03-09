import generators.StudentDataGenerator;
import model.StudentData;
import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {


    @Test
    void fillAllDataTest() {
        StudentData newStudentData = StudentDataGenerator.getRandomStudent();

        registrationPage.openPage()
                .setFirstName(newStudentData.getFirstName())
                .setLastName(newStudentData.getLastName())
                .setEmail(newStudentData.getEmail())
                .setGender(newStudentData.getGender())
                .setBirthDate(
                        newStudentData.getBirthDay(),
                        newStudentData.getBirthMonth(),
                        newStudentData.getBirthYear()
                )
                .setPhoto(newStudentData.getPhoto())
                .setState(newStudentData.getState())
                .setCity(newStudentData.getCity())
                .setSubject(newStudentData.getSubject())
                .setAddress(newStudentData.getCurrAddress())
                .setPhone(newStudentData.getPhone())
                .setHobby(newStudentData.getHobby());

        registrationPage.submitStudentForm();

        registrationResultsModal.verifyModalAppears();

        registrationResultsModal.verifyResult("Student Name", newStudentData.getFirstName() + " " + newStudentData.getLastName())
                .verifyResult("Student Email", newStudentData.getEmail())
                .verifyResult("Gender", newStudentData.getGender())
                .verifyResult("Mobile", newStudentData.getPhone())
                .verifyResult("Date of Birth",
                        newStudentData.getBirthDay() + " "
                                + newStudentData.getBirthMonth()
                                + "," + newStudentData.getBirthYear())
                .verifyResult("Subjects", newStudentData.getSubject())
                .verifyResult("Hobbies", newStudentData.getHobby())
                .verifyResult("Picture", newStudentData.getPhoto().getName())
                .verifyResult("Address", newStudentData.getCurrAddress())
                .verifyResult("State and City", newStudentData.getState() + " " + newStudentData.getCity());

        registrationResultsModal.closeResultsTable();

    }
}
