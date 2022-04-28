package revisando;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class Correios {

	MetodosDeTestes metodo = new MetodosDeTestes();
	By buscarCep = By.id("relaxation");
	String cep = "06463010";
	By lupa = By.cssSelector("#content > div.mais-acessados > div > div:nth-child(2) > form > div.campo > button > i");
	By todoEnderecoTexto = By.xpath("");

	@Before
	public void setUp() throws Exception {

		metodo.acessarSistema("https://www.correios.com.br");

	}

	@After
	public void tearDown() throws Exception {

		metodo.encerrarSistema();
	}

	@Test
	public void validarInformacoesCompleta() {
		
		String enderecoCompleto = "Rua Vertentes";
		metodo.escrever(buscarCep, cep);
		metodo.clicar(lupa);
		metodo.mudarAba();
		metodo.validarMensagem(todoEnderecoTexto, enderecoCompleto);
	}

	@Test
	public void validarInformacoesSeparada() {
		By logradouro_Nome_elemento = By.id("relaxation");
		By bairro_Distrito_elemento = By.xpath("//*[text()='Logradouro/Nome']");
		By localidade_UF_elemento = By.cssSelector("#resultado-DNEC > tbody > tr > td:nth-child(3)");
//		By cEP_elemento = By.xpath("//*[@id=\"resultado-DNEC\"]//td[4]");

		String logradouro_Nome = "Rua Vertentes";
		String bairro_Distrito = 	"Jardim Mutinga";
		String localidade_UF = "Barueri/SP";
		String cEP = "06463-010";
//		metodo.escrever(cEP_elemento, cep);
		metodo.clicar(lupa);
		metodo.mudarAba();
		metodo.validarMensagem(logradouro_Nome_elemento, logradouro_Nome);
		metodo.validarMensagem(bairro_Distrito_elemento, bairro_Distrito);
		metodo.validarMensagem(localidade_UF_elemento, localidade_UF);
	//	metodo.validarMensagem(cEP_elemento, cEP);

	}

}