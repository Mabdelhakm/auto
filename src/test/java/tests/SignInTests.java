package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.Setup;
import pages.HomeScreen;
import pages.SignInPage;
import utils.ReadJson;
import utils.ReadNewExcelFiles;

public class SignInTests extends Setup {
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

	@Test(dataProvider = "wrongdata")
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

	@Test(dataProvider = "wrong_excel_data")
	public void failed_login_excel(String user, String pass) {
		homescreen = new HomeScreen();
		sign_in = new SignInPage();
		homescreen.clickingTheSignInButton();
		sign_in.typing_username(user);
		sign_in.typing_password(pass);
		sign_in.clicking_login_button();
	}

	@DataProvider(name = "wrong_excel_data")
	public Object[][] wrong_excel_data() {
		ReadNewExcelFiles re = new ReadNewExcelFiles("sheet1");
		Object[][] ex = re.read_excel();
		return ex;
	}

	@Test(dataProvider = "wrong_json_data")
	public void failed_json_login(String user) {
		String[] users = user.split(",");
		homescreen = new HomeScreen();
		sign_in = new SignInPage();
		homescreen.clickingTheSignInButton();
		sign_in.typing_username(users[0].replace("\"", ""));
		sign_in.typing_password(users[1].replace("\"", ""));
		sign_in.clicking_login_button();
	}

	@DataProvider(name = "wrong_json_data")
	public Object[] wrong_json_data() throws IOException, ParseException {
		ReadJson re = new ReadJson();
		Object[] ex = re.read_json();
		return ex;
	}

}
