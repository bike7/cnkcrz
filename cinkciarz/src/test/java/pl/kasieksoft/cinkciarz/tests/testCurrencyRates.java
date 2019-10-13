package pl.kasieksoft.cinkciarz.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pl.kasieksoft.cinkciarz.model.Currency;
import pl.kasieksoft.cinkciarz.model.CurrencyBuilder;

import java.util.concurrent.TimeUnit;

public class testCurrencyRates {

    private WebDriver wd;
    private WebDriverWait wait;

    @Test
    public void getCurrencyRates() {
        start();
        System.out.println(readCurrencyRate("chf/pln"));
        System.out.println(readCurrencyRate("eur/chf"));
        System.out.println(readCurrencyRate("eur/usd"));
        stop();
    }

    private Currency readCurrencyRate(String currencyRatio) {
        wd.get("https://cinkciarz.pl/wymiana-walut/kursy-walut-cinkciarz-pl/" + currencyRatio);
        wd.findElement(By.linkText("Kurs jednostkowy")).click();
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("td[data-buy='true']"))));
        return CurrencyBuilder.aCurrency()
                .withCurrencyCode(currencyRatio)
                .withBuyRate(wd.findElement(By.cssSelector("td[data-buy='true']")).getText())
                .withSellRate(wd.findElement(By.cssSelector("td[data-sell='true']")).getText())
                .build();
    }

    private void start() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wd.get("https://cinkciarz.pl");
        wd.findElement(By.cssSelector("button[class*=cookie-close]")).click();
        wd.manage().window().maximize();
        wait = new WebDriverWait(wd, 1);
    }

    private void stop() {
        wd.quit();
    }
}
