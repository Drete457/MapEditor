package MapEditor;

import java.io.*;

public class SaveLoad {

    //memorise the address of the file that we will use to save and load
    private static final String filePath = "save.txt";

    //write the data in the file
    public static void writeFile(String file) {

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(file);
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (IOException e) {
            e.getMessage();
        }
    }

    //load the file to the grid
    public static String readFile() {

        String result = "";

        try {
            String line;
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                result += line + "\n";
            }
            bufferedReader.close();
        }
        catch (IOException e) {
                e.getMessage();
        }
        return result;
    }
}
