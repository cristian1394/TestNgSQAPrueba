package com.testNG;

import org.testng.annotations.Test;

import com.PagsObjet.PagObjetCerrarSesion;
import com.PagsObjet.PagObjetEmpleado;
import com.PagsObjet.PagObjetFormularioEmpleado;
import com.PagsObjet.PagObjetInformacionEmpleado;
import com.PagsObjet.PagObjetInicio;
import com.Utilidades.ExcelUtilidades;
import com.Utilidades.GenerarReportePdf;
import com.Utilidades.MyScreenRecorder;

import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RunTestNG 
{
	private WebDriver driver;
	PagObjetInicio pagObjetInicio;
	PagObjetEmpleado pagObjetEmpleado;
	PagObjetFormularioEmpleado pagObjetFormularioEmpleado;
	PagObjetInformacionEmpleado pagObjetInformacionEmpleado;
	PagObjetCerrarSesion pagObjetCerrarSesion;
	ClaseBase claseBase;
	File rutaCarpeta = null;
	GenerarReportePdf generarReportePdf;
	String valor;
	
  @BeforeClass
  @Parameters({"url","rutaImagenReporte","rutaOutut"})
  public void beforeClass(@Optional("default") String url,
		  				  @Optional("default") String rutaImagenReporte,
		  				  @Optional("default") String rutaOutut) 
  {	  
	  //ASIGNAR PROPIEDADES A DRIVER 
	  driver =ClaseBase.chomeDriverConnetion();
	  //INSTANCIAR LA CLASE 
	  pagObjetInicio = new PagObjetInicio(driver);
	  pagObjetEmpleado = new PagObjetEmpleado(driver);
	  pagObjetFormularioEmpleado = new PagObjetFormularioEmpleado(driver);
	  pagObjetInformacionEmpleado = new PagObjetInformacionEmpleado(driver);
	  pagObjetCerrarSesion = new PagObjetCerrarSesion(driver);
	  
	  claseBase = new ClaseBase(driver);
	  generarReportePdf = new GenerarReportePdf();
	  
	  //SETTIAR LAS CLASES
	  pagObjetInicio.setUrl(url);
	  generarReportePdf.setRutaImagen(rutaImagenReporte);
	  claseBase.setRutaOutut(rutaOutut);
  }
  
  @DataProvider(name="busqueda")
  public Object[][] datos() throws Exception
  {
	  Object[][] arreglo=ExcelUtilidades.getTableArray("./Data/prueba.xlsx", "registro");
	  return arreglo;	  
  }

  @Test(dataProvider = "busqueda",description="acceso a OrangeHRM")
  
  public void pruebaInicialTestNG(String ejecutarCaso, String generarEvidencia,String userName,String password,
		  String firstName,String middleName,String lastName,String id,String nickName,String OtherId,String driverLicense,
		  String licenseExpiry,String ssnNumber,String sinNumber,String Nationality,String maritalStatus,String dateBirth,
		  String militaryService,String EmployeeName) throws Exception 
  {
	  if (ejecutarCaso.equals("Si"))
	  {
		  // OBTENER EL NOMBRE DEL METODO A EJECUTAR
		  String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		 		 
		  //ACCEDER A LA URL
		  pagObjetInicio.urlAcceso();
		  
		  //VALIDAFR SI SE GENERA EVIDENCIA
		  if (generarEvidencia.contains("Si"))
		  {
			  // CREAR CARPETA PARA ALMACENAMIENTO DE EVIDENCIAS
			  rutaCarpeta = claseBase.crearCarpeta(nomTest);
			  
			  //INICIA GRABACION DE VIDEO
			  MyScreenRecorder.startRecording(nomTest,rutaCarpeta);
			  
			  //INICIA CREACION DE REPORTE PDF
			  generarReportePdf.crearPlantilla(nomTest,rutaCarpeta);
			  
			  //ACCEDER AL METODO DE PRUEBA INCIAL (EJECUCUION DE CASO DE PRUEBA)
			  pagObjetInicio.busquedaInicial(userName,password, rutaCarpeta,generarEvidencia);
			  pagObjetEmpleado.Empleado(firstName,middleName,lastName,id,rutaCarpeta,generarEvidencia);
			  pagObjetFormularioEmpleado.Formulario(nickName,OtherId,driverLicense,licenseExpiry,ssnNumber,
			          sinNumber,Nationality,maritalStatus,dateBirth,militaryService, rutaCarpeta, generarEvidencia);
			  pagObjetInformacionEmpleado.Consultar(EmployeeName, rutaCarpeta,generarEvidencia);
			  pagObjetCerrarSesion.Cerrarsesion(rutaCarpeta, generarEvidencia);
			  
			  //FINALIZA GRABACION DE VIDEO
			  MyScreenRecorder.stopRecording();
			  
			  //FINALIZA CREACION DE REPORTE PDF
			  generarReportePdf.cerrarPlantilla();
		  }
		  else
		  {
			  //ACCEDER AL METODO DE PRUEBA INCIAL (EJECUCUION DE CASO DE PRUEBA)
			  pagObjetInicio.busquedaInicial(userName,password, rutaCarpeta,generarEvidencia);
			  pagObjetEmpleado.Empleado(firstName,middleName,lastName,id,rutaCarpeta,generarEvidencia);
			  pagObjetFormularioEmpleado.Formulario(nickName,OtherId,driverLicense,licenseExpiry,ssnNumber,
					  sinNumber,Nationality,maritalStatus,dateBirth,militaryService, rutaCarpeta, generarEvidencia);
			  pagObjetInformacionEmpleado.Consultar(EmployeeName, rutaCarpeta,generarEvidencia);
			  pagObjetCerrarSesion.Cerrarsesion(rutaCarpeta, generarEvidencia);
		  }
		  
	  }
  }
 
  
    
  @AfterClass
  public void afterClass()
  {	  
	  driver.close();
  }
}
