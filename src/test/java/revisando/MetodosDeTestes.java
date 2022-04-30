package revisando;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MetodosDeTestes {

	WebDriver driver;

	public void acessarSistema(String site) {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(site);
		driver.manage().window().maximize();
		System.out.println("****INICIANDO TESTE****");
	}

	public void encerrarSistema() {
		driver.quit();
		System.out.println("***** FINALIZANDO TESTE *****");
	}

	public void escrever(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);
	}

	public void clicar(By elemento) {
		driver.findElement(elemento).submit();
	}

	public void clicarMusica(By elemento) {
		driver.findElement(elemento).click();
	}

	public void validar(By elemento, String texto) {
		String textoEsperado = driver.findElement(elemento).getText();
		assertEquals(texto, textoEsperado);
	}
	
	public void validarmusica(By elemento, String texto) {
		String textoEsperado = driver.findElement(elemento).getText();
		JavascriptExecutor executor =(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", elemento);

		assertEquals(texto, textoEsperado);
	}
	public void scrollNatela() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,5000)");

	}

	public void mudarAba() {
		String abaPrincipal = driver.getWindowHandle();
		Set<String> todasJanelas = driver.getWindowHandles();
		Iterator<String> iterator = todasJanelas.iterator();

		while (iterator.hasNext()) {
			String abaFilha = iterator.next();
			if (!abaPrincipal.equalsIgnoreCase(abaFilha)) {
				driver.switchTo().window(abaFilha);
				System.out.println("Aba Filha" + driver.getTitle());
			}

		}

//criar umwhile para validar se existe outras janelas
//apos descobrir se tem mais janela crir no while um if para validar se esta na janela filha
	}

	public void validarMensagem(By logradouro_Nome_elemento, String logradouro_Nome) {
		String textoEsperado = driver.findElement(logradouro_Nome_elemento).getText();
		assertEquals(logradouro_Nome, textoEsperado);
	}

	public void clicaWebService(By elemento) {
		driver.findElement(elemento).click();
	}

	public void clicarClipe(By elemento) {
		driver.findElement(elemento).click();	
	}

}
