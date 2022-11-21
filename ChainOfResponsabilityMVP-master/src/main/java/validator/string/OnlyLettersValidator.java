package validator.string;

import validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnlyLettersValidator extends Validator {

    @Override
    public <T> boolean valid(T data) {
        System.out.println("init " + this.getClass().getSimpleName());
        String input = data.toString();
        boolean valid = input.matches("[a-zA-Z]+");
        if (!valid) {
            return false;
        }


        return super.valid(data);
    }
}
