package com.wew.lib;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class WordsGenerator {

    public Set<String> generate(List<String> letters) {
        Set<String> combinations = new HashSet<>();
        recurseGenerator(combinations, new ArrayList<>(letters), "");
        return combinations;
    }

    private void recurseGenerator(Set<String> combinations, List<String> letters, String data) {
        if (letters.size() == 1) {
            combinations.add(data + letters.get(0));
        } else {
            for (String c : letters) {
                combinations.add(data + c);
                ArrayList<String> lett = new ArrayList<>(letters);
                lett.remove(c);
                recurseGenerator(combinations, lett, data + c);
            }
        }
    }

}
