package shopping
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class ShoppingSteps {

	@Given("I open the General Store app on an Android device")
	def openApp() {
		Mobile.startApplication('C:\\Users\\basee\\Downloads\\apk\\Ger.apk', false)
	}

	@And("I select {string} country from the dropdown list")
	def selectCountry(String country) {
		Mobile.tap(findTestObject('android.widget.Spinner'), 0)
		Mobile.scrollToText(country)
		Mobile.tap(findTestObject('android.widget.TextView', [('text'): country]), 0)
	}

	@And("I enter my name as {string} in the text field")
	def enterName(String name) {
		Mobile.setText(findTestObject('android.widget.EditText', [('hint'): 'Enter name']), name, 0)
	}

	@And("I select my gender as {string}")
	def selectGender(String gender) {
		def genderObject = gender.equalsIgnoreCase('Male') ? 'android.widget.RadioButton - Male' : 'android.widget.RadioButton - Female'
		Mobile.tap(findTestObject(genderObject), 0)
	}

	@When("I click on the {string} button")
	def clickButton(String buttonName) {
		Mobile.tap(findTestObject("android.widget.Button - " + buttonName), 0)
	}

	@And("I add {string} to the cart")
	def addProductToCart(String productName) {
		Mobile.tap(findTestObject("android.widget.TextView - ADD TO CART", [('text'): productName]), 0)
	}

	@Then("I should see that the total amount equals the sum of {string} price and {string} price")
	def verifyTotalAmount(String product1Price, String product2Price) {
		def total = product1Price.toFloat() + product2Price.toFloat()
		def displayedTotal = Mobile.getText(findTestObject('android.widget.TextView - Total Amount'), 0).toFloat()
		assert total == displayedTotal
    }
}