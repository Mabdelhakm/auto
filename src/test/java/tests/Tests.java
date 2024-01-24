package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.Setup;
import pages.HomeScreen;
import pages.SignInPage;
import utils.ReadExcel;

public class Tests extends Setup {
	HomeScreen homescreen;
	SignInPage sign_in;

	@Test
	public void successfull_login() {
		homescreen = new HomeScreen();
		sign_in = new SignInPage();
		homescreen.clickingTheSignInButton();
		sign_in.typing_username("admin");
		sign_in.typing_password("admin");
		sign_in.clicking_login_button();
	}

	@Test(dataProvider = "wrongdata1")
	public void failed_login(String user, String pass) {
		homescreen = new HomeScreen();
		sign_in = new SignInPage();
		homescreen.clickingTheSignInButton();
		sign_in.typing_username(user);
		sign_in.typing_password(pass);
		sign_in.clicking_login_button();
	}

	@DataProvider(name = "wrongdata")
	public Object[][] wrong_data() {
		return new Object[][] { { "jk", "ljnm" }, { "sjd", "sdfkj" } };
	}

	@DataProvider(name = "wrongdata1")
	public Object[][] wrong_excel_data() {
		ReadExcel re = new ReadExcel();
		Object[][] ex = re.read_excel();
		return ex;
	}

}
