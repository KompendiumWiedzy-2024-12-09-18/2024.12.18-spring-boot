package com.comarch.szkolenia.spring.boot.services;

import com.comarch.szkolenia.spring.boot.dao.IUserDAO;
import com.comarch.szkolenia.spring.boot.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class NamesService implements INamesService {

    private final IUserDAO userDAO;

    @Override
    public String getRandomName() {
        List<User> users = this.userDAO.getAll();
        return users.get(new Random().nextInt(users.size())).getName();
    }

    @Override
    public List<String> getAllNames() {
        return this.userDAO.getAll().stream().map(User::getName).toList();
    }
}
