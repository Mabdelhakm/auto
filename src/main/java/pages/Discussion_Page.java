package pages;

import org.openqa.selenium.By;

import io.qameta.allure.Allure;
import main.Loggers;
import main.Setup;

public class Discussion_Page extends Setup {

	By inbox_messages_link = By.xpath("(//div[@class='me-2 text-truncate'])[1]");
	By check_inbox_page = By.xpath(
			"//input[@class='o-mail-AutoresizeInput o_input px-1 border-1 text-truncate o-mail-Discuss-threadName lead fw-bold flex-shrink-1 text-dark py-0' and @title='Inbox']");
	By check_starred_page = By.xpath(
			"//input[@class='o-mail-AutoresizeInput o_input px-1 border-1 text-truncate o-mail-Discuss-threadName lead fw-bold flex-shrink-1 text-dark py-0' and @title='Starred']");
	By check_history_page = By.xpath(
			"//input[@class='o-mail-AutoresizeInput o_input px-1 border-1 text-truncate o-mail-Discuss-threadName lead fw-bold flex-shrink-1 text-dark py-0' and @title='History']");
	By history_messages_link = By.xpath("(//div[@class='me-2 text-truncate'])[3]");
	By starred_messages_link = By.xpath("(//div[@class='me-2 text-truncate'])[2]");
	By general_channel_link = By.xpath("//span[text()='general']");
	By message_text_area = By.xpath(
			"//textarea[@class='o-mail-Composer-input form-control bg-view px-3 border-0 rounded-3 shadow-none overflow-auto']");
	By send_message_button = By.xpath(
			"//button[@class='o-mail-Composer-send btn o-last rounded-0 rounded-end-3 btn-link align-self-stretch border-start-0 ms-2 me-3']");
	By all_messages = By.xpath(
			"//div[@class='position-relative text-break o-mail-Message-body mb-0 py-2 px-3 align-self-start rounded-end-3 rounded-bottom-3']");

	By notification_icon = By.name("notification-settings");
	By mute_notifications_radio_button = By.xpath("(//input[@class='form-check-input'])[3]");

	By pinned_messages_icon = By.name("pinned-messages");
	By right_screen_check = By.xpath("//p[@class='fs-6 fw-bold text-uppercase m-0 text-700 flex-grow-1']");
	By start_meeting_button = By.xpath("//button[@class='btn btn-primary rounded']");
	By search_messages_icon = By.name("search-messages");
	By search_messages_field = By.xpath("//input[@class='o_searchview_input flex-grow-1 w-auto border-0']");
	By search_messages_search_buton = By.xpath("//button[@class='btn btn-outline-primary']");
	By search_messages_all_messages = By.xpath(
			"//div[@class='o-mail-MessageCardList d-flex flex-column']//child::div[@class='position-relative text-break o-mail-Message-body mb-0 py-2 px-3 align-self-start rounded-end-3 rounded-bottom-3']");
	By add_users_icon = By.name("add-users");
	By user_search_field = By.xpath("//input[@class='o-discuss-ChannelInvitation-search border form-control']");
	By invite_to_channel_button = By.xpath("//button[@class='btn btn-primary w-100']");
	By voice_settings_icon = By.name("settings");
	By input_device_selection = By.name("inputDevice");
	By push_to_tal_checkbox = By.xpath("(//input[@class='form-check-input'])[1]");
	By last_text = By
			.xpath("//div[@class='d-flex flex-column position-relative flex-grow-1 justify-content-end']//p[last()]");
	By messages_parent = By
			.xpath("//div[@class='d-flex flex-column position-relative flex-grow-1 justify-content-end']");

	public void click_history_messages_link() {
		getCustomActions().explicit_wait_till_visible(history_messages_link, 15);
		getCustomActions().clicking_element(history_messages_link);
		Allure.step("click on the history link");
		Loggers.logger.info("click on the history link");

	}

	public void click_starred_messages_link() {
		getCustomActions().explicit_wait_till_visible(starred_messages_link, 15);
		getCustomActions().clicking_element(starred_messages_link);
		Allure.step("click on the starred messages link");
		Loggers.logger.info("click on the starred messages link");
	}

	public void click_inbox_messages_link() {
		getCustomActions().explicit_wait_till_visible(inbox_messages_link, 15);
		getCustomActions().clicking_element(inbox_messages_link);
		Allure.step("click on the inbox messages link");
		Loggers.logger.info("click on the inbox messages link");
	}

	public void click_general_chanel_link() {
		getCustomActions().explicit_wait_till_visible(general_channel_link, 15);
		getCustomActions().clicking_element(general_channel_link);
		Allure.step("click on the general channel link");
		Loggers.logger.info("click on the general channel link");
	}

	public boolean check_inbox_page() {
		getCustomActions().explicit_wait_till_visible(check_inbox_page, 15);
		return getCustomActions().is_element_displayed(check_inbox_page);
	}

	public boolean check_starred_page() {
		getCustomActions().explicit_wait_till_visible(check_starred_page, 15);
		return getCustomActions().is_element_displayed(check_starred_page);
	}

	public boolean check_history_page() {
		getCustomActions().explicit_wait_till_visible(check_history_page, 15);
		return getCustomActions().is_element_displayed(check_history_page);
	}

	public void type_message(String text) {
		getCustomActions().explicit_wait_till_visible(message_text_area, 15);
		getCustomActions().typing_in_element(message_text_area, text);
		Allure.step("typing messages: " + text + " in the message field");
		Loggers.logger.info("typing messages: " + text + " in the message field");
	}

	public void send_message() {
		getCustomActions().explicit_wait_till_visible(messages_parent, 10);
		String s = getCustomActions().get_certain_property_value(messages_parent, "childElementCount");
		getCustomActions().explicit_wait_til_property_changes(send_message_button, 15, "disabled", "false");
		getCustomActions().clicking_element(send_message_button);
		getCustomActions().explicit_wait_til_property_changes(send_message_button, 15, "disabled", "true");
		getCustomActions().explicit_wait_til_property_not_be(messages_parent, 10, "childElementCount", s);
		Allure.step("click on the send message button");
		Loggers.logger.info("click on the send message button");

	}

	public String check_last_message() {

		return getCustomActions().return_last_element_from_list(all_messages).getText();

	}

	public void click_notification_icon() {
		getCustomActions().explicit_wait_till_visible(notification_icon, 15);
		getCustomActions().clicking_element(notification_icon);
		Allure.step("click on the notification icon");
		Loggers.logger.info("click on the notification icon");

	}

	public void click_mute_notification_icon() {
		getCustomActions().explicit_wait_till_visible(mute_notifications_radio_button, 15);
		getCustomActions().clicking_element(mute_notifications_radio_button);
		Allure.step("click on mute_notifications_radio_button");
		Loggers.logger.info("click on mute_notifications_radio_button");

	}

	public boolean check_notifications() {
		getCustomActions().explicit_wait_till_visible(mute_notifications_radio_button, 15);
		return getCustomActions().is_element_enabled(mute_notifications_radio_button);
	}

	public void click_add_users_icon() {
		getCustomActions().explicit_wait_till_visible(add_users_icon, 15);
		getCustomActions().clicking_element(add_users_icon);
		Allure.step("click on the add users icon");
		Loggers.logger.info("click on the add users icon");
	}

	public void typing_user_name(String text) {
		getCustomActions().explicit_wait_till_visible(user_search_field, 15);
		getCustomActions().typing_in_element(user_search_field, text);
		Allure.step("typing user name in the users field: " + text);
		Loggers.logger.info("typing user name in the users field: " + text);
	}

	public void click_invite_user() {
		getCustomActions().explicit_wait_till_visible(invite_to_channel_button, 15);
		getCustomActions().clicking_element(invite_to_channel_button);
		Allure.step("click on invite to this channel");
		Loggers.logger.info("click on invite to this channel");
	}

	public void click_pinned_messages_icon() {
		getCustomActions().explicit_wait_till_visible(pinned_messages_icon, 15);
		getCustomActions().clicking_element(pinned_messages_icon);
		Allure.step("click on the pinned messagse icon");
		Loggers.logger.info("click on the pinned messagse icon");
	}

	public boolean check_pinned_message() {
		getCustomActions().explicit_wait_till_visible(right_screen_check, 15);
		return getCustomActions().is_element_displayed(right_screen_check);

	}

	public void click_search_messages_icon() {
		getCustomActions().explicit_wait_till_visible(search_messages_icon, 15);
		getCustomActions().clicking_element(search_messages_icon);
		Allure.step("click on the search messages icon");
		Loggers.logger.info("click on the search messages icon");
	}

	public void trype_in_search_messags_field(String text) {
		getCustomActions().explicit_wait_till_visible(search_messages_field, 15);
		getCustomActions().typing_in_element(search_messages_field, text);
		Allure.step("typing: " + text + " in the search field");
		Loggers.logger.info("typing: " + text + " in the search field");
	}

	public void click_search_messages_button() {
		getCustomActions().explicit_wait_till_visible(search_messages_search_buton, 15);
		getCustomActions().clicking_element(search_messages_search_buton);
		Allure.step("click on the search messages button");
		Loggers.logger.info("click on the search messages button");
	}

	public boolean check_searched_messages(String text) {
		getCustomActions().explicit_wait_till_visible(search_messages_all_messages, 15);
		return getCustomActions().is_text_correct(search_messages_all_messages, text);
	}

	public void click_voice_settings_icon() {
		getCustomActions().explicit_wait_till_visible(voice_settings_icon, 15);
		getCustomActions().clicking_element(voice_settings_icon);
		Allure.step("click on the voice settings icon");
		Loggers.logger.info("click on the voice settings icon");
	}

	public void select_audio_drop_down_list(int index) {
		getCustomActions().explicit_wait_till_visible(input_device_selection, 15);
		getCustomActions().drop_down_list_by_index(input_device_selection, index);
		Allure.step("select the audio type");
		Loggers.logger.info("select the audio type");
	}

	public String check_audio_drop_down_list() {
		getCustomActions().explicit_wait_till_visible(input_device_selection, 15);
		return getCustomActions().get_text_drop_down_list(input_device_selection);

	}

	public void check_push_to_talk() {
		getCustomActions().explicit_wait_till_visible(push_to_tal_checkbox, 15);
		if (getCustomActions().is_element_selected(push_to_tal_checkbox) != true)
			getCustomActions().clicking_element(push_to_tal_checkbox);

	}

	public boolean check_push_to_talk_checkbox() {
		return getCustomActions().is_element_selected(push_to_tal_checkbox);
	}

	public boolean check_page() {

		getCustomActions().explicit_wait_till_visible(inbox_messages_link, 20);
		return getCustomActions().is_element_displayed(inbox_messages_link);
	}
}
