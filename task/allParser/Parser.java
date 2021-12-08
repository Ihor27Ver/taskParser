package ua.foxminded.task6.allParser;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Comparator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ua.foxminded.task6.allRacer.Racer;

public class Parser {

    private final String SEPARATOR = "_";
    private final String EMPTY = " ";
    private final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private final int TIME_ADDREVIATION_INDEX = 3;

    public List<Racer> createListRacers(List startList, List endList, List abbreviationsList) {
        List<String> start = startList;
        List<String> end = endList;
        List<String> abbreviations = abbreviationsList;

        List<String> startSplit = start.stream().map(name -> name.substring(TIME_ADDREVIATION_INDEX))
                .map(name -> name.replaceAll(SEPARATOR, EMPTY)).collect(Collectors.toList());

        List<String> endSplit = end.stream().map(name -> name.substring(TIME_ADDREVIATION_INDEX))
                .map(name -> name.replaceAll(SEPARATOR, EMPTY)).collect(Collectors.toList());

        Map<String, Duration> bestTime = new LinkedHashMap<>();

        for (int i = 0; i < startSplit.size(); i++) {
            bestTime.put(countDuration(abbreviations.get(i)), countTime(startSplit.get(i), endSplit.get(i)));
        }

        List<Racer> listRacers = abbreviations.stream().map(line -> line.split("_"))
                .map(line -> new Racer(line[0], line[1], line[2], bestTime.get(line[0]))).collect(Collectors.toList());

        listRacers.sort(Comparator.comparing(o -> o.getTime()));

        return listRacers;
    }

    private String countDuration(String abbreviation) {
        String[] abbreviations = abbreviation.split(SEPARATOR);
        String abbreviationRacer = abbreviations[0];
        return abbreviationRacer;
    }

    private Duration countTime(String start, String end) {
        LocalDateTime startTime = LocalDateTime.parse(start, TIME_FORMAT);
        LocalDateTime endTime = LocalDateTime.parse(end, TIME_FORMAT);
        Duration duration = Duration.between(startTime, endTime);
        return duration;
    }

}
