import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LuxoftPage;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class LuxoftTest extends TestBase {

    //TODO: добавить README
    LuxoftPage luxoftPage;

    @BeforeEach
    public void start() {
        initialize();
    }

    @AfterEach
    public void stop() {
        tearDown();
    }

    @Test
    public void checkRequiredCourseExists() throws InterruptedException {
        luxoftPage = new LuxoftPage(webDriver);
        //TODO: строку - адрес сайта перенести в константы
        luxoftPage.openUrl("https://www.luxoft-training.ru");
        luxoftPage.isPageInitialized();
        luxoftPage.openMenuPoint();
        luxoftPage.loadCatalog();
        Thread.sleep(5000);

        //TODO: вынести работу с pdf в отдельный класс, вызывать необходимый метод в этом месте
        String text = "";
        File pdfFile = new File(getCurrentWorkingDirectory() + "\\luxoft_training_catalog.pdf");
        try {
            PDDocument pdDocument = PDDocument.load(pdfFile);
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            text = pdfTextStripper.getText(pdDocument);
            pdfFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(text.contains("Шаблоны проектирования приложений масштаба предприятия")).isEqualTo(true);
    }
}