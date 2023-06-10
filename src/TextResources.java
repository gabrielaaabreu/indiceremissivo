import java.io.*;
import java.util.Scanner;

public class TextResources {
    public String[] text;
    public String[] keys;
    public TextResources() throws IOException {
        this.text = readText();
        this.keys = readKeys();
    }
    public String[] readText() throws IOException {
        BufferedReader reader;
        StringBuilder concatenatedText = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader("src/texto.txt"));
            String line = reader.readLine();
            while (line != null) {
                line = characterHandling(line);
                concatenatedText.append(line).append(";;");
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String semiText = concatenatedText.toString();
        return semiText.split(";;");
    }
    public String[] readKeys() throws IOException {
        BufferedReader reader;
        StringBuilder concatenatedKeys = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader("src/chaves.txt"));
            String line = reader.readLine();
            while(line != null) {
                concatenatedKeys.append(line).append(" ");
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String allKeys = concatenatedKeys.toString();
        return allKeys.split(" ");
    }
    public void writeIndex(ByteArrayOutputStream hash) {
        try {
            FileWriter archive = new FileWriter("src/indice.txt");
            PrintWriter writeArchive = new PrintWriter(archive);
            writeArchive.println(hash);
            archive.close();
        } catch (IOException e) {
            System.err.println("Não foi possivel encontrar o arquivo.");
        }
    }
    public String characterHandling(String line) {
        line = line.toLowerCase();
        line = line.replace(",", "").replace(".", "")
                .replace("!", "").replace("@", "")
                .replace("#", "").replace("$", "")
                .replace("%", "").replace("*", "")
                .replace("(", "").replace(")","")
                .replace("[", "").replace("]","")
                .replace("{", "").replace("}", "")
                .replace("?", "").replace("'", "")
                .replace("\"", "");
        return line;
    }
}
