package exceptions;

public class ThrowingException {
    public static void func() {
        throw new RuntimeException("This is exception message");
    }
    public static void isThatSupra() {
        throw new SupraException("No it's z4");
    }
}
