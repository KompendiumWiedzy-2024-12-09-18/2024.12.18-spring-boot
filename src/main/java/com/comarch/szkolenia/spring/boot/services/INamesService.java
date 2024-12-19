package com.comarch.szkolenia.spring.boot.services;

import java.util.List;

public interface INamesService {
    String getRandomName();
    List<String> getAllNames();
}
