package validator.string.regex;

import validator.Validator;

public class RegexValidator extends Validator {

    private String regex;

    public RegexValidator(String regex) {
        this.regex = regex;
    }

    @Override
    public <T> boolean valid(T data) {

        return super.valid(data);
    }

}
