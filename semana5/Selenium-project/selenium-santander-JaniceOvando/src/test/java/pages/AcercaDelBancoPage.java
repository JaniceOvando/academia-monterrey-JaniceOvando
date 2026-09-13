package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AcercaDelBancoPage extends BasePage {

    private static final By FUNDACION_SANTANDER_LINK = By.partialLinkText("Fundación Santander");
    private static final By SOSTENIBILIDAD_LINK = By.partialLinkText("Sostenibilidad");
    private static final By INVERSIONISTAS_LINK = By.partialLinkText("Inversionistas");
    private static final By BOLSA_TRABAJO_LINK = By.partialLinkText("Bolsa de trabajo");

    public AcercaDelBancoPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFundacionLinkVisible() {
        return isDisplayed(FUNDACION_SANTANDER_LINK);
    }

    public boolean isSostenibilidadLinkVisible() {
        return isDisplayed(SOSTENIBILIDAD_LINK);
    }

    public boolean isInversionistasLinkVisible() {
        return isDisplayed(INVERSIONISTAS_LINK);
    }

    public boolean isBolsaTrabajoLinkVisible() {
        return isDisplayed(BOLSA_TRABAJO_LINK);
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }
}
