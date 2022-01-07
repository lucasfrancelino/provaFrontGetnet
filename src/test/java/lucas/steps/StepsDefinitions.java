package lucas.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Manager;
import page.Object;

public class StepsDefinitions {
	
	private Object obj = new Object();
	public WebDriverWait wait;
	
	public Select select;
	
	@Given("that Im a user that Im looking to know about Superget")
	public void that_im_a_user_that_im_looking_to_know_about_superget() {
		Manager.getDriver().get("https://site.getnet.com.br/");
		Manager.getDriver().findElement(By.linkText("Ajuda")).click();
		obj.clicar("//a[contains(text(),'Central de ajuda')]");
	}

	@When("I search for superget")
	public void i_search_for_superget() {
		obj.digitar("//input[@placeholder='digite a palavra-chave para sua dúvida']", "Como acesso a minha conta SuperGet?");
	}

	@Then("I validate that the modal with the message {string} is being displayed")
	public void i_validate_that_the_modal_with_the_message_is_being_displayed(String msg) {
		obj.esperar_elemento("//h2[contains(text(),'Como acesso a minha conta SuperGet?')]");
	    obj.validar_mensagem("Como acesso a minha conta SuperGet?", msg);
	}
	
	@io.cucumber.java.After(order = 0)
	public void fecharBrowser() {
		Manager.killDriver();
	}

	
}
