package pages;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddClient {

    @FindBy(xpath="//input[@id='client_name']")
    WebElement clientName;

    @FindBy (xpath="//input[@id='client_surname']")
    WebElement clientSurname;

    @FindBy (xpath="//input[@id='client_address_1']")
    WebElement clientAddress1;

    @FindBy (xpath="//input[@id='client_address_2']")
    WebElement clientAddress2;

    @FindBy (xpath="//input[@id='client_city']")
    WebElement clientCity;
    @FindBy (xpath="//input[@id='client_state']")
    WebElement clientState;

    @FindBy (xpath="//input[@id='client_zip']")
    WebElement clientZip;

    @FindBy (xpath="//input[@id='client_phone']")
    WebElement clientPhone;

    @FindBy (xpath="//input[@id='client_fax']")
    WebElement clientFax;

    @FindBy (xpath="//input[@id='client_mobile']")
    WebElement clientMobile;

    @FindBy (xpath="//input[@id='client_email']")
    WebElement clientEmail;

    @FindBy (xpath="//input[@id='client_web']")
    WebElement clientWeb;

    @FindBy (xpath="//input[@id='client_vat_id']")
    WebElement clientVat;

    @FindBy (xpath="//input[@id='client_tax_code']")
    WebElement clientTax;

    @FindBy (xpath="//i[@class='fa fa-check']")
    WebElement btnSave;

    public AddClient(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void clickSave()
    {
        btnSave.click();
    }

    public void setClientName(String name)
    {
        clientName.sendKeys(name);
    }

    public void setClientSurname(String surname)
    {
        clientSurname.sendKeys(surname);
    }

    public void setClientAddress1(String address1)
    {
        clientAddress1.sendKeys(address1);
    }

    public void setClientAddress2(String address2)
    {
        clientAddress2.sendKeys(address2);
    }

    public void setClientCity(String city)
    {
        clientCity.sendKeys(city);
    }

    public void setClientState(String state)
    {
        clientState.sendKeys(state);
    }

    public void setClientZip(String zip)
    {
        clientZip.sendKeys(zip);
    }

    public void setClientPhone(String phone)
    {
        clientPhone.sendKeys(phone);
    }
    public void setClientFax(String fax)
    {
        clientFax.sendKeys(fax);
    }

    public void setClientMobile(String mobile)
    {
        clientMobile.sendKeys(mobile);
    }

    public void setClientEmail(String email)
    {
        clientEmail.sendKeys(email);
    }

    public void setClientWeb(String web)
    {
        clientWeb.sendKeys(web);
    }

    public void setClientVat(String vat)
    {
        clientVat.sendKeys(vat);
    }

    public void setClientTax(String tax)
    {
        clientTax.sendKeys(tax);
    }

    @FindBy (xpath="//span[@id='select2-client_language-container']")
    WebElement containerLanguage;

    @FindBy (xpath="//input[@role='searchbox']")
    WebElement searchBox;

    WebDriver driver;
    public void setlanguage(String language)
    {
        containerLanguage.click();
        searchBox.sendKeys(language);
        driver.findElement(By.xpath("//li[normalize-space()='"+language+"']")).click();
    }


    @FindBy (xpath="//span[@id='select2-client_country-container']")
    WebElement containerCountry;

    public void setCountry(String country)
    {
        containerCountry.click();
        searchBox.sendKeys(country);
        driver.findElement(By.xpath("//li[normalize-space()='"+country+"']")).click();

    }

    @FindBy (xpath="//span[@id='select2-client_gender-container']")
    WebElement containerGender;

    public void setGender(String gender)
    {
        containerGender.click();
        driver.findElement(By.xpath("//li[normalize-space()='"+gender+"']")).click();

    }

    @FindBy (xpath="//input[@id='client_birthdate']")
    WebElement birthDate;

    public void setDate(String dateStr) throws ParseException  // dd/MM/yyyy
    {
        birthDate.click();

        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
        String currDateStr = driver.findElement(By.xpath("//th[@class='datepicker-switch']")).getText();
        System.out.println(currDateStr);

        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDateStr);

        int monthDiff = Months.monthsBetween(

               new DateTime(currDate).withDayOfMonth(1),

               new DateTime(setDate).withDayOfMonth(1)

        ).getMonths();

        System.out.println("Month diff="+monthDiff); // + 7

        boolean isFuture = true;

        if (monthDiff<0)
        {
            isFuture = false;
            monthDiff = (-1) * monthDiff;
        }

        for (int i=0 ;i<monthDiff;i++ )
        {
            if (isFuture)
                driver.findElement(By.xpath("//th[@class='next']")).click(); // click next
            else
                driver.findElement(By.xpath("//th[@class='prev']")).click(); // click prev
        }


    }



}
