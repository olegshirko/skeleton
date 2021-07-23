package com.example.skeleton.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Email {
    private UUID id;
    private String Name;
    private String Description;
    private EmailType emailType;
    private String email;

}
