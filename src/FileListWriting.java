import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class FileListWriting {
    void ghiFile(String fileName, List<HangHoa> list) {
        File file = new File(fileName);
        try (PrintWriter out = new PrintWriter(file)) {
            for (HangHoa hangHoa : list) {
                out.println(hangHoa.toString());
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
