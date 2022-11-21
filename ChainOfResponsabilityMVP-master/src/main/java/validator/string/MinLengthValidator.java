package validator.string;

import validator.Validator;

public class MinLengthValidator extends Validator {

    private final int minLength;

    public MinLengthValidator(int length) {
        this.minLength = length;
    }

    @Override
    public <T> boolean valid(T data) {
        System.out.println("init " + this.getClass().getSimpleName());
        String input = data.toString();
        if (input.length() < this.minLength) {
            return false;
        }
        return super.valid(data);
    }

}
