package generators;

import com.github.javafaker.Faker;
import model.StudentData;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class StudentDataGenerator {

    public static StudentData getRandomStudent() {
        Faker data = new Faker();

        String firstName = data.name().firstName();
        String lastName = data.name().lastName();
        String email = firstName + '.' + lastName + "@example.com";
        String phone = data.phoneNumber().subscriberNumber(10);
        LocalDate birthday = data.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String month = StringUtils.capitalize(birthday.getMonth().name().toLowerCase());
        String year = Integer.toString(birthday.getYear());
        String day = birthday.format(DateTimeFormatter.ofPattern("dd"));
        String[] genders = new String[]{"Male", "Female", "Other"};
        String gender = getRndValueArr(genders);
        String[] hobbies = new String[]{"Sports", "Reading", "Music"};
        String hobby = getRndValueArr(hobbies);
        String currAddress = data.address().streetAddress();
        File photo = new File("src/test/resources/photos/Bugcat_Capoo.jpg");
        String subject = "Computer Science";
        String state = "Haryana";
        String city = "Karnal";

        return new StudentData()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withBirthDay(day)
                .withBirthMonth(month)
                .withBirthYear(year)
                .withEmail(email)
                .withPhone(phone)
                .withGender(gender)
                .withHobby(hobby)
                .withCurrAddress(currAddress)
                .withPhoto(photo)
                .withSubject(subject)
                .withState(state)
                .withCity(city);
    }

    public static String getRndValueArr(String[] arr) {
        int rnd = new Random().nextInt(arr.length);
        return arr[rnd];
    }
}