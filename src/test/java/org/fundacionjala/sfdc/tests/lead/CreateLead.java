package org.fundacionjala.sfdc.tests.lead;


import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.leads.LeadDetails;
import org.fundacionjala.sfdc.pages.leads.LeadForm;
import org.fundacionjala.sfdc.pages.leads.LeadHome;

/**
 * This class verify the Creation of LeadHome.
 */
public class CreateLead {
    private LeadHome leadHomePage;
    private MainApp mainApp;
    private TabBar tabBar;
    private LeadDetails leadDetails;
    private LoginPage loginPage;
    public static final String LEAD_DATA_PATH = "lead/CreateLeadData.json";
    private Map<String, String> valuesMapJson;


    /**
     * This method execute the preconditions to make the validation to the creation of lead.
     */
    @BeforeTest
    public void setUp() {
        tabBar = new MainApp().goToTabBar();
        leadHomePage = tabBar.clickLead();
        // create campaign
    }

    /**
     * This method create a new LeadFields and make the corresponding assertions.
     */
    @Test
    public void createLeadTest(){
        LeadForm leadForm = leadHomePage.clickNewButton();
        valuesMapJson = JsonMapper.getMapJson(LEAD_DATA_PATH);
        leadForm.fillTheForm(valuesMapJson);
        leadDetails = leadForm.clickSaveButton();
        new AssertLead().assertDetailValues(leadDetails, valuesMapJson);

    }

    /**
     * This method delete the created LeadFields.
     */
    @AfterMethod
    public void tearDown() {
       leadDetails.clickDeleteButton();
    }
}

