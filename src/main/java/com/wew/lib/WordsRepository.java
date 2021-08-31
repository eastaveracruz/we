package com.wew.lib;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Component
public class WordsRepository {

    private List<String> words;

    public WordsRepository() throws IOException {
        words = readAllWords();
    }

    private List<String> readAllWords() throws IOException {
//        File file = ResourceUtils.getFile("classpath:RUS.txt");
        File file = ResourceUtils.getFile("classpath:singular_and_plural.txt");
        return Files.readAllLines(file.toPath());
    }

    public List<String> getWords() {
        return words;
    }
}
