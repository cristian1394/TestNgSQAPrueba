package com.PagsObjet;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.MapsObjet.MapObjetEmpleado;
import com.MapsObjet.MapObjetFormularioEmpleado;
import com.MapsObjet.MapObjetInformacionEmpleado;
import com.MapsObjet.MapObjetInicio;

public class PagObjetInformacionEmpleado extends MapObjetInformacionEmpleado
{
	String url;
	
	public void setUrl(String url) {
		this.url = url;
	}

	// CREAR CONSTRUCTOR DE LA CLASE
	public PagObjetInformacionEmpleado(WebDriver driver)
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
	public PagObjetInformacionEmpleado Consultar (String EmployeeName,File rutaCarpeta, String generarEvidencia) throws Exception
	{
		try
		{
             tiempoEspera(3);
			
		    
			click(btnPim, rutaCarpeta, generarEvidencia);
			sendkey(EmployeeName, txtEmployeeName, rutaCarpeta,generarEvidencia);
			click(btnSearch, rutaCarpeta, generarEvidencia);
			click(btnID, rutaCarpeta, generarEvidencia);
			click(btnEliminar, rutaCarpeta, generarEvidencia);
			click(btnEliminar2, rutaCarpeta, generarEvidencia);
			tiempoEspera(2);
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return this;
	}
}
