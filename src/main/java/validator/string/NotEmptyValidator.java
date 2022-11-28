package validator.string;

import validator.Validator;

public class NotEmptyValidator extends Validator {

    @Override
    public <T> boolean valid(T data) {
        System.out.println("init " + this.getClass().getSimpleName());
        if (data == null) return false;
        String input = data.toString();
        if ("".equals(input.trim())) {
            return false;
        }

        return super.valid(data);
    }
}
