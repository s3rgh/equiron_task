package helpers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import static constants.Constants.*;

public class PDFHelper {

    public static boolean checkRequiredTextInPdf(Path path) {
        File pdfFile = new File(path + "\\" + FILENAME);
        String text = "";
        try {
            PDDocument pdDocument = PDDocument.load(pdfFile);
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            text = pdfTextStripper.getText(pdDocument);
            //System.out.println(text);
            pdDocument.close();
            Files.delete(pdfFile.toPath());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return text.contains(CHECKED_COURSE_NAME) && text.contains(CHECKED_COURSE_CODE);
    }
}