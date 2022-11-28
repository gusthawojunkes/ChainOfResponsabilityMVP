package utils;

import validator.Validator;

public class ValidatorChainBuilder {
    private Validator first;
    private Validator last;

    public ValidatorChainBuilder() {
        this.first = null;
        this.last = null;
    }

    public <T extends Validator> ValidatorChainBuilder add(Validator validator) {
        if (this.first == null) {
            this.first = validator;
            this.last = validator;
            return this;
        }
        this.last.setNextValidator(validator);
        this.last = validator;
        return this;
    }

    public Validator getFirst() {
        return first;
    }

    public Validator getLast() {
        return last;
    }
}
