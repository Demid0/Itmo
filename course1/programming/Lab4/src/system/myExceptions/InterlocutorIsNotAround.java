package system.myExceptions;

public class InterlocutorIsNotAround extends Exception {
    public String getMessage(String s1, String s2) {
        return "INTERLOCUTOR_IS_NOT_AROUND: " + s1 + " и " + s2 + " находятся в разных местах";
    }
}
