package org.ifnmg.printplus.api.util;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class WordGenerator {
    
    private List<Character> alphabet;
    private Random generator;

    public WordGenerator() {
        alphabet = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 
                                'H', 'I', 'J', 'K', 'L', 'M', 'N', 
                                    'O', 'P', 'Q', 'R', 'S', 'T', 'U', 
                                        'V', 'W', 'X', 'Y', 'Z');
        generator = new Random();
    }

    public String generate(Integer size) {
        String word = "";
        for(int i = size; i > 0; --i) {
            int cIndex = generator.nextInt(alphabet.size() - 1);
            Character c = alphabet.get(cIndex);
            word+=c;
        }
        return word;
    }

}
