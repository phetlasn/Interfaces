import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectFile;
        String pro;
        ShortWordFilter shortWordFilter = new ShortWordFilter();

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectFile = chooser.getSelectedFile();
                Path file = selectFile.toPath();
                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int line = 0;
                System.out.println("Words in the file that are shorter than 5 letters: ");
                while (reader.ready()) {
                    pro = reader.readLine();
                    line++;
                    if (shortWordFilter.accept(pro)) {
                        System.out.println(pro);
                    }
                }
                reader.close();
                System.out.println("\n\nData file has been read");
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File was not found");
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
