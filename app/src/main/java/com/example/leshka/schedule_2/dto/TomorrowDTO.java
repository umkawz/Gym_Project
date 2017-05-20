package com.example.leshka.schedule_2.dto;

/**
 * Created by Leshka on 5/17/2017.
 */

public class TomorrowDTO {

    private String title;
    private String weight;

    public TomorrowDTO(String title, String weight) {

        this.title = title;
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
