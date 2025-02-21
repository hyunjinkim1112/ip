package mary;

public class InvalidCommandException extends Exception {
    public InvalidCommandException(String message) {
        super(message);
    }
//
//    public static InvalidCommandException invalidCommand(String command) {
//        return new InvalidCommandException("Invalid command: " + command);
//    }
//
//    public static InvalidCommandException emptyDescription() {
//        return new InvalidCommandException("Your description is empty");
//    }
//
//    public static InvalidCommandException InvalidCommandException(String message) {
//        return new InvalidCommandException(message);
//    }
////
//    public static MaryException missingKeyword(String keyword) {
//        return new MaryException("Missing keyword: \"" + keyword + "\"");
//    }
}
