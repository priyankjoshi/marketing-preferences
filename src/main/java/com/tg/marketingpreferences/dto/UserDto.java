package com.tg.marketingpreferences.dto;

public class UserDto {

    private long id;

    private String name;

    public UserDto() {
    }

    public UserDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
