package com.exam.dto;

import com.exam.model.Room;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ContractDto {

    @NotBlank
    private String codeContract;

    @NotNull
    private Room room;

    @Size(min = 1, max = 45, message = "name incorrect regex")
    private String name;

    @Size(min = 9, max = 9, message = "id incorrect regex")
    private String idCard;

    @NotBlank
    private String dateDoContract;

    @NotBlank
    private String timeForRent;

    public ContractDto() {
    }

    public ContractDto(String codeContract, Room room, String name, String idCard, String dateDoContract, String timeForRent) {
        this.codeContract = codeContract;
        this.room = room;
        this.name = name;
        this.idCard = idCard;
        this.dateDoContract = dateDoContract;
        this.timeForRent = timeForRent;
    }

    public String getCodeContract() {
        return codeContract;
    }

    public void setCodeContract(String codeContract) {
        this.codeContract = codeContract;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDateDoContract() {
        return dateDoContract;
    }

    public void setDateDoContract(String dateDoContract) {
        this.dateDoContract = dateDoContract;
    }

    public String getTimeForRent() {
        return timeForRent;
    }

    public void setTimeForRent(String timeForRent) {
        this.timeForRent = timeForRent;
    }
}
