package com.example.leshka.schedule_2.dto;

/**
 * Created by Leshka on 5/17/2017.
 */

public class TodayDTO {

    private String title;
    private String weight;

    public TodayDTO(String title) {
        this.title = title;
    }

    public TodayDTO(String title, String weight) {
        this.title = title;
        this.weight = weight;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWeight() {
        return weight;
    }
}
