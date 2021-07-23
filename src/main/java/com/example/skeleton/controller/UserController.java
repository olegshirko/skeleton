package com.example.skeleton.controller;

import com.example.skeleton.model.Client;
import com.example.skeleton.model.User;
import com.example.skeleton.model.Vendor;
import com.example.skeleton.repository.UserRepository;
import com.example.skeleton.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository<User, UUID> repository;

    public UserController(UserService userService, UserRepository<User, UUID> repository) {
        this.userService = userService;
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> items = userService.findAll();
        return ResponseEntity.ok().body(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> find(@PathVariable("id") UUID id) {
        Optional<User> item = userService.find(id);
        return ResponseEntity.of(item);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User copyUser = null;

        if (user.getType().equals("Client"))
            copyUser = userService.create((Client) user);

        if (user.getType().equals("Vendor"))
            copyUser = userService.create((Vendor) user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).body(copyUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(
            @PathVariable("id") UUID id,
            @RequestBody User updatedUser) {

        Optional<User> updated = Optional.of(repository.save(updatedUser));

        return updated
                .map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> {
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(updatedUser.getId())
                            .toUri();
                    return ResponseEntity.created(location).body(updatedUser);
                });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
