package com.gmail.morovo1988.Service;

import com.gmail.morovo1988.DAO.UserRepository;
import com.gmail.morovo1988.DAO.UserService;
import com.gmail.morovo1988.Entity.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional(readOnly = true)
    public CustomUser getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    @Transactional
    public void addUser(CustomUser customUser) {
        userRepository.save(customUser);
    }

    @Override
    @Transactional
    public void updateUser(CustomUser customUser) {
        userRepository.save(customUser);
    }
    @Override
    @Transactional(readOnly=true)
    public List<CustomUser> findAll(Pageable pageable) { return userRepository.findAll(pageable).getContent();  }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return userRepository.count();
    }


}
