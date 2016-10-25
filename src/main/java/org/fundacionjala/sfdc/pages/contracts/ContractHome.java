package org.fundacionjala.sfdc.pages.contracts;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.HomeBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * This class represents to opportunity pages.
 */
public class ContractHome extends HomeBase {

    @FindBy(name = "new")
    @CacheLookup
    WebElement newButton;

    @FindBy(css = "span.fFooter a:first-child")
    @CacheLookup
    WebElement editViewLink;

    @FindBy(css = "span.fFooter a:last-child")
    @CacheLookup
    WebElement createNewViewLink;
    /**
     * This method makes click in new button in contract page.
     *
     * @return a contract form page object.
     */
    @Override
    public ContractForm clickNewButton() {
        CommonActions.clickElement(newButton);
        return new ContractForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickCreateNewViewLink() {
        CommonActions.clickElement(createNewViewLink);
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickEditViewLink() {
        CommonActions.clickElement(editViewLink);
        return null;
    }

    /**
     * This method goes to a contract detail.
     *
     * @param url a string with url of the page.
     * @return ContractDetail page object.
     */
    public ContractDetail goContractDetail(String url) {
        driver.navigate().to(url);
        return new ContractDetail();
    }

    /**
     * This method makes click on account link.
     *
     * @param accountName a string with name account.
     * @return ContractDetail page object.
     */
    public ContractDetail clickOnAccount(String accountName) {
        driver.findElement(By.linkText(accountName)).click();
        return new ContractDetail();
    }

}
