package src.ge.edu.sangu.teamproj.stringsearching.analysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class File_Reader {

    public static String TextReturn(){
        StringBuffer stringBuffer = null;
        try {
            File file = new File("C:\\Users\\Mad-Asus\\Desktop\\Loren Ipsum.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            stringBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
            fileReader.close();
            //System.out.println("Contents of file:");
            //System.out.println(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }
}

