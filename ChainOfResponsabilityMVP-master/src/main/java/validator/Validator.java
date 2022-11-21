package validator;

public class Validator {

    private Object data;

    private Validator nextValidator;

    public <T> boolean valid(T data) {
        if (this.nextValidator != null) {
            return this.nextValidator.valid(data);
        }

        return true;
    }

    public void setNextValidator(Validator validator) {
        this.nextValidator = validator;
    }

    public Validator getNextValidator() {
        return nextValidator;
    }

    public <T> boolean dataIsEmpty(T data) {
        return true;
    }

    public boolean hasNextValidator() {
        return this.getNextValidator() != null;
    }
}
