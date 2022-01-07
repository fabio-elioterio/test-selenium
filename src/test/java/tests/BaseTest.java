package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herança para todas as classes de teste
 */
public abstract class BaseTest {

    /**
     * Driver do navegador da página atual
     */
    protected static WebDriver driver;

    /**
     * Caminho base da URL do sistema a ser testado
     */
    private static final String URL_BASE = "src/test/resources/pages-frontend/login.html";

    /**
     * Caminho relativo do driver ao projeto referente ao path
     */
    private static final String DRIVER_PATH = "src/test/resources/chromedriver.exe";

    /**
     * Método para iniciar o driver do navegador antes de qualquer classe de teste
     */
    @BeforeClass
    public static void iniciar() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    /**
     * Método para finalizar o driver do navegador depois de qualquer classe de teste
     */
    @AfterClass
    public static void finalizar() {
        driver.quit();
    }

}
