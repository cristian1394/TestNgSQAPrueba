package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;
import com.MapsObjet.MapObjetInicio;

public class PagObjetInicio extends MapObjetInicio 
{
	String url;
	
	public void setUrl(String url) {
		this.url = url;
	}

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagObjetInicio(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}

	// METODO INICIAL
	public void urlAcceso()
	{
		driver.get(url);
	}

	// METODO PRIMERA PRUEBA
	public PagObjetInicio busquedaInicial (String userName,String password, File rutaCarpeta, String generarEvidencia) throws Exception
	{
		try
		{
             tiempoEspera(3);
			
		    sendkey(userName, txtUsername, rutaCarpeta,generarEvidencia);
			sendkey(password, txtPassword, rutaCarpeta,generarEvidencia);
			click(btnLogin, rutaCarpeta, generarEvidencia);
			click(btnEmployee, rutaCarpeta, generarEvidencia);
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return this;
	}
}
