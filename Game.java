public class Game
{
    private String Name;
    private String Console;

    public Game()
    {
        this.Name= this.Console = "none";
    }
    public Game(String aName, String aConsole)
    {
        this.setName(aName);
        this.setConsole(aConsole);
    }
    public String getName()
    {
        return this.Name;
    }
    public String getConsole()
    {
        return this.Console;
    }
    public void setName(String aName)
    {
        if(aName!= null)
            this.Name = aName;
        else this.Name = "none";
    }
    public void setConsole(String aConsole)
    {
        if(aConsole!= null)
            this.Console = aConsole;
        else this.Console = "none";
    }
}

