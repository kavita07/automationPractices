import { Given, When, Then, And } from '@cucumber/cucumber';

import LoginPage from '../../pageobjects/login.page';
import RegistrationPage from '../../pageobjects/registration.page';
import LoginData from '../../testdata/logindata';

const fs = require('fs');
var generatedId;
const pages = {
    login: LoginPage,
    register: RegistrationPage
}

Given(/^I am on the sigin page$/, async () => {
    await LoginPage.open();
});

When(/^I click on create my acount button$/, async () => {
    generatedId = await LoginPage.signin();
         await expect(RegistrationPage.registrationPageHeading).toBeExisting();
     });

     When(/^I select title as (.+)$/, async (title) => {
    await RegistrationPage.selectGenderTitle(title);
})

When(/^I enter first name first name as (\w+)$/, async (firstName) => {
    await RegistrationPage.enterFirstName(firstName)
})

When(/^I enter last name first name as (\w+)$/, async (lastName) => {
    await RegistrationPage.enterLastName(lastName)
})

When(/^I enter password$/, async () => {
    //read password from file
    await RegistrationPage.enterPassword(LoginData.password);
})

When(/^I enter address line1 as (.+)$/, async (address) => {
    await RegistrationPage.enterAddress(address)
})

When(/^I enter city as (\w+)$/, async (city) => {
    await RegistrationPage.enterCity(city)
})

When(/^I select state as (\w+)$/, async (state) => {
    await RegistrationPage.selectState(state)
})

When(/^I enter zipcode as (.+)$/, async (zipc) => {
    await RegistrationPage.enterZipcode(zipc)
})

When(/^I select country as (.+)$/, async (countryName) => {
    await RegistrationPage.selectCountry(countryName)
})

When(/^I enter additional phone no as (.+)$/, async (phoneNumber) => {
    await RegistrationPage.enterAdditionalInfor(phoneNumber);
})

When(/^I enter mobile no (.+)$/, async (mobileNumber) => {
    await RegistrationPage.enterMobileno(mobileNumber)
})

When(/^I click on Register button$/, async () => {
    await RegistrationPage.clickOnRegisterButton()
})

When(/^I should see on landing screen correct (\w+) and (\w+) is displayed$/, async (firstName, lastName) => {
    await expect(await RegistrationPage.headerUserInfo).toHaveText(firstName +' ' +lastName);
    fs.writeFileSync('./testdata/generatedid', generatedId, 'utf8');
});

When(/^I verify logout from application$/, async () => {
    await LoginPage.signout();
    expect(LoginPage.signIn).toBeExisting();
})

