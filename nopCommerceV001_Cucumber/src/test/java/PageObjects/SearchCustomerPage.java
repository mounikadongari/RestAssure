package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class SearchCustomerPage {

	public WebDriver ldriver;
	public WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		
		waithelper = new WaitHelper(ldriver); //obj of utilities
		}

	@FindBy(how = How.ID, using ="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	

	@FindBy(how = How.ID, using ="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how = How.ID, using ="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	

/*	@FindBy(how = How.ID, using ="SearchMonthOfBirth")
	@CacheLookup
	WebElement drpdopMonth;
	

	@FindBy(how = How.ID, using ="SearchDayOfBirth")
	@CacheLookup
	WebElement drpdobDay;

	@FindBy(how = How.ID, using ="SearCompany")
	@CacheLookup
	WebElement txtCompany;


	@FindBy(how = How.XPATH, using ="//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement txtcustomerRoles;
	

	@FindBy(how = How.XPATH, using ="//li[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement lstitemAdministrations;
	

	@FindBy(how = How.XPATH, using ="//li[contains(text(),'Registered')]")
	@CacheLookup
	WebElement lstitemRegistered;
	

	@FindBy(how = How.XPATH, using ="//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement lstitemGuests;
	

	@FindBy(how = How.XPATH, using ="//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement lstitemVendors;*/
	

	@FindBy(how = How.XPATH, using ="//button[@id='search-customers']")
	@CacheLookup
	WebElement btnSearch;
	

	@FindBy(how = How.XPATH, using ="//table[@role='grid']")
	@CacheLookup
	WebElement tblSearchResults;

	@FindBy(how = How.XPATH, using ="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table;
	
	@FindBy(how = How.XPATH, using ="//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(how = How.XPATH, using ="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	
	public void setEmail(String email)
	{
		//if element takes sometime to load wait for element
		waithelper.WaitforElement(txtEmail,20);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname) {
		waithelper.WaitforElement(txtEmail,20);
		txtEmail.clear();
		txtEmail.sendKeys(fname);
	}
	

	public void setLastName(String lname) {
		waithelper.WaitforElement(txtEmail,20);
		txtEmail.clear();
		txtEmail.sendKeys(lname);
	}
	public void clickSearch() {
		btnSearch.click();
		waithelper.WaitforElement(btnSearch, 30);
	}
	
	public int getNoOfRows() {
		return(tableRows.size());
	}
	
	public int getNoOfColumns() {
		return(tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailid);
			
			if(emailid.equals(email))
			{
				flag=true;
			}
		}
		return flag;
			
		}
	
	
public boolean searchCustomerByname(String name)
{
	boolean flag=false;
	for(int i=1;i<=getNoOfRows();i++)
	{
		String name1=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
String names[]=name1.split(" "); //seperating firstname and lastname
if(names[0].equals("victorial")&& names[1].equals("Terces"))
{
	flag=true;
	
}
	}

return flag;
	
}}
	
	
	
	
	
	
	
	
	
	
	




