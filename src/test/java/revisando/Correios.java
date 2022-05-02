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
	By todoEnderecoTexto = By.xpath("//*[@id=\"resultado-DNEC\"]//td[1]");

	By validarBairro = By.xpath("//*[@id=\"resultado-DNEC\"]//td[2]");

	By validaCidade = By.xpath("//*[@id=\"resultado-DNEC\"]//td[3]");

	By validaCep = By.xpath("//*[@id=\"resultado-DNEC\"]//td[4]");

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
		metodo.encerrarSistema();
	}

	@Test
	public void validarBairro() {
		String bairro = "Jardim Mutinga";
		metodo.escrever(buscarCep, cep);
		metodo.clicar(lupa);
		metodo.mudarAba();
		metodo.validarMensagem(validarBairro, bairro);

	}

	@Test
	public void validaCidade() {
		String cidade = "Barueri/SP";
		metodo.escrever(buscarCep, cep);
		metodo.clicar(lupa);
		metodo.mudarAba();
		metodo.validarMensagem(validaCidade, cidade);
	}

	@Test
	public void ValidarCEp() {
		String cep = "06463-010";
		metodo.escrever(buscarCep, cep);
		metodo.clicar(lupa);
		metodo.mudarAba();
		metodo.validarMensagem(validaCep, cep);

	}
}
