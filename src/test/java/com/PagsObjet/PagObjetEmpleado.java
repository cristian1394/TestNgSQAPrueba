package com.PagsObjet;

import java.io.File;
import org.openqa.selenium.WebDriver;

import com.MapsObjet.MapObjetEmpleado;
import com.MapsObjet.MapObjetInicio;

public class PagObjetEmpleado extends MapObjetEmpleado
{
	String url;
	
	public void setUrl(String url) {
		this.url = url;
	}

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagObjetEmpleado(WebDriver driver)
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
	public PagObjetEmpleado Empleado (String firstName,String middleName,String lastName,String id, File rutaCarpeta, String generarEvidencia) throws Exception
	{
		try
		{
             tiempoEspera(3);
			
		    sendkey(firstName, txtfirstName, rutaCarpeta,generarEvidencia);
			sendkey(middleName, txtMiddleName, rutaCarpeta,generarEvidencia);
			sendkey(lastName, txtlastName, rutaCarpeta,generarEvidencia);
			eliminarTextoKeyBoard(txtId);
			sendkey(id, txtId, rutaCarpeta,generarEvidencia);
			click(btnSave, rutaCarpeta, generarEvidencia);
			tiempoEspera(6);
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return this;
	}
}
