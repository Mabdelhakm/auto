package tests;

import javax.xml.crypto.dsig.SignedInfo;

import org.testng.annotations.Test;

import main.Setup;
import pages.HomeScreen;
import pages.SingInPage;

public class Tests extends Setup {
	HomeScreen homescreen;
	SingInPage sign_in;

	@Test
	public void successfull_login() {
		homescreen = new HomeScreen();
		sign_in = new SingInPage();
		homescreen.clickingTheSignInButton();
		sign_in.typing_username("admin");
		sign_in.typing_password("admin");
		sign_in.clicking_login_button();
	}

}