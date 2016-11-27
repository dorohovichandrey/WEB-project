package by.dorohovich.site.logic.runner;


import by.dorohovich.site.logic.parsing.GemsDOMBuilder;
import by.dorohovich.site.logic.parsing.GemsSAXBuilder;
import by.dorohovich.site.logic.parsing.GemsStAXBuilder;

/**
 * Created by User on 18.11.2016.
 */
public class Runner {

    final static String DATA_XML="data/gems.xml";

    public static void main(String[] args) {
        GemsSAXBuilder saxBuilder = new GemsSAXBuilder();
        saxBuilder.buildSetGems(DATA_XML);
        System.out.println(saxBuilder.getGems());
        GemsDOMBuilder domBuilder = new GemsDOMBuilder();
        domBuilder.buildSetGems(DATA_XML);
        System.out.println(domBuilder.getGems());
        GemsStAXBuilder staxBuilder = new GemsStAXBuilder();
        staxBuilder.buildSetGems(DATA_XML);
        System.out.println(staxBuilder.getGems());
    }
}
