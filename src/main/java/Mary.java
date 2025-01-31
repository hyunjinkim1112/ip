import java.util.Scanner;

public class Mary {

    public static final int MAX_COMMANDS = 100;
    public static final String LINE_SEPARATOR = "____________________________________________________________ ";

    public static void main(String[] args) {
        String hello = LINE_SEPARATOR + "\n"
                + "Hello! I'm Mary \n"
                + "What can I do for you? \n"
                + LINE_SEPARATOR + "\n";

        String bye = LINE_SEPARATOR + "\n"
                + "Bye. Hope to see you again soon! \n"
                + LINE_SEPARATOR + "\n";
        
        String[] commandList = new String[MAX_COMMANDS];
        int numCommands = 0;
        String command;
        System.out.println(hello);
        
        while (true) {
            command = new Scanner(System.in).nextLine();
            switch (command) {
            case "list":
                System.out.println(LINE_SEPARATOR + "\n");
                for (int i = 0; i < numCommands; i++) {
                    System.out.println((i + 1) + ". " + commandList[i]);
                }
                System.out.println(LINE_SEPARATOR + "\n");
                continue;
            case "bye":
                System.out.println(bye);
                return;
            default:
                commandList[numCommands] = command;
                numCommands++;
                System.out.println(LINE_SEPARATOR + "\n"
                        + "added: " + command + "\n"
                        + LINE_SEPARATOR + "\n");
                continue;
            }
        }
    }
}




//        while (!in.equals("bye")) {
//            commands[listItems] = in;
//            listItems++;
//            System.out.println("____________________________________________________________");
//            System.out.println(in);
//            System.out.println("____________________________________________________________");
//            in = new Scanner(System.in).nextLine();
//        }
//
//        System.out.println(bye);

