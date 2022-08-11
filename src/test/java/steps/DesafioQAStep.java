package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DesafioQAStep{
	
	private WebDriver driver;
	
	@Given("Acesso ao link de teste")
	public void acesso_ao_link_de_teste() {
		System.setProperty("webdriver.chrome.driver", "E:/Projects/TesteQA/Driver/chromedriver.exe"); 	// Definindo o local de execução do chromedriver e o local de acesso do teste
		driver = new ChromeDriver();
		driver.get("https://wj-qa-automation-test.github.io/qa-test/");
	    driver.manage().window().maximize();
	}
	
	@When("clico nos botoes one two e four")
	public void clico_nos_botoes_one_two_four() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text() = 'One']")).click();                // Passando os parametros dos botes tanto em xpath quanto em id
		System.out.print("clicando no botão One \n");
		driver.findElement(By.id("btn_two")).click();
		System.out.print("clicando no botão Two \n");
		driver.findElement(By.id("btn_link")).click();
		System.out.print("clicando no botão Four \n");
		Thread.sleep(2000);
	}
	
	@Then("valido a ausensia dos mesmos")
	public void valido_ausensia_dos_mesmos() throws InterruptedException, IOException {
		Assert.assertEquals(driver.findElement(By.xpath("(//button[@style = 'display: none;'])[1]")), driver.findElement(By.xpath("(//button[@style = 'display: none;'])[1]")));
		System.out.print("Botão One Ausente");
		Assert.assertEquals(driver.findElement(By.xpath("(//button[@style = 'display: none;'])[2]")), driver.findElement(By.xpath("(//button[@style = 'display: none;'])[2]")));
		System.out.print("Botão Two Ausente");
		Assert.assertEquals(driver.findElement(By.xpath("(//button[@style = 'display: none;'])[3]")), driver.findElement(By.xpath("(//button[@style = 'display: none;'])[3]")));
		System.out.print("Botão Four Ausente");
		
		File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);         // Validando a ausencia dos botões e tirando um print do final da execução
		FileUtils.copyFile(printFinal, new File("target/validacao.png"));
		driver.quit();
	}
	
	@When("clico nos botoes one two e four iframe")
	public void clico_nos_botoes_one_two_four_iframe() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src= 'buttons.html']")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text() = 'One']")).click();
		System.out.print("clicando no botão One \n");                                 // Passando os parametros dos botes tanto em xpath quanto em id inforamndo antes o frame que irá acessar os botões
		driver.findElement(By.xpath("//button[text() = 'Two']")).click();                  
		System.out.print("clicando no botão Two \n");
		driver.findElement(By.xpath("//button[text() = 'Four']")).click();
		System.out.print("clicando no botão Four \n");
		Thread.sleep(2000);
	}
	
	@Then("valido a ausensia dos botoes iframe")
	public void valido_ausensia_dos_botoes_iframe() throws InterruptedException, IOException {
		Assert.assertEquals(driver.findElement(By.xpath("(//button[@style = 'display: none;'])[1]")), driver.findElement(By.xpath("(//button[@style = 'display: none;'])[1]")));
		System.out.print("Botão One Ausente");
		Assert.assertEquals(driver.findElement(By.xpath("(//button[@style = 'display: none;'])[2]")), driver.findElement(By.xpath("(//button[@style = 'display: none;'])[2]")));
		System.out.print("Botão Two Ausente");
		Assert.assertEquals(driver.findElement(By.xpath("(//button[@style = 'display: none;'])[3]")), driver.findElement(By.xpath("(//button[@style = 'display: none;'])[3]")));
		System.out.print("Botão Four Ausente");
		
		File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);       // Validando a ausencia dos botões e tirando um print do final da execução
		FileUtils.copyFile(printFinal, new File("target/validacao.png"));
		driver.quit();
	}
	
	@And("preencho o campo firstName")
	public void preencho_campo_firstName() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id = 'first_name']")).sendKeys("Pietro");  // preechendo o campo first name com os parametros passados
		System.out.print("Informando o primeiro nome \n");
		Thread.sleep(2000);
	}
	
	@And("clico no botao One")
	public void clico_botao_One() throws InterruptedException {
		driver.findElement(By.xpath("//button[text() = 'One']")).click();
		System.out.print("clicando no botão One \n");                        // clicando no botão one com os parametros passados
		Thread.sleep(2000);
	}
	
	@When("marco a optionThree")
	public void marco_optionThree() throws InterruptedException {
		driver.findElement(By.xpath("//label[text() = 'OptionThree']")).click();    // marcando a optionthree com os parametros passados 
		System.out.print("Marcando a box OptionThree \n");
		Thread.sleep(2000);
	}
	
	@And("seleciono a opcao exampleTwo")
	public void seleciono_opcao_exampleTwo() throws InterruptedException {
		driver.findElement(By.xpath("//select[@id = 'select_box']")).click();
		driver.findElement(By.xpath("//option[text() = 'ExampleTwo']")).click();         // selecionando a opção exampleTwo com os parametros passados
		System.out.print("selecionando a opção ExampleTwo \n");
		Thread.sleep(2000);
	}
	
	@Then("valido a imagen do selenium")
	public void valido_imagen_selenium() throws InterruptedException, IOException {
		Assert.assertEquals(driver.findElement(By.xpath("//img[@alt = 'selenium']")), driver.findElement(By.xpath("//img[@alt = 'selenium']")));
		System.out.print("Imagem do selenium presente \n");
		
		File printFinal = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);      // validando a existencia da imagem do selenium e tirando um print no final da execução
		FileUtils.copyFile(printFinal, new File("target/validacao.png"));
		driver.quit();
	}
}
