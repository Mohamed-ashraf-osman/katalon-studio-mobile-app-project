import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'open application'
Mobile.startApplication('C:\\Users\\basse\\Downloads\\apk\\General-Store.apk', true)

Mobile.tap(findTestObject('Object Repository/folder object/android.widget.Spinner'), 0)

'scroll to find the country'
Mobile.scrollToText('Egypt')

'choose Egypt '
Mobile.tap(findTestObject('Object Repository/folder object/android.widget.TextView - Egypt'), 0)

'Enter name '
Mobile.setText(findTestObject('Object Repository/folder object/android.widget.EditText - Enter name here'), 'Mohamed Ashraf', 
    0)

'choose the gender'
Mobile.tap(findTestObject('Object Repository/folder object/android.widget.RadioButton - Male'), 0)

'click on lets shop button'
Mobile.tap(findTestObject('Object Repository/folder object/android.widget.Button - Lets  Shop'), 0)

'add first product'
Mobile.tap(findTestObject('Object Repository/folder object/android.widget.TextView - ADD TO CART'), 0)

'add second product'
Mobile.tap(findTestObject('Object Repository/folder object/android.widget.TextView - ADD TO CART (1)'), 0)

'click on cart button'
Mobile.tap(findTestObject('Object Repository/folder object/android.widget.ImageButton'), 0)

'Assert on first  item price'
WebUI.verifyElementText(findTestObject('folder object/android.widget.TextView - 160.97'), '160.97')

Mobile.getText(findTestObject('Object Repository/folder object/android.widget.TextView - 120.0'), 0)

'get text'
Mobile.getText(findTestObject('Object Repository/folder object/android.widget.TextView - 160.97'), 0)

'Assert on second item price'
WebUI.verifyElementText(findTestObject('folder object/android.widget.TextView - 120.0'), '120.0')

Mobile.getText(findTestObject('Object Repository/folder object/android.widget.TextView -  280.97'), 0)

'Assert on cart total amount'
WebUI.verifyElementText(findTestObject('folder object/android.widget.TextView -  280.97'), '280.97')

Mobile.getText(findTestObject('Object Repository/folder object/android.widget.TextView -  280.97'), 0)

Mobile.closeApplication()

