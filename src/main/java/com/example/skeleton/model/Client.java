package com.example.skeleton.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "user")
@TypeAlias("client")
@Getter
public class Client extends User{
    List<ClientType> clientType;

    @Builder
    public Client(UUID id, String firstName, String middleName, String lastName, List<Email> email, Number phone, String picture, Address address, String type, List<ClientType> clientType) {
        super(id, firstName, middleName, lastName, email, phone, picture, address, type);
        this.clientType = clientType;
    }
}
