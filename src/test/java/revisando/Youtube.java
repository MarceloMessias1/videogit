package revisando;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class Youtube {

	MetodosDeTestes metodos = new MetodosDeTestes();

	@Before
	public void setUp() throws Exception {
		metodos.acessarSistema("https://www.youtube.com.br");
	}

	@After
	public void tearDown() throws Exception {
		// metodos.encerrarSistema();
	}

	@Test
	public void pesquisarMusica() throws InterruptedException {
		String texto = "";// texto da musica
		By pesquisar = By.name("search_query");
		//By iconePesquisar = By.xpath("");
		Thread.sleep(4000);
		By clicaMusica = By.xpath("//*[@id=\"search-icon-legacy\"]");
		Thread.sleep(4000);
		By clicarClipe = By.xpath("//*[text()='UMA NOVA HISTÓRIA - FERNANDINHO [CLIPE OFICIAL]']");
		By tituloMusica = By.xpath("");

		metodos.escrever(pesquisar, "fernandinho");
		metodos.clicarMusica(clicaMusica);
		metodos.clicarClipe (clicarClipe);
//		metodos.validarmusica(tituloMusica, texto);

	}
}