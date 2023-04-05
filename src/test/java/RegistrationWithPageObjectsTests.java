import generators.StudentDataGenerator;
import helpers.Attach;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import model.StudentData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationWithPageObjectsTests extends TestBase {


    @Test
    @Tag("remote")
    @Owner("shinkai-tester")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "DEMOQA Practice Form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Fill all data in Student Registration Form and submit it")
    void fillAllDataTest() {
        StudentData newStudentData = StudentDataGenerator.getRandomStudent();

        step("Open Student Registration Form", () -> {
            registrationPage.openPage();
            registrationPage.removeBanAndFooter();
        });

        step("Fill all student's data", () -> {
            registrationPage.setFirstName(newStudentData.getFirstName())
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
        });


        step("Submit filled Student Registration Form", () -> {
            registrationPage.submitStudentForm();
        });

        step("Check after submitting table with all student's data", () -> {
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

            Attach.screenshotAs("Screenshot of the table with all student's data");
        });

        step("Close table with all student's data and end registration", () -> {
            registrationResultsModal.closeResultsTable();
        });
    }
}
