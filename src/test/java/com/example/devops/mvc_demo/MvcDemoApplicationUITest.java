package com.example.devops.mvc_demo;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

class MvcDemoApplicationUITest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUpClass() {
        // Se configuran opciones para entorno de CI
        final FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-headless");
        options.addArguments("--window-size=1366,768");

        driver = new FirefoxDriver(options);
        driver.get("http://localhost:8080/libros/inicio");

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
     void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

    @Test
    void testBuscarPorAutorCuandoAutorExiste() {
        final WebElement input = driver.findElement(By.id("buscar"));
        input.clear();
        input.sendKeys("Asimov");

        final WebElement button = driver.findElement(By.id("btnBuscarAutor"));
        button.click();

        final WebElement tabla = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tblLibros")));
        final List<WebElement> filas =  tabla.findElements(By.tagName("tr"));

        Assertions.assertTrue(filas.size() > 1);
    }

    @Test
    void testBuscarPorAutorCuandoNoExiste() {
        final WebElement input = driver.findElement(By.id("buscar"));
        input.clear();
        input.sendKeys("Paulo");

        final WebElement button = driver.findElement(By.id("btnBuscarAutor"));
        button.click();

        final WebElement tabla = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tblLibros")));
        final List<WebElement> filas =  tabla.findElements(By.tagName("tr"));

        Assertions.assertEquals(1, filas.size());
    }
    
    @Test
    void testBuscarPorAutorPorNombre() {
        final WebElement input = driver.findElement(By.id("buscar"));
        input.clear();
        input.sendKeys("Paulo");

        final WebElement button = driver.findElement(By.id("btnBuscarAutor"));
        button.click();

        final WebElement tabla = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tblLibros")));
        final List<WebElement> filas =  tabla.findElements(By.tagName("tr"));

        Assertions.assertEquals(1, filas.size());
    }
}
