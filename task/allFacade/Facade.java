package ua.foxminded.task6.allFacade;

import java.io.IOException;

import java.util.List;

import ua.foxminded.task6.allFormatter.Formatter;
import ua.foxminded.task6.allParser.Parser;
import ua.foxminded.task6.allReader.Reader;

public class Facade {
    private Reader reader;
    private Parser parser;
    private Formatter formatter;

    public Facade(Reader reader, Parser parser, Formatter formatter) {
        this.reader = reader;
        this.parser = parser;
        this.formatter = formatter;
    }

    public String createList(String start, String end, String abbreviations) throws IOException  {
       List startList =reader.readFile(start);
       List endList =reader.readFile(end);
       List abbreviationsList =reader.readFile(abbreviations);
       String result = formatter.format(parser.createListRacers(startList,endList,abbreviationsList));
       return result;
    }
    


}
