package com.sqa.rd;

import static org.testng.Assert.*;

import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class EbayTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://www.ebay.com/";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		this.driver.quit();
		String verificationErrorString = this.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test
	public void testEbay() throws Exception {
		this.driver.get(this.baseUrl + "/");
		this.driver.findElement(By.linkText("Sign in")).click();
		this.driver.findElement(By.xpath("//div[@id='pri_signin']/div[4]/span[2]/input")).clear();
		this.driver.findElement(By.xpath("//div[@id='pri_signin']/div[4]/span[2]/input"))
				.sendKeys("richadighe@gmail.com");
		this.driver.findElement(By.xpath("//div[@id='pri_signin']/div[5]/span[2]/input")).clear();
		this.driver.findElement(By.xpath("//div[@id='pri_signin']/div[5]/span[2]/input")).sendKeys("richaborn@4286");
		this.driver.findElement(By.id("sgnBt")).click();
		this.driver.findElement(By.id("gh-ac")).clear();
		this.driver.findElement(By.id("gh-ac")).sendKeys("canvas");
		this.driver.findElement(By.id("gh-btn")).click();
		this.driver.findElement(By.cssSelector("img.img")).click();
		this.driver.findElement(By.id("isCartBtn_btn")).click();
		this.driver.findElement(By.id("gh-cart-1")).click();
		this.driver.findElement(By.linkText("Remove")).click();
		this.driver.findElement(By.id("gh-ug")).click();
		this.driver.findElement(By.linkText("Sign out")).click();
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = this.driver.switchTo().alert();
			String alertText = alert.getText();
			if (this.acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			this.acceptNextAlert = true;
		}
	}

	private boolean isAlertPresent() {
		try {
			this.driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
