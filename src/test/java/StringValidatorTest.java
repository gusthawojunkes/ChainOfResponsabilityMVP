import org.junit.Assert;
import org.junit.Test;
import utils.ValidatorChainBuilder;
import validator.string.MaxLengthValidator;
import validator.string.MinLengthValidator;
import validator.string.NotEmptyValidator;
import validator.string.OnlyLettersValidator;

public class StringValidatorTest {

    @Test
    public void isOnlyLetters() {
        String input = "Gusthawo";
        ValidatorChainBuilder builder = new ValidatorChainBuilder();
        boolean valid = builder.add(new OnlyLettersValidator()).getFirst().valid(input);

        Assert.assertTrue(valid);
    }

    @Test
    public void nullHasNoLength() {
        String input = null;
        int inputMinLength = 10;
        ValidatorChainBuilder builder = new ValidatorChainBuilder();
        boolean valid = builder.add(new NotEmptyValidator()).add(new MinLengthValidator(inputMinLength)).getFirst().valid(input);

        Assert.assertFalse(valid);
    }

    @Test
    public void inputIsEmpty() {
        String input = null;
        ValidatorChainBuilder builder = new ValidatorChainBuilder();
        boolean valid = builder.add(new NotEmptyValidator()).getFirst().valid(input);

        Assert.assertFalse(valid);
    }

    @Test
    public void inputIsNotEmpty() {
        String input = "My input";
        ValidatorChainBuilder builder = new ValidatorChainBuilder();
        boolean valid = builder.add(new NotEmptyValidator()).getFirst().valid(input);

        Assert.assertTrue(valid);
    }

    @Test
    public void hasMinLength() {
        String input = "My input has min length";
        int inputMinLength = 10;
        ValidatorChainBuilder builder = new ValidatorChainBuilder();
        boolean valid = builder.add(new NotEmptyValidator()).add(new MinLengthValidator(inputMinLength)).getFirst().valid(input);

        Assert.assertTrue(valid);
    }

    @Test
    public void hasMaxLengthOrLess() {
        String input = "Size is 10";
        int inputMaxLength = 10;
        ValidatorChainBuilder builder = new ValidatorChainBuilder();
        boolean valid = builder.add(new NotEmptyValidator()).add(new MaxLengthValidator(inputMaxLength)).getFirst().valid(input);

        Assert.assertTrue(valid);
    }

    @Test
    public void hasNoMinLength() {
        String input = "Sa";
        int inputMinLength = 4;
        ValidatorChainBuilder builder = new ValidatorChainBuilder();
        boolean valid = builder.add(new NotEmptyValidator()).add(new MinLengthValidator(inputMinLength)).getFirst().valid(input);

        Assert.assertFalse(valid);
    }

    @Test
    public void hasMoreThanMaxLength() {
        String input = "Size is 101";
        int inputMaxLength = 10;
        ValidatorChainBuilder builder = new ValidatorChainBuilder();
        boolean valid = builder.add(new NotEmptyValidator()).add(new MaxLengthValidator(inputMaxLength)).getFirst().valid(input);

        Assert.assertFalse(valid);
    }

}
