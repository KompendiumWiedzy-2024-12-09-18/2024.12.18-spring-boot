package com.comarch.szkolenia.spring.boot.dao;

import com.comarch.szkolenia.spring.boot.model.User;

import java.util.List;

public interface IUserDAO {
    void insert(User user);
    List<User> getAll();
    void delete(int id);
    void update(User user);
}
