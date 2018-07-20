package com.gmail.morovo1988.DAO;

import com.gmail.morovo1988.Entity.CustomUser;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    CustomUser getUserByLogin(String login);
    boolean existsByLogin(String login);
    void addUser(CustomUser customUser);
    void updateUser(CustomUser customUser);
    List<CustomUser> findAll(Pageable pageable);
    long count();
}
