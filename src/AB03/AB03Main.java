package AB03;
import java.io.*;
import java.util.Scanner;

public class AB03Main {
    public static String encrypt(String text, int key) {
        char[] zeichen = text.toCharArray();
        for (int i = 0; i < zeichen.length; i++) {
            zeichen[i] = (char) (zeichen[i] ^ key);
        }
        return new String(zeichen);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie den Pfad zum File an: ");
        String path = scanner.nextLine();
        System.out.println("Geben Sie den Pfad zum Speichern an: ");
        String savepath = scanner.nextLine();
        System.out.println("Geben Sie den Key an: ");
        int key = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();

        try (Scanner fileScanner = new Scanner(new File(path), "UTF-8")) {
            int counter = 0;

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println("Zeile " + counter + ": " + line);
                stringBuilder.append(line);
                counter++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            File f = new File(savepath);
            f.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(savepath, false));

            writer.write(encrypt(stringBuilder.toString(), key));

            writer.close();

        } catch (FileNotFoundException eIO) {
            System.out.println("Folgender Fehler trat auf: " + eIO);
        }
    }
}
