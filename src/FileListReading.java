import java.io.FileInputStream;
import java.io.IOException;

public class FileListReading {
    void docFile(String file){
        try (FileInputStream inFile = new FileInputStream(file)) {
            int c =  inFile.read();
            while(c != -1){
                System.out.print((char)c);
                c = inFile.read();
            }
        } catch (IOException e) {
            System.out.println("Không tìm thấy file!!!");
        }
    }
}
