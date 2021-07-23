package com.example.skeleton.services;

import com.example.skeleton.model.Client;
import com.example.skeleton.model.User;
import com.example.skeleton.model.Vendor;
import com.example.skeleton.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository<User, String> repository;

    public UserService(UserRepository<User, String> repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        Iterable<User> items = repository.findAll();
        items.forEach(list::add);
        return list;
    }

    public Optional<User> find(String id) {
        return repository.findById(id);
    }


    public Client create(Client user) {
            Client copy = new Client(
                    user.getId(),
                    user.getFirstName(),
                    user.getMiddleName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getPicture(),
                    user.getAddress(),
                    user.getType(),
                    user.getClientType()
            );
            return repository.save(copy);

    }
        public Vendor create(Vendor user) {
            Vendor copy = new Vendor(
                    user.getId(),
                    user.getFirstName(),
                    user.getMiddleName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getPicture(),
                    user.getAddress(),
                    user.getType(),
                    user.getLicenseList(),
                    user.getInsuranceList(),
                    user.getTradeList(),
                    user.getCompanyName(),
                    user.getPromoCode(),
                    user.getTosAccepted(),
                    user.getPayoutEnabled(),
                    user.getStripeId(),
                    user.getQbId()
            );
            return repository.save(copy);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
