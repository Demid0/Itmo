package system.myExceptions;

public class BadWords extends RuntimeException {
    @Override
    public String getMessage() {
        return "BAD_WORDS_EXCEPTION: Bad Words in String";
    }
}
