package by.dorohovich.site.serv.command;

import by.dorohovich.site.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by User on 26.11.2016.
 */
public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        return page;
    }
}
