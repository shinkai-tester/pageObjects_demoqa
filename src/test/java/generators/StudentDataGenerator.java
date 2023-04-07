package generators;

import com.github.javafaker.Faker;
import model.StudentData;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class StudentDataGenerator {

    public static StudentData getRandomStudent() {
        Faker faker = new Faker();
        ClassLoader classLoader = StudentDataGenerator.class.getClassLoader();

        String[] genders = new String[]{"Male", "Female", "Other"},
                hobbies = new String[]{"Sports", "Reading", "Music"},
                subjects = {"Maths", "Arts", "Accounting", "English", "Social Studies", "Computer Science",
                        "Commerce", "Economics", "Chemistry", "Biology", "Physics", "Civics", "Hindi", "History"};


        LocalDate birthday = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        File photo = new File(Objects.requireNonNull(classLoader.getResource("photos/Bugcat_Capoo.jpg")).getFile());

        Map<String, String[]> statesAndCities =
                Map.of("NCR",new String[]{"Delhi", "Gurgaon", "Noida"},
                        "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
                        "Haryana", new String[]{"Karnal", "Panipat"},
                        "Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = firstName + '.' + lastName + "@example.com",
                phone = faker.phoneNumber().subscriberNumber(10),
                month = StringUtils.capitalize(birthday.getMonth().name().toLowerCase()),
                year = Integer.toString(birthday.getYear()),
                day = birthday.format(DateTimeFormatter.ofPattern("dd")),
                gender = faker.options().nextElement(genders),
                hobby = faker.options().nextElement(hobbies),
                currAddress = faker.address().streetAddress(),
                subject = faker.options().nextElement(subjects),
                state = faker.options().nextElement(new ArrayList<>(statesAndCities.keySet())),
                city = faker.options().nextElement(statesAndCities.get(state));

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
}