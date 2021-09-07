package com.tg.marketingpreferences.dto;

import javax.validation.constraints.NotNull;

public class PostDto {

    @NotNull
    private String title;

    @NotNull
    private String description;

    private Long Id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
