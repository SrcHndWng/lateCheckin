package com.latecheckin;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import com.ibm.icu.text.Transliterator;

public class Utils {
    public static String transferToRomaji(String str){
        Transliterator trH2L = Transliterator.getInstance("Katakana-Latin");
        Tokenizer tokenizer = new Tokenizer();
        StringBuilder results = new StringBuilder();
        for (Token token : tokenizer.tokenize(str)) {
            String s = trH2L.transliterate(token.getReading());
            String s2 = s.substring(0, 1).toUpperCase() + s.substring(1);
            results.append(s2);
        }
        return results.toString();
    }
}
