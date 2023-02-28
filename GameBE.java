import java.util.Scanner;
import java.io.*;


public class GameBE
{
    //set up some constants
    public static final String DELIM = "\t";
    private GENLL<Game> allGames;
    private GENLL<Game> results;

    public GameBE()
    {
        allGames = new GENLL<Game>();
    }

    public void readGameProfile(String fileName)//to the whole list
    {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine()) {
                String fileLine = fileScanner.nextLine();
                String[] splitLines = fileLine.split(DELIM);
                if (splitLines.length == 2) {
                    String Name = splitLines[0];
                    String Console = splitLines[1];
                    Game newVG = new Game(Name, Console);
                    allGames.add(newVG);
                }
            }
            fileScanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public GENLL<Game> SearchGame(String aName, String aConsole)
    {
        /*String name = scanner.next();
        String console = keyboard.nextLine;
         */
        results = new GENLL<Game>();
        int counter = 0;
        allGames.reset();// go to the start of the list
        int size = allGames.getSize();
        for (int i = 0; i <= size; i++) {
            Game games = allGames.getCurrent();
            String name = games.getName().toLowerCase();
            String console = games.getConsole().toLowerCase();

            if ((name.equals("*") || games.getName().toLowerCase().contains(name.toLowerCase()))
                    && (console.equals("*") || games.getConsole().toLowerCase().contains(console.toLowerCase()))) {
                results.add(games);
                counter++;
            }
            allGames.gotoNext();

        }
        //if the counter was 0 then the list would not have been populated
        if(counter != 0)
            return results;
        else
            return null;

    }

    public void printresults()
    {
        results.reset();
        int size = results.getSize();
        for(int i=0; i<= size; i++)
        {
            Game games = results.getCurrent();
            System.out.println(games.getName()+DELIM+games.getConsole());
            results.gotoNext();
        }
    }

    public void writeFile(String fileName, boolean append)
    {
        try
        {
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName, append));
            results.reset();
            int size = results.getSize();

            for(int i=0; i<= size; i++)
            {
                Game games = results.getCurrent();
                fileWriter.println(games.getName()+DELIM+ games.getConsole());
                results.gotoNext();
            }
            fileWriter.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

