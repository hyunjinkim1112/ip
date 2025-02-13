package mary;

public class MaryException extends Exception {
    public MaryException(String message) {
        super(message);
    }

    public static MaryException invalidCommand(String command) {
        return new MaryException("Invalid command: " + command);
    }

    public static MaryException emptyDescription() {
        return new MaryException("Your description is empty");
    }

    public static MaryException invalidDescription(String message) {
        return new MaryException(message);
    }
//
//    public static MaryException missingKeyword(String keyword) {
//        return new MaryException("Missing keyword: \"" + keyword + "\"");
//    }
}
