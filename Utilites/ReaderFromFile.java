package Utilites;

import java.io.*;

/**
 * read from file
 *
 * @author Polina
 */
public class ReaderFromFile {
    /**
     * @param filename
     * @return file's content
     * @throws IOException in case if the program can't find file
     */
    public static String read(String filename) throws IOException {
        try {
            String data = "";
            FileInputStream file = new FileInputStream(filename);
            InputStream elem = new BufferedInputStream(file);
            while (elem.available() > 0)
                data += (char) elem.read();
            file.close();
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("Указанный файл не найден");
            return null;
        }
    }
}
