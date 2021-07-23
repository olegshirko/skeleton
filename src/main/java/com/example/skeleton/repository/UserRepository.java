package com.example.skeleton.repository;

import com.example.skeleton.model.User;
import com.example.skeleton.model.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository<V extends User, U> extends CrudRepository<User, UUID> {
    public Vendor findByFirstName(String firstName);

    public List<Vendor> findByLastName(String lastName);

    public Optional<Vendor> findById();
}
