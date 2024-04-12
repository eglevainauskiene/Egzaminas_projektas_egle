package utils;
import com.github.javafaker.Faker;
import java.util.Random;
public class DataGenerator {
    static Faker faker = new Faker();
    static Random rnd = new Random();
    public static String getRandomFulName()
    {
        return faker.name().fullName();
    }
    public static String getRandomEmail()
    {
        return faker.internet().emailAddress();
    }
    public  static  String getRandomPhoneNumber(){return faker.phoneNumber().cellPhone();}
    public static int getRandomYearOfExperience(){return rnd.nextInt(6);}
    public static String getRandomMessage()
    {
        return faker.lorem().sentence();
    }
}
