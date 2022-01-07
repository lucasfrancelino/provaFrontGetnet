package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Object {
	public WebDriverWait wait;

//	combo
	public String combo_version = "//*[@id='switch-version-select']";


	public void clicar(String elemento) {
		try {
			Manager.getDriver().findElement(By.id(elemento)).click();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Manager.getDriver().findElement(By.xpath(elemento)).click();
		}
	}

//método digitar recebe apenas elementos de tela id ou xpath    
	public void digitar(String elemento, String texto) {
		try {
			Manager.getDriver().findElement(By.id(elemento)).sendKeys(texto);
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Manager.getDriver().findElement(By.xpath(elemento)).sendKeys(texto);
		}
	}
	
	public String recuperar_texto_elemento(String elemento) {
        wait = new WebDriverWait(Manager.getDriver(), 5); 
        try {
            String texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elemento))).getText();
            return texto;
        } catch (Exception e) {
            String texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemento))).getText();
            return texto;
        }
    } 
    
    public void validar_mensagem(String texto_esperado, String texto) {
        Assert.assertEquals(texto_esperado, texto);    
    }
    
    public void esperar_elemento(String elemento) {
        wait = new WebDriverWait(Manager.getDriver(), 10); 
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elemento)));  
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elemento))); 
        }
    }
}
