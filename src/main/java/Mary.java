import java.util.Scanner;

public class Mary {
    public static void main(String[] args) {
        String hello = "____________________________________________________________ \n"
                + "Hello! I'm Mary \n"
                + "What can I do for you? \n"
                + "____________________________________________________________ \n";

        String bye = "____________________________________________________________ \n"
                + "Bye. Hope to see you again soon! \n"
                + "___________________________________________________________ \n";
        System.out.println(hello);

        String in = new Scanner(System.in).nextLine();
        while (!in.equals("bye")) {
            System.out.println("____________________________________________________________");
            System.out.println(in);
            System.out.println("____________________________________________________________");
            in = new Scanner(System.in).nextLine();
        }

        System.out.println(bye);

    }
}
