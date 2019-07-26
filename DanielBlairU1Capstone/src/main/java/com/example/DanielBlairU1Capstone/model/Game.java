package com.example.DanielBlairU1Capstone.model;

import java.util.Objects;

public class Game extends Item {

    private String title;
    private String esrb_rating;
    private String description;
    private String studio;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrb_rating() {
        return esrb_rating;
    }

    public void setEsrb_rating(String esrb_rating) {
        this.esrb_rating = esrb_rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Game game = (Game) o;
        return getTitle().equals(game.getTitle()) &&
                getEsrb_rating().equals(game.getEsrb_rating()) &&
                getDescription().equals(game.getDescription()) &&
                getStudio().equals(game.getStudio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTitle(), getEsrb_rating(), getDescription(), getStudio());
    }
}