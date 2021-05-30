import Page from './page';

/**
 * sub page containing specific selectors and methods for a specific page
 */
class LoginPage extends Page {
    /**
     * define selectors using getter methods
     */
    get appHeader () {return $('#header_logo')}
    get signIn () { return $("//a[@class='login']") }
    get inputEmailId () { return $('#email_create') }
    get inputPassword () { return $('#passwd') }
    get createButton () { return $('#SubmitCreate') }
    get signOutButton () { return $('a.logout') }
    

    /**
     * a method to encapsule automation code to interact with the page
     * e.g. to login using username and password
     */
    async signin () {
        await this.appHeader;
        await (await this.signIn).click();
        var email_id = await this.generateRandomString() + '@gmail.com';
        await (await this.inputEmailId).setValue(email_id);
        await (await this.createButton).click();
        return email_id;
    }

    /**
     * overwrite specifc options to adapt it to page object
     */
     
    open () {
        return super.open();
    }

    async generateRandomString () { return Math.random().toString(36).replace(/[^a-z]+/g, '').substr(0, 5) }

    async signout() { await (await this.signOutButton).click() }
}

export default new LoginPage();
