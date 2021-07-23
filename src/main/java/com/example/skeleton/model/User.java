package com.example.skeleton.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "User")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Vendor.class, name = "Vendor"),
        @JsonSubTypes.Type(value = Client.class, name = "Client")
})
@JsonTypeIdResolver(UserResolver.class)
public abstract class User {
    @Id
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private List<Email> email;
    private Number phone;
    private String picture;
    private Address address;
    private String type;
}
