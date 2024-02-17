package src.Service;

import src.Model.BruteForceModel;
import src.Consts.Consts;
import src.Model.CryptoModel;


import java.util.Scanner;

public class ConsoleService {
    private final Scanner scanner;

    public ConsoleService(Scanner scanner) {
        this.scanner = scanner;
    }

    public int start() {
        System.out.println(Consts.ENTER_CRYPTOANALIZATOR_MODE);
        System.out.println(Consts.CRYPT_MODE);
        System.out.println(Consts.DE_CRYPT_MODE);
        System.out.println(Consts.BRUTE_FORCE_MODE);
        int typeOfCrypto = scanner.nextInt();
        scanner.nextLine();
        return typeOfCrypto;
    }

    public void invalidCommand() {
        System.out.println(Consts.UNSUPPORTED_MODE);
    }
    public void exceptions(Exception exception){
        System.out.println(exception.getMessage());
    }

    public void printBruteForceResult(int k) {

        System.out.println(Consts.CRYPT_KEY_IS + k);
    }

    public void enterData(CryptoModel cryptoModel) throws RuntimeException {
        System.out.println(Consts.ENTER_ORIGINAL_TEXT_FILE);
        cryptoModel.setPathFrom(scanner.nextLine());
        System.out.println(Consts.ENTER_RESULT_TEXT_FILE);
        cryptoModel.setPathTo(scanner.nextLine());
        System.out.println(Consts.ENTER_KEY);
        cryptoModel.setKey(scanner.nextInt());

        if (cryptoModel.getKey() > 0 && cryptoModel.getKey() < Consts.getAlphabet().length) {
            System.out.println(Consts.KEY_IS_CORRECT);
        } else {
            throw new RuntimeException(Consts.WRONG_KEY);
        }
    }

    public void enterDataBruteForce(BruteForceModel bruteForceModel) {
        System.out.println(Consts.ENTER_CRYPTED_FILE_NAME);
        bruteForceModel.setPathToEncryptedTxt(scanner.nextLine());
        System.out.println(Consts.EXAMPLE_TEXT);
        bruteForceModel.setExamplePath(scanner.nextLine());
    }
}
