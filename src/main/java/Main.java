import utils.ValidatorChainBuilder;
import validator.string.MaxLengthValidator;
import validator.string.MinLengthValidator;
import validator.string.NotEmptyValidator;
import validator.string.OnlyLettersValidator;

public class Main {
    public static void main(String[] args) {
        ValidatorChainBuilder builder = new ValidatorChainBuilder();
        boolean valid = builder.add(new NotEmptyValidator())
                               .add(new OnlyLettersValidator())
                               .add(new MinLengthValidator(4))
                               .add(new MaxLengthValidator(20))
                               .getFirst().valid("Gusthawo");
        System.out.println("Valid? " + valid);
    }
}
