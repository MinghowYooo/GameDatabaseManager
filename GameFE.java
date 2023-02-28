import java.util.Scanner;

public class GameFE
{

    private static Scanner keyboard = new Scanner(System.in);
    private static GameBE qwe = new GameBE();
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        boolean quit = false;

        while(!quit)
        {
            printChoice();
            int choice = keyboard.nextInt();
            switch (choice)
            {
                case 1:
                    loadData();
                    break;

                case 2:
                    searchData();
                    break;
                case 3:
                    qwe.printresults();
                case 4:
                    printDatatoFile();
                case 9:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid Input");


            }
        }
        //String fileName = scanner.next();


    }

    public static void printChoice()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to load the video game database\n"
                + "Enter 2 to search the database\n"
                + "Enter 3 to print current results\n"
                + "Enter 4 to print current results to file\n"
                + "Enter 9 to quit");

    }
    public static void loadData()
    {
        System.out.println("Enter the filename");
        String fileName= keyboard.nextLine();
        qwe.readGameProfile(fileName);
    }

    public static void searchData()
    {
        GENLL<Game>results;
        System.out.println("Enter the name of the game or '*' for all names");
        String game = keyboard.nextLine();
        System.out.println("Enter the name of the console or '*' for all consoles");
        String console = keyboard.nextLine();

        results = qwe.SearchGame(game, console);
        //only print the results if there are matches
        if(results != null)
            qwe.printresults();
        else
            System.out.println("No "+game+" games found for "+console+" console");
    }

    public static void printDatatoFile()
    {
        System.out.println("Enter the file name to print out.");
        String fileName = keyboard.nextLine();
        System.out.println("Append to file? True or false.");
        String append = keyboard.nextLine();
        if(append.equalsIgnoreCase("true"))
            qwe.writeFile(fileName, true);
        else if(append.equalsIgnoreCase("false"))
            qwe.writeFile(fileName, false);
        else
            System.out.println("Invalid Input");
    }

}

