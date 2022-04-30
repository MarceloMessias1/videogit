package revisando;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Youtube {

	MetodosDeTestes metodos = new MetodosDeTestes();

	@Before
	public void setUp() throws Exception {
		metodos.acessarSistema("https://www.youtube.com.br");
	}

	@After
	public void tearDown() throws Exception {
		metodos.encerrarSistema();
	}

	@Test
	public void pesquisarMusica() throws InterruptedException {
		By pesquisar = By.name("search_query");
		Thread.sleep(4000);
		By clicaMusica = By.xpath("//*[@id=\"search-icon-legacy\"]");

		Thread.sleep(4000);

		By validarMusica = By.xpath("//*[@id='corrected']']");


		metodos.escrever(pesquisar, "fernandinho");
		metodos.clicarMusica(clicaMusica);
		metodos.clicarMusica(validarMusica);

		String texto = "FERNANDINHO | GALILEU | CLIPE OFICIAL";// texto
		metodos.validarmusica(validarMusica, texto);

	}
}