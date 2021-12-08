package ua.foxminded.task6.allFormatter;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

import ua.foxminded.task6.allRacer.Racer;

public class Formatter {
    private final String SEPARATOR = "|";
    private final String EMPTY = " ";
    private final String PARAGRAPH = "\n";

    public String format(List<Racer> createListRacers) {
        StringBuilder finalString = new StringBuilder();
        List<Racer> createList = createListRacers;

        for (int i = 0; i < createList.size(); i++) {

            int number = i + 1;
            finalString.append(String.format("%02d.", number));
            finalString.append(countDuration(createList.get(i)));
            if (i == 14) {
                finalString.append(PARAGRAPH);
                finalString.append(addRetreat(countDuration(createList.get(1))));

            }
            finalString.append(PARAGRAPH);
        }

        return finalString.toString();
    }

    private StringBuilder addRetreat(StringBuilder countDuration) {
        StringBuilder retreat = new StringBuilder();
        for (int i = 0; i < countDuration.length(); i++) {
            retreat.append("-");
        }
        return retreat;
    }

    private StringBuilder countDuration(Racer racer) {
        StringBuilder finalString = new StringBuilder();
        finalString.append(String.format("%-20s%s%s", racer.getName(), EMPTY, SEPARATOR));
        finalString.append(String.format("%-26s%s%s", racer.getTeam(), EMPTY, SEPARATOR));
        finalString.append(formatteeTime(racer.getTime()));
        return finalString;

    }

    private String formatteeTime(Duration duration) {
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        long millis = duration.toMillis();
        String timeLap = String.format("%d:%02d.%03d", (absSeconds % 3600) / 60, absSeconds % 60, millis % 1000);
        return timeLap;
    }

}
