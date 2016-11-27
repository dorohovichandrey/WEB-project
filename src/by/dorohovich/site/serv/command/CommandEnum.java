package by.dorohovich.site.serv.command;

/**
 * Created by User on 26.11.2016.
 */
public enum CommandEnum {
    PARSING{
        {
            this.command = new ParsingCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
