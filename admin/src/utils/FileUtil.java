package utils;

import java.io.FileOutputStream;

public class FileUtil {
    public static void save(byte[] raw, String filePath) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        fileOutputStream.write(raw);
        fileOutputStream.close();
    }
}
