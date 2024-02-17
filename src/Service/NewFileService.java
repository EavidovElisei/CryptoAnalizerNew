package src.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class NewFileService {
    public  String readFromFile( String path) throws IOException {
        File file = new File(path);
        String fileContent = new String(Files.readAllBytes(file.toPath()));
    return fileContent;

    }
    public  void writeToFile(String text, String path) throws IOException {
        File myFile = new File(path);
        FileOutputStream outputStream = new FileOutputStream(myFile);
        byte[] buffer = text.getBytes();
        outputStream.write(buffer);
        outputStream.close();
    }
}

