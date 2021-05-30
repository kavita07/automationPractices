import Page from './page';

/**
 * sub page containing specific selectors and methods for a specific page
 */
class RegistrationPage extends Page{
    get appHeader () {return $('#header_logo')}
    get registrationPageHeading () { return $('.page-heading') }
    get maleGender () { return $('#id_gender1') }
    get femaleGender () { return $('#id_gender2') }
    get firstNameTextBox () { return $('#customer_firstname') }
    get lastNameTextBox () { return $('#customer_lastname') }
    get passwordTextBox () { return $('#passwd') }
    get addressLine1 () { return $('#address1') }
    get cityTextBox () { return $('#city') }
    get stateDropDown () { return $('#id_state') }
    get zipcode () { return $('#postcode') }
    get countryDropdown () { return $('#id_country') }
    get additionalInfo () { return $('#other') }
    get mobileNo () { return $('#phone_mobile') }
    get registerButton () { return $('#submitAccount') }
    get headerUserInfo () { return $$('a.account span') }

    
    async selectGenderTitle(title) {
        await this.appHeader;
        if (title === ("Mr.")){ 
            await (await this.maleGender).click(); 
        }
		else { 
            await (await this.femaleGender).click()
        }
    }
    async enterFirstName (fname) { 
        await (await this.firstNameTextBox).setValue(fname)
    }
    async enterLastName (lname) { 
        await (await this.lastNameTextBox).setValue(lname) 
    }
    async enterPassword (password) {
        await (await this.passwordTextBox).setValue(password)
    }
    async enterAddress (address) { 
        await (await this.addressLine1).setValue(address) 
    }
    async enterCity (city) { 
        await (await this.cityTextBox).setValue(city) 
    }
    async selectState (stateName) { 
        await (await this.stateDropDown).selectByVisibleText(stateName) 
    }
    async enterZipcode (zipcod) { 
        await (await this.zipcode).setValue(zipcod) 
    }
    async selectCountry (countryName) { 
        await (await this.countryDropdown).selectByVisibleText(countryName) 
    }
    async enterAdditionalInfor (addinformation) { 
        await (await this.additionalInfo).setValue(addinformation) 
    }
    async enterMobileno (mobileno) { 
        await (await this.mobileNo).setValue(mobileno) 
    }
    async clickOnRegisterButton () { 
        await (await this.registerButton).click() 
    }   

    open () {
        return super.open();
    }

}

export default new RegistrationPage();