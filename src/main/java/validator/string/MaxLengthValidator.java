package validator.string;

import validator.Validator;

public class MaxLengthValidator extends Validator {

    private final int maxLength;

    public MaxLengthValidator(int length) {
        this.maxLength = length;
    }

    @Override
    public <T> boolean valid(T data) {
        System.out.println("init " + this.getClass().getSimpleName());
        String input = data.toString();
        if (input.length() > this.maxLength) {
            return false;
        }
        return super.valid(data);
    }

}
