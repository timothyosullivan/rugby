package com.rugbystats.core;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Match {

    private @Id Long id;
    private Date date;
    private String homeTeam;
    private String awayTeam;
    private Integer homeScore;
    private Integer awayScore;
    private String competition;
    private String stadium;
    private String city;
    private String country;
    private Boolean neutral;
    private Boolean worldCup;

    public Match() {}

    public Match(Long id, Date date, String homeTeam, String awayTeam, Integer homeScore, Integer awayScore, String competition, String stadium,
                 String city, String country, Boolean neutral, Boolean worldCup) {
        this.id = id;
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore -= awayScore;
        this.competition = competition;
        this.stadium = stadium;
        this.city = city;
        this.country = country;
        this.neutral = neutral;
        this.worldCup = worldCup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Match match = (Match) o;
        return  Objects.equals(id, match.id) &&
                Objects.equals(date, match.date) &&
                Objects.equals(homeTeam, match.homeTeam) &&
                Objects.equals(awayTeam, match.awayTeam) &&
                Objects.equals(homeScore, match.homeScore) &&
                Objects.equals(awayScore, match.awayScore) &&
                Objects.equals(competition, match.competition) &&
                Objects.equals(stadium, match.stadium) &&
                Objects.equals(city, match.city) &&
                Objects.equals(country, match.country) &&
                Objects.equals(neutral, match.neutral) &&
                Objects.equals(worldCup, match.worldCup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, homeTeam, awayTeam, homeScore, awayScore, competition, stadium, city, country, neutral, worldCup);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getNeutral() {
        return neutral;
    }

    public void setNeutral(Boolean neutral) {
        this.neutral = neutral;
    }

    public Boolean getWorldCup() {
        return worldCup;
    }

    public void setWorldCup(Boolean worldCup) {
        this.worldCup = worldCup;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", homeScore='" + homeScore + '\'' +
                ", awayScore='" + awayScore + '\'' +
                ", competition='" + competition + '\'' +
                ", stadium='" + stadium + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", neutral='" + neutral + '\'' +
                ", worldCup='" + worldCup + '\'' +
                '}';
    }
}