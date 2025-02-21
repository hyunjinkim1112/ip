package mary;
import mary.task.Deadline;
import mary.task.Event;
import mary.task.Todo;

public class Parser {
    public static void processCommand(String command, TaskManager taskManager) throws InvalidCommandException {
        String[] parts = command.split(" ", 2);
//        if (parts.length < 2) {
//            throw new InvalidCommandException("Error: Task description cannot be empty.");
//        }

        switch (parts[0]) {
        case "todo":
            taskManager.addTask(new Todo(parts[1], false));
            taskManager.saveTasks();
            break;
        case "deadline":
            taskManager.addTask(parseDeadline(parts[1]));
            taskManager.saveTasks();
            break;
        case "event":
            taskManager.addTask(parseEvent(parts[1]));
            taskManager.saveTasks();
            break;
        case "remove":
            try {
                taskManager.removeTask(Integer.parseInt(parts[1]) - 1);
            } catch (NumberFormatException e) {
                throw new InvalidCommandException("Invalid task index");
            } catch (IndexOutOfBoundsException e) {
                throw new InvalidCommandException("Invalid task index");
            }
            taskManager.saveTasks();
            break;
        case "mark":
            try {
                taskManager.markTask(Integer.parseInt(parts[1]) - 1);
            } catch (NumberFormatException e) {
                throw new InvalidCommandException("Invalid task index");
            } catch (IndexOutOfBoundsException e) {
                throw new InvalidCommandException("Invalid task index");
            }
            taskManager.saveTasks();
            break;
        case "unmark":
            try {
                taskManager.unmarkTask(Integer.parseInt(parts[1]) - 1);
            } catch (NumberFormatException e) {
                throw new InvalidCommandException("Invalid task index");
            } catch (IndexOutOfBoundsException e) {
                throw new InvalidCommandException("Invalid task index");
            }
            taskManager.saveTasks();
            break;
        case "list":
            taskManager.displayTasks();
            break;
        case "bye":
            taskManager.saveTasks();
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
