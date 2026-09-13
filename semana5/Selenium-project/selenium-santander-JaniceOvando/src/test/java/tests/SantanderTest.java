package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AcercaDelBancoPage;
import pages.HomePage;

public class SantanderTest extends BaseTest {

    @Test
    public void shouldLoadHomePage() {
        HomePage home = new HomePage(driver).open().acceptCookiesIfPresent();
        Assert.assertTrue(driver.getTitle().contains("Santander"),
                "El título de la página debería contener 'Santander'");
    }

    @Test
    public void shouldNavigateToAcercaDelBanco() {
        HomePage home = new HomePage(driver).open().acceptCookiesIfPresent();
        AcercaDelBancoPage acercaDelBanco = home.goToAcercaDelBanco();

        Assert.assertTrue(
                acercaDelBanco.isFundacionLinkVisible(),
                "Debería ver el link de 'Fundación Santander' en la sección Acerca del Banco"
        );
    }

    @Test
    public void shouldSeeSostenibilidadOption() {
        HomePage home = new HomePage(driver).open().acceptCookiesIfPresent();
        Assert.assertTrue(home.isSostenibilidadLinkVisible(),
                "El menú debería mostrar la opción de Sostenibilidad");
    }
}
