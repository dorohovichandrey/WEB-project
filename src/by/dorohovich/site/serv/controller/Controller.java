package by.dorohovich.site.serv.controller;

import by.dorohovich.site.logic.entity.Gem;
import by.dorohovich.site.logic.entity.PreciousGem;
import by.dorohovich.site.logic.parsing.GemsSAXBuilder;
import by.dorohovich.site.resource.ConfigurationManager;
import by.dorohovich.site.serv.command.ActionCommand;
import by.dorohovich.site.serv.command.ActionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@WebServlet("/controller")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*String res = request.getParameter("parsType");
        request.setAttribute("res", res);

        String path="D:\\3kurs\\EpamTraining\\untitled1\\data\\gems.xml";
        GemsSAXBuilder saxBuilder = new GemsSAXBuilder();
        saxBuilder.buildSetGems(path);
        Set<Gem> gems=saxBuilder.getGems();
        Set<Gem> prGems=new HashSet<Gem>();
        Set<Gem> semiprGems=new HashSet<Gem>();

        for(Gem elem : gems)
        {
            if(elem instanceof PreciousGem)
            {
                prGems.add(elem);
            }
            else
            {
                semiprGems.add(elem);
            }
        }
        request.setAttribute("prGems", prGems);
        request.setAttribute("semiprGems", semiprGems);
        request.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(request, response);*/

        String page = null;
// определение команды, пришедшей из JSP
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
/*
* вызов реализованного метода execute() и передача параметров
* классу-обработчику конкретной команды
 */
        page = command.execute(request);
// метод возвращает страницу ответа
// page = null; // поэксперементировать!
        if (page != null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
// вызов страницы ответа на запрос
            dispatcher.forward(request, response);
        } else {
// установка страницы c cообщением об ошибке
            page = ConfigurationManager.getProperty("path.page.index");
            /*request.getSession().setAttribute("nullPage",
                    MessageManager.getProperty("message.nullpage"));*/
            response.sendRedirect(request.getContextPath() + page);
        }

    }
}
