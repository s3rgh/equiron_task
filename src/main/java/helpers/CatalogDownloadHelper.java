package helpers;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

import static constants.Constants.FILENAME;

public class CatalogDownloadHelper {

    public static void downloadFile(String url) {
        String fileName = Paths.get("").toAbsolutePath() + "\\" + FILENAME;

        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;

        try {
            bufferedInputStream = new BufferedInputStream(new URL(url).openStream());
            fileOutputStream = new FileOutputStream(fileName);
            final byte[] data = new byte[1024];
            int count;
            while ((count = bufferedInputStream.read(data, 0, 1024)) != -1) {
                fileOutputStream.write(data, 0, count);
            }
            fileOutputStream.close();
            bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}