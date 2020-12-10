package validators;
import model.*;
import org.jboss.logging.Logger;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class Validate {
    public Person validPerson(Person person) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = (Validator) factory.getValidator();
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        Logger log = Logger.getLogger(Person.class);
        for (ConstraintViolation<Person> violation : constraintViolations) {
            //log.error(violation.getMessage());
            //System.out.println(violation.getInvalidValue() + " " + violation.getConstraintDescriptor());
        }
        if (constraintViolations.size() == 0) {
            return person;
        }
        else {
            return null;
        }
    }
}
