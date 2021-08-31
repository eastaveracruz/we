package com.wew;

import com.wew.lib.WordsGenerator;
import com.wew.lib.WordsRepository;
import com.wew.model.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Controller
public class WewController {

    @Autowired
    private WordsGenerator wordsGenerator;

    @Autowired
    private WordsRepository wordsRepository;

    @GetMapping("/generator")
    public String generator(Model model) {
        model.addAttribute("params", new Params());
        return "we";
    }

    @PostMapping("/generator")
    public String generatorPost(@ModelAttribute("params") Params params, Model model) {

        String[] split = params.getLetters().trim().split("");
        List<String> strings = Arrays.asList(split);
        Set<String> generate = wordsGenerator.generate(strings);
        List<String> words = wordsRepository.getWords();

        generate.removeIf(s -> !words.contains(s));

        model.addAttribute("params", params);
        model.addAttribute("words", generate);
        return "we";
    }

}
