package com.odoo.webutils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;
import com.odoo.generic.Driver;
import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;

public class MyTestListener implements ITestListener, WebDriverEventListener
{
	public static Logger log;
	public static int executionCount, passCount, failCount, skipCount = 0;
	public WebDriver driver;
	public Capabilities cap;
	
	long startTime, stopTime = 0;

	@Override
	public void onTestStart(ITestResult result) 
	{
		executionCount++;
		log.info(result.getName()+" script execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		passCount++;
		log.info(result.getName()+" script is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		failCount++;
		log.warn(result.getName()+" script is failed");
		
		TakesScreenshot ts=(TakesScreenshot) Driver.getDriver();
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		File destFile=new File(GenericLib.dir+"/screenshots/"+
		                     result.getName()+sdf.format(new Date())+".png");
		try 
		{
			Files.copy(srcFile, destFile);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		log.info("Screenshot has been taken ");
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		skipCount++;
		log.info(result.getName()+" script is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) 
	{
		startTime=System.currentTimeMillis();
		
		String filepath = GenericLib.getConfigFile();
		String system = GenericLib.getValue(filepath, "system");
		String browserName = GenericLib.getValue(filepath, "browserName");
		String headless = GenericLib.getValue(filepath, "headless");
		String application=GenericLib.getValue(GenericLib.getConfigFile(), "application");
		
//		String browserName = System.getProperty("browser");
//		String headless = System.getProperty("headless");
		
		driver=DriverFactory.launch(system, browserName, headless);
		cap=((RemoteWebDriver)driver).getCapabilities();  
		
		String VerisonName=cap.getVersion().toString();
		try 
		{
			File file= new File("./allure-results/environment.properties");
			FileOutputStream fos=new FileOutputStream(file);

			Properties prop= new Properties();

			prop.setProperty("ApplicationName",application);
			prop.setProperty("BrowserName", browserName);
			prop.setProperty("PlatfromName", GenericLib.os);
			prop.setProperty("System", system);
			prop.setProperty("VerisonName", VerisonName);
			prop.store(fos, "Environment-DATA");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		System.setProperty("timestamp", sdf.format(new Date()));
		
		System.setProperty("logpath", GenericLib.dir+"/reports/logs");
		System.setProperty("htmlpath", GenericLib.dir+"/reports/HTML");
		
		PropertyConfigurator.configure("log4j.properties");
		log=Logger.getLogger(this.getClass());
		
		log.info("Framework execution starts");
		
		
		
		//WebDriver driver = DriverFactory.launch(system, browserName, headless);
		driver.manage().window().maximize();
		Driver.setDriver(driver);
		log.info("Browser Launched and maximized");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		Driver.getDriver().close();
		if (Driver.getDriver()!=null) 
		{
			Driver.getDriver().quit();
		}
		log.info("Browser Closed");
		
		
		Workbook wb=new XSSFWorkbook();
		Sheet sh = wb.createSheet("Odoo Execution Report");
		Row rw = sh.createRow(0);
		rw.createCell(0).setCellValue("Scripts Execution");
		rw.createCell(1).setCellValue("Status");
		
		ExcelUtilities eu=new ExcelUtilities();
		eu.writeData(sh, 1, "Total scripts executed", executionCount);
		eu.writeData(sh, 2, "Total scripts passed", passCount);
		eu.writeData(sh, 3, "Total scripts failed", failCount);
		eu.writeData(sh, 4, "Total scripts skipped", skipCount);
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
	String filepath = GenericLib.dir+
				"/reports/excelreport/Report"+sdf.format(new Date())+".xlsx";
		try
		{
			FileOutputStream fos=new FileOutputStream(new File(filepath));
			wb.write(fos);
			log.info("ExcelReport generated");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		stopTime=System.currentTimeMillis();
		double totalTime=(stopTime-startTime)/1000;
		log.info("Framework execution Time Taken: "+totalTime+"seconds");
		log.info("Framework execution ends");
	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable t, WebDriver driver) 
	{
		log.fatal(t.getMessage());
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
	
}
