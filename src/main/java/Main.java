import model.*;
import validators.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.jboss.logging.Logger;
import java.util.Set;


public class Main {

    public static void main(String[] args) {
        Validate val = new Validate();

        //Correct build
        Person person1 = val.validPerson(new Person.Builder("Colia", "Havriliuk").setGender(Person.Gender.male).setYear(2000).build());
        System.out.println(person1);

        //Incorrect build
        Person person2 = val.validPerson(new Person.Builder("C", "Havriliuk").setGender(Person.Gender.male).setYear(2021).build());
        System.out.println(person2);
    }
}
