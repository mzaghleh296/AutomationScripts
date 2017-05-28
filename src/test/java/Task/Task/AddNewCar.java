package Task.Task;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import task.waseet.base.Common;

public class AddNewCar extends Common
{
@Test
public void addCar() {
try {
WebElement element = null;
// Go to Car Form Page
//fdhjhgdjg
driver.findElement(By.xpath(getPageElement("Make_Free_Ad_btn"))).click();
System.out.println("mmmmmmmoath");

driver.findElement(By.xpath(getPageElement("Popover_Car_btn"))).click();
// Start Filling Form fields
LOGGER.info("Start Filling Car Form Fields");

// Choose Car Type Radio
driver.findElement(By.xpath(getPageElement("Car_New_Radio"))).click();

// Fill Title Field
driver.findElement(By.xpath(getPageElement("Car_Title_txt"))).sendKeys(getPageElement("Car_Title_Value"));

// Select Car Type
driver.findElement(By.xpath(getPageElement("Car_Type_List"))).click();
driver.findElement(By.xpath(getPageElement("Car_Type_Value"))).click();

// Select Car Brand
driver.findElement(By.xpath(getPageElement("Car_Brand_List"))).click();
driver.findElement(By.xpath(getPageElement("Car_Brand_Value"))).click();

// Select Car Body Type
driver.findElement(By.xpath(getPageElement("Car_BodyType_List"))).click();
driver.findElement(By.xpath(getPageElement("Car_BodyType_Value"))).click();

// Select Car Transmission Type
driver.findElement(By.xpath(getPageElement("Car_Transmission_List"))).click();
driver.findElement(By.xpath(getPageElement("Car_Transmission_Value"))).click();

// Select Car Color Type
driver.findElement(By.xpath(getPageElement("Car_Color_List"))).click();
driver.findElement(By.xpath(getPageElement("Car_Color_Value"))).click();

// Select Car Color Type
driver.findElement(By.xpath(getPageElement("Car_Year_List"))).click();
driver.findElement(By.xpath(getPageElement("Car_Year_Value"))).click();

// Fill Kilometers Field
driver.findElement(By.xpath(getPageElement("Car_Kilometers_txt")))
  .sendKeys(getPageElement("Car_Kilometers_Value"));

// Fill Price Field
driver.findElement(By.xpath(getPageElement("Car_Price_txt"))).sendKeys(getPageElement("Car_Price_Value"));

// Fill Description Field
driver.findElement(By.xpath(getPageElement("Car_Description_txt")))
  .sendKeys(getPageElement("Car_Description_Value"));

// Select City
driver.findElement(By.xpath(getPageElement("Car_City_List"))).click();
driver.findElement(By.xpath(getPageElement("Car_City_Value"))).click();

// Select Region
driver.findElement(By.xpath(getPageElement("Car_Region_List"))).click();
driver.findElement(By.xpath(getPageElement("Car_Region_Value"))).click();

// Select Country Code for Phone
driver.findElement(By.xpath(getPageElement("Car_Phone_Code_List"))).click();
driver.findElement(By.xpath(getPageElement("Car_Phone_Code_Value"))).click();

// Fill Phone Field
element = driver.findElement(By.xpath(getPageElement("Car_Phone_txt")));
element.clear();
element.sendKeys(getPageElement("Car_Phone_Value"));

// Fill Email Field
element = driver.findElement(By.xpath(getPageElement("Car_Email_txt")));
element.clear();
element.sendKeys(getPageElement("Car_Email_Value"));

// Click Login button
driver.findElement(By.xpath(getPageElement("Car_Login_btn"))).click();

// Change from Main window to Login Window
String currentWindow = driver.getWindowHandle();

for (String windowHandle : driver.getWindowHandles()) {
 driver.switchTo().window(windowHandle);
}


// Back to Main Window
driver.switchTo().window(currentWindow);

// Check NID for the ad if created
Assert.assertNotNull(driver.getCurrentUrl().replaceAll("\\D+", ""), "The ad isn't created");

// Click Confirm button from upgrade page
driver.findElement(By.xpath(getPageElement("Car_Confirm_btn"))).click();

// Close Overlay on new page

// Check confirmation message
element = driver.findElement(By.xpath(getPageElement("Car_Confirmation_Box")));
Assert.assertTrue(
  element.getText().contains(getPageElement("Ad_Successful_Armsg"))
    || element.getText().contains(getPageElement("Ad_Successful_Enmsg")),
  "Successfull message isn't displayed please check: " + element.getText());

// Click Continue button for successful message box
driver.findElement(By.xpath(getPageElement("Car_ConfirmationBox_btn"))).click();

} catch (Throwable e) {
e.printStackTrace(System.out);
Assert.fail();
}
}

}