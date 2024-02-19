package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import main.Setup;
import pages.ContactUsPage;
import pages.HomeScreen;
import pages.SignInPage;

public class ContactUsTests extends Setup {
	HomeScreen homescreen;
	SignInPage sign_in;
	ContactUsPage contactus;

	@Test
	public void failed_contact_us_tests() {
		homescreen = new HomeScreen();
		contactus = new ContactUsPage();
		homescreen.clickingTheContactUsButton();
		contactus.typing_in_name_field("admin1");
		contactus.typing_in_email_field("");

		contactus.typing_in_phone_number_field("admin1");
		contactus.typing_in_company_field("admin1");
		contactus.typing_in_questions_field("admin1");
		contactus.typing_in_subject_field("admin1");
		contactus.clicking_submit_button();
		Assert.assertTrue(contactus.check_error());

	}

}
