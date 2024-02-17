package src.Service;

import src.Consts.Consts;

public class CryptoService {
    char[] alphabet = Consts.getAlphabet();

    public void crypt(char[] myCharArray, int key) {
        for (int i = 0; i < myCharArray.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if ((alphabet[j]) == myCharArray[i]) {
                    int newPoz = (j + key);
                    if (newPoz > alphabet.length-1){
                        newPoz = newPoz - alphabet.length;
                    }
                    myCharArray[i] = alphabet[newPoz];
                    break;
                }
            }
        }
    }

    public void deCrypt(char[] myCharArray, int key){
        for (int i = 0; i < myCharArray.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if ((alphabet[j]) == myCharArray[i]) {
                    int newPoz = j - key;
                    if (newPoz < 0) {
                        newPoz = alphabet.length + newPoz;
                    }
                    myCharArray[i] = alphabet[newPoz];
                    break;
                }
            }
        }
    }
}