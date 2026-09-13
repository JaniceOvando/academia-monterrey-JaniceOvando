package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final By COOKIE_ACCEPT_BUTTON =
            By.xpath("//button[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'acept') or contains(@id,'onetrust-accept') or contains(@class,'cookie')]");

    private static final By ACERCA_DEL_BANCO_MENU =
            By.xpath("//*[normalize-space(text())='Acerca del Banco']");

    private static final By SOSTENIBILIDAD_LINK =
            By.partialLinkText("Sostenibilidad");

    private static final By BLOG_LINK =
            By.partialLinkText("Blog");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get("https://www.santander.com.mx/");
        return this;
    }

    public HomePage acceptCookiesIfPresent() {
        if (isDisplayed(COOKIE_ACCEPT_BUTTON)) {
            click(COOKIE_ACCEPT_BUTTON);
        }
        return this;
    }

    public AcercaDelBancoPage goToAcercaDelBanco() {
        click(ACERCA_DEL_BANCO_MENU);
        return new AcercaDelBancoPage(driver);
    }

    public boolean isSostenibilidadLinkVisible() {
        return isDisplayed(SOSTENIBILIDAD_LINK);
    }

    public boolean isBlogLinkVisible() {
        return isDisplayed(BLOG_LINK);
    }
}
