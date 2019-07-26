package com.example.DanielBlairU1Capstone.viewModel;

import javax.validation.constraints.*;
import java.util.Objects;

public class GameViewModel extends ItemViewModel {

    @NotNull(message = "Missing property: title")
    @NotEmpty(message = "Please supply a value for Title")
    private String title;
    @NotNull(message = "Missing property: esrb_rating")
    @NotEmpty(message = "Please supply a value for ESRB Rating")
    private String esrb_rating;
    @NotNull(message = "Missing property: description")
    @NotEmpty(message = "Please supply a value for Description")
    private String description;
    @NotNull(message = "Missing property: studio")
    @NotEmpty(message = "Please supply a value for Studio")
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
        GameViewModel that = (GameViewModel) o;
        return getTitle().equals(that.getTitle()) &&
                getEsrb_rating().equals(that.getEsrb_rating()) &&
                getDescription().equals(that.getDescription()) &&
                getStudio().equals(that.getStudio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTitle(), getEsrb_rating(), getDescription(), getStudio());
    }
}