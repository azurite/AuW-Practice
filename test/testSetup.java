import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class testSetup {
    protected ByteArrayOutputStream out;
    protected String expected = "";

    protected void init(String outPath) {
        if(out != null) {
            try {
                out.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        out = new ByteArrayOutputStream();

        try {
            expected = new String(Files.readAllBytes(Paths.get(outPath))).replace("\r", "");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
