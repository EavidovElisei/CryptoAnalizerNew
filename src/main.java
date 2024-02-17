package src;

import src.Model.BruteForceModel;
import src.Model.CryptoModel;
import src.Service.ConsoleService;
import src.Service.SolutionService;

import java.io.IOException;
import java.util.Scanner;

public class main {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        SolutionService solutionService = new SolutionService();
        CryptoModel cryptoModel = new CryptoModel();
        ConsoleService consoleService = new ConsoleService(scanner);
        BruteForceModel bruteForceModel = new BruteForceModel();

        int typeOfCrypto = consoleService.start();
        try {
            switch (typeOfCrypto) {
                case 1:
                    consoleService.enterData(cryptoModel);
                    solutionService.cryptSolution(cryptoModel);
                    break;
                case 2:
                    consoleService.enterData(cryptoModel);
                    solutionService.deCryptSolution(cryptoModel);
                    break;
                case 3:
                    consoleService.enterDataBruteForce(bruteForceModel);
                    int key = solutionService.bruteforce(bruteForceModel);
                    consoleService.printBruteForceResult(key);
                    break;
                default:
                    consoleService.invalidCommand();
            }
        }catch (Exception exception){
            consoleService.exceptions(exception);
        }
    }
}

