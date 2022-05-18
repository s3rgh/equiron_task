import helpers.CatalogDownloadHelper;
import helpers.PDFHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LuxoftCatalogPage;
import pages.LuxoftStartPage;

import static constants.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LuxoftTest extends TestBase {

    LuxoftStartPage luxoftStartPage;
    LuxoftCatalogPage luxoftCatalogPage;

    @BeforeEach
    public void start() {
        initialize();
        luxoftStartPage = new LuxoftStartPage(webDriver);
    }

    @AfterEach
    public void stop() {
        tearDown();
    }

    @Test
    public void checkRequiredCourseExists() throws InterruptedException {

        luxoftCatalogPage = luxoftStartPage
                .openUrl(BASE_URL)
                .openMenuPoint(MENU_CATALOG);

        CatalogDownloadHelper.downloadFile(luxoftCatalogPage.loadCatalog(DOWNLOAD_CATALOG));
        Thread.sleep(1000);
        assertThat(PDFHelper.checkRequiredTextInPdf(SOURCE_DIRECTORY)).isEqualTo(true);
    }
}