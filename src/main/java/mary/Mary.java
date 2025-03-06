package mary;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mary {
    private Storage storage;
    private Scanner scanner;
    private TaskList taskList;
    private Ui ui;
    private Parser parser;

    public Mary(String filepath) {
        ui = new Ui();
        storage = new Storage(filepath);
        scanner = new Scanner(System.in);
        try {
            taskList = new TaskList(storage.loadFromFile());
        } catch (FileNotFoundException e) {
            ui.showLoadingError();
        }
    }

    public void run() {
        ui.printHello();
        while (true) {
            System.out.println("Enter command: ");
            String command = scanner.nextLine();
            try {
                parser.processCommand(command, taskList);
                if (command.equals("bye")) {
                    break;
                }
            } catch (InvalidCommandException e) {
                ui.printError(e.getMessage());
            }
        }
        storage.saveToFile(taskList.getTasks());
    }
    public static void main(String[] args) {
        new Mary("./data/mary.txt").run();
    }

}
