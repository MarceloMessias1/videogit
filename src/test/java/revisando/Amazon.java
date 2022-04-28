package revisando;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class Amazon {

	MetodosDeTestes metodo = new MetodosDeTestes();

	@Before
	public void setUp() throws Exception {

		metodo.acessarSistema("https://www.amazon.com.br");
	}

	@After
	public void tearDown() throws Exception {
		metodo.encerrarSistema();
	}

	@Test
	public void acessarWebDriverNoRodape() {
		By amazonWebServices = By.xpath("//*[@id=\"navFooter\"]/div[4]/ul[2]//a");
		By texto = By.id("What_is_cloud_computing.3F"); // deve validar esse texto Tipos de computa��o em

		metodo.scrollNatela();
		metodo.mudarAba();
		metodo.clicaWebService(amazonWebServices);
		metodo.validar(texto, "O que � a computa��o em nuvem?");

	}

}
