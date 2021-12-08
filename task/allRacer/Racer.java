package ua.foxminded.task6.allRacer;

import java.time.Duration;
import java.util.Comparator;
import java.util.Objects;

public class Racer {
    private String abbreviation;
    private String name;
    private String team;
    private Duration time;

    public Racer() {
    }

    public Racer(String abbreviation, String name, String team, Duration time) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.team = team;
        this.time = time;

    }
    
    

    @Override
    public int hashCode() {
        return Objects.hash(abbreviation, name, team, time);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Racer other = (Racer) obj;
        return Objects.equals(abbreviation, other.abbreviation) && Objects.equals(name, other.name)
                && Objects.equals(team, other.team) && Objects.equals(time, other.time);
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }

}
