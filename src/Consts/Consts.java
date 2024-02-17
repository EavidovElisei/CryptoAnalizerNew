package src.Consts;

public class Consts {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '-'};

    public static final String ENTER_CRYPTOANALIZATOR_MODE = "Введите режим криптоанализатора";
    public static final String CRYPT_MODE = "1- режим шифровки";
    public static final String DE_CRYPT_MODE = "2- режим дешифровки";
    public static final String BRUTE_FORCE_MODE = "3- режим BruteForce";
    public static final String ENTER_ORIGINAL_TEXT_FILE = "Введите имя файла с исходным текстом";
    public static final String ENTER_RESULT_TEXT_FILE = "Введите имя файла для записи результата";
    public static final String ENTER_KEY = "Введите ключ";
    public static final String WRONG_KEY = "Введен неправильный ключ Цезаря";
    public static final String EXAMPLE_TEXT = "Введите имя файла, который является примером для анализа";
    public static final String KEY_IS_CORRECT = "Ключ корректный";
    public static final String FILE_READER_ERROR = "Ошибка чтения файла";
    public static final String UNSUPPORTED_MODE = "Не поддерживаемый режим крипто-анализатора";
    public static final int COUNTER_OF_WORDS = 3;
    public static final int MAX_LENGTH_OF_WORDS = 3;
    public static final String CRYPT_KEY_IS = "Ключ шифрования - ";
    public static final String ENTER_CRYPTED_FILE_NAME = "Введите имя файла с зашифрованным текстом";


    public static char[] getAlphabet() {

        return ALPHABET;

    }

}
