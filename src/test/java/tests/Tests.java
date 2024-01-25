package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.Setup;
import pages.HomeScreen;
import pages.SignInPage;
import utils.ReadJson;
import utils.ReadNewExcelFiles;

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

	@Test(dataProvider = "wrongdata2")
	public void failed_login(String user) {
		String users[]=user.split(",");
		homescreen = new HomeScreen();
		sign_in = new SignInPage();
		homescreen.clickingTheSignInButton();
		sign_in.typing_username(users[0].replace("\"", ""));
		sign_in.typing_password(users[1].replace("\"", ""));
		sign_in.clicking_login_button();
	}

	@DataProvider(name = "wrongdata")
	public Object[][] wrong_data() {
		return new Object[][] { { "jk", "ljnm" }, { "sjd", "sdfkj" } };
	}

	@DataProvider(name = "wrongdata1")
	public Object[][] wrong_excel_data() {
		ReadNewExcelFiles re = new ReadNewExcelFiles("sheet1");
		Object[][] ex = re.read_excel();
		return ex;
	}

	
	
	@DataProvider(name = "wrongdata2")
	public Object[] wrong_json_data() {
		ReadJson re= new ReadJson();
		Object[] ex = re.read_json();
		return ex;
	}

}
