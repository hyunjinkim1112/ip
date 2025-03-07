package mary;
import mary.task.Deadline;
import mary.task.Event;
import mary.task.Todo;

public class Parser {
    public static void processCommand(String command, TaskList taskList) throws InvalidCommandException {
        String[] parts = command.split(" ", 2);
//        if (parts.length < 2) {
//            throw new InvalidCommandException("Error: Task description cannot be empty.");
//        }

        switch (parts[0]) {
        case "todo":
            taskList.addTask(new Todo(parts[1], false));
//            taskList.saveTasks();
            break;
        case "deadline":
            taskList.addTask(parseDeadline(parts[1]));
//            taskList.saveTasks();
            break;
        case "event":
            taskList.addTask(parseEvent(parts[1]));
//            taskList.saveTasks();
            break;
        case "remove":
            try {
                taskList.removeTask(Integer.parseInt(parts[1]) - 1);
            } catch (NumberFormatException e) {
                throw new InvalidCommandException("Invalid task index");
            } catch (IndexOutOfBoundsException e) {
                throw new InvalidCommandException("Invalid task index");
            }
//            taskList.saveTasks();
            break;
        case "mark":
            try {
                taskList.markTask(Integer.parseInt(parts[1]) - 1);
            } catch (NumberFormatException e) {
                throw new InvalidCommandException("Invalid task index");
            } catch (IndexOutOfBoundsException e) {
                throw new InvalidCommandException("Invalid task index");
            }
//            taskList.saveTasks();
            break;
        case "unmark":
            try {
                taskList.unmarkTask(Integer.parseInt(parts[1]) - 1);
            } catch (NumberFormatException e) {
                throw new InvalidCommandException("Invalid task index");
            } catch (IndexOutOfBoundsException e) {
                throw new InvalidCommandException("Invalid task index");
            }
//            taskList.saveTasks();
            break;
        case "list":
            taskList.displayTasks();
            break;

        case "find":
            String keyword = parts[1].trim();
            taskList.findTask(keyword);
            break;
        case "bye":
//            taskList.saveTasks();
            break;
        default:
            throw new InvalidCommandException("Invalid command");
        }
    }

    private static Deadline parseDeadline(String details) throws InvalidCommandException{
        String[] parts = details.split(" /by ", 2);
        if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            throw new InvalidCommandException("Deadline format is incorrect. Use: deadline [description] /by [time]");
        }
        return new Deadline(parts[0].trim(), false, parts[1].trim());
    }
    private static Event parseEvent(String details) throws InvalidCommandException{
        String[] parts = details.split(" /from ", 2);
        if (parts.length < 2 || parts[0].trim().isEmpty()) {
            throw new InvalidCommandException("Event format is incorrect. Use: event [description] /from [start] /to [end]");
        }

        String description = parts[0].trim();
        String[] timeParts = parts[1].split(" /to ", 2);

        if (timeParts.length < 2 || timeParts[0].trim().isEmpty() || timeParts[1].trim().isEmpty()) {
            throw new InvalidCommandException("Event format requires both start and end times.");
        }

        return new Event(description, false, timeParts[0].trim(), timeParts[1].trim());
    }


}
