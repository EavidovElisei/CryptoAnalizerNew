package src.Service;

import src.Model.BruteForceModel;
import src.Consts.Consts;
import src.Model.CryptoModel;

import java.io.IOException;
import java.util.*;

public class SolutionService {

    NewFileService newFileService = new NewFileService();
    CryptoService cryptoService = new CryptoService();


    public void cryptSolution(CryptoModel model) throws IOException {
        String text = newFileService.readFromFile(model.getPathFrom());
        char[] myCharArray = text.toLowerCase().toCharArray();
        cryptoService.crypt(myCharArray, model.getKey());
        String stringToFile = String.copyValueOf(myCharArray);
        newFileService.writeToFile(stringToFile, model.getPathTo());
    }

    public void deCryptSolution(CryptoModel model) throws IOException {
        String text = newFileService.readFromFile(model.getPathFrom());
        char[] myCharArray = text.toLowerCase().toCharArray();
        cryptoService.deCrypt(myCharArray, model.getKey());
        newFileService.writeToFile(String.copyValueOf(myCharArray), model.getPathTo());
    }

    public int bruteforce(BruteForceModel model) throws IOException {
        int mainMetric = 0;
        int cryptoKey = 0;
        String[] wordsFromExample = findRepeatedWords(newFileService.readFromFile(model.getExamplePath()));
        char[] cryptedText = newFileService.readFromFile(model.getPathToEncryptedTxt()).toCharArray();
        for (int i = 1; i < Consts.getAlphabet().length; i++) {
            int counter = 0;
            char[] decryptedChars = Arrays.copyOf(cryptedText, cryptedText.length);
            ;
            cryptoService.deCrypt(decryptedChars, i);
            String decryptedTxt = String.copyValueOf(decryptedChars);
            String[] wordsFromCrypt = findRepeatedWords(decryptedTxt);

            for (int j = 0; j < wordsFromExample.length; j++) {
                for (int k = 0; k < wordsFromCrypt.length; k++) {
                    if (wordsFromExample[j].equals(wordsFromCrypt[k])) {
                        counter++;
                    }
                }
            }
            if (counter > mainMetric) {
                mainMetric = counter;
                cryptoKey = i;
            }
        }
        return cryptoKey;
    }

    private static String[] findRepeatedWords(String s) {
        String[] words = s.toLowerCase().split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordCount.put(words[i], wordCount.getOrDefault(words[i], 0) + 1);
        }
        String[] repeatedWordsText = new String[Consts.COUNTER_OF_WORDS];
        for (int i = 0; i < Consts.COUNTER_OF_WORDS; i++) {
            String needle = "";
            int maxRepeat = 0;
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                String word = entry.getKey();
                Integer numberOfRepeat = entry.getValue();
                if (word.length() <= Consts.MAX_LENGTH_OF_WORDS && numberOfRepeat > maxRepeat) {
                    needle = word;
                }
            }
            repeatedWordsText[i] = needle;
            wordCount.remove(needle);
        }
        return repeatedWordsText;
    }


}