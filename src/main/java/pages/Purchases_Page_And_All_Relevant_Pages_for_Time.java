package pages;

import org.openqa.selenium.By;

import io.qameta.allure.Allure;
import main.Loggers;
import main.Setup;

public class Purchases_Page_And_All_Relevant_Pages_for_Time extends Setup {
	By x_sign=By.xpath("//span[@class='min-w-0 text-truncate']");
	By first_comapny_record = By.xpath(
			"(//td[@class='o_data_cell cursor-pointer o_field_cell o_list_many2one o_required_modifier o_readonly_modifier'])[1]");
	By home_side_menu = By.xpath("//button[@title='Home Menu']");
	By purchase_link_side_menu = By.xpath("//a[text()='Purchase']");
	By inventory_link_side_menu = By.xpath("//a[text()='Inventory']");
	By add_new_button = By.xpath("(//button[@class='btn btn-primary o_list_button_add'])[2]");
	By waiting_button = By
			.xpath("(//a[@class='btn btn-primary w-100 h-100 border-0 rounded-0 text-capitalize fw-normal'])[2]");
	By to_send_button = By
			.xpath("(//a[@class='btn btn-primary w-100 h-100 border-0 rounded-0 text-capitalize fw-normal'])[1]");
	By late_button = By
			.xpath("(//a[@class='btn btn-primary w-100 h-100 border-0 rounded-0 text-capitalize fw-normal'])[3]");
	By edit_table_form = By.xpath("//button[@class='btn p-0 o-dropdown dropdown-toggle dropdown']");
	By company_checkbox = By.xpath("//input[@name='company_id']");
	By select_all_checkbox = By.id("checkbox-comp-1");
	By reference_names = By.xpath(
			"//td[@class='o_data_cell cursor-pointer o_field_cell o_list_char o_required_modifier o_readonly_modifier fw-bold']");
	By reference_id_in_page = By
			.xpath("//div[@class='o_field_widget o_readonly_modifier o_required_modifier o_field_char']");
	By vendor_selection = By.id("partner_id_0");
	By vendor_elements = By.xpath("(//div[@class='o-autocomplete dropdown'])[1]//child::ul");
	By add_a_product_rfq_page = By.xpath("//a[text()='Add a product']");
	By type_quantity = By.xpath("//div[@name='product_qty']");
	By type_product_name = By.xpath("(//input[@class='o-autocomplete--input o_input'])[3]");
	By uom = By.xpath("//div[@name='product_uom']");
	By unit_price = By.xpath("//div[@name='price_unit']");
	By confirm_order_button = By.id("draft_confirm");
	By confirm_paymnet = By.xpath("(//button[@class='btn btn-primary'])[1]");
	By purchase_number = By
			.xpath("//div[@class='o_field_widget o_readonly_modifier o_required_modifier o_field_char']");
	By quantity_amount = By.xpath("(//input[@class='o_input'])[2]");
	By receipts_link_button = By.xpath("//button[@name='get_action_picking_tree_ready']");
	By receipt_link = By.name("incoming_picking_count");
	By inventory_order_numer = By.xpath("//div[@class='o_field_widget o_readonly_modifier o_field_char']");
	By validate_button = By.name("button_validate");
	By create_bill = By.name("action_create_invoice");
	By confirm_button = By.name("action_post");
	By bill_date_field = By.id("invoice_date_0");
	By credit_note = By.id("action_reverse");
	By register_payment_button = By.id("account_invoice_payment_btn");
	By create_payment = By.name("action_create_payments");
	By check_send = By.xpath("//small[@class='o_facet_value']");
	By compny_column = By.xpath("//span[@class='d-block min-w-0 text-truncate flex-grow-1' and text()='Company']");
	By schedule_button = By.xpath("//span[text()='Schedule']");
	By activity = By.xpath("//span[text()='Activities']");
	By tax_field = By.xpath("//td[@class='o_data_cell cursor-pointer o_field_cell o_many2many_tags_cell']");
	By inventory_page_search_field = By
			.xpath("//input[@class='o_searchview_input o_input d-print-none flex-grow-1 w-auto border-0']");
	By cancel_tax = By.xpath("//i[@class='oi oi-close align-text-top']");
	By inventory_first_record_source_document = By
			.xpath("//td[@class='o_data_cell cursor-pointer o_field_cell o_list_char']");
	By search_criteria = By.xpath("(//small[@class='o_facet_value' ])[3]");
	By inv_search_condition = By.xpath("(//small[@class='o_facet_value'])[1]");
	By search_criteria_purchase_page = By.xpath("(//small[@class='o_facet_value' ])[1]");
	By done_button = By.xpath("//button[@class='btn btn-secondary o_arrow_button o_first o_arrow_button_current']");
	By invtitle = By.xpath("//span[@class='min-w-0 text-truncate']");
	By products_selection = By.xpath("(//div[@class='o-autocomplete dropdown'])[3]//child::ul");
	By wasting_time = By.name("purchase_delivery_invoice");
	By table_body = By.tagName("tbody");
	By text_not_found=By.xpath("//p[@class='o_view_nocontent_smiling_face' ]");
	By inv_cancel_search=By.xpath("(//button[@class='o_facet_remove oi oi-close btn btn-link py-0 px-2 text-danger' ])[3]");
	By vendor_selection_elements=By.xpath("//li[@class='o-autocomplete--dropdown-item ui-menu-item d-block']");
	public boolean check_done_button(String text) {
		getCustomActions().explicit_wait_till_attribute_to_be(done_button, "aria-label", "Current", 10);
		if (getCustomActions().get_element_attribute_aria_label(done_button).equals(text))
			return true;
		else
			return false;
	}

	public void select_vendor(int index) {
		getCustomActions().explicit_wait_till_visible(vendor_selection, 10);
		getCustomActions().clicking_element(vendor_selection);
		getCustomActions().explicit_wait_till_visible(vendor_elements, 20);

		getCustomActions().explicit_wait_til_property_not_be(vendor_elements, 20,"childElementCount","1");
		if (index == 0) {
			getCustomActions().clicking_enter(vendor_selection);
		} else {
			for (int i = 0; i < index; i++) {
				getCustomActions().clicking_arrow_down_key(vendor_selection);
			}
		}
		getCustomActions().clicking_enter(vendor_selection);
		getCustomActions().explicit_wait_till_invisibility(vendor_elements, 10);
	}

	public void select_vendor_with_search(int index, String text) {
		getCustomActions().explicit_wait_till_visible(vendor_selection, 10);
		getCustomActions().typing_in_element(vendor_selection, text);
		getCustomActions().explicit_wait_till_visible(vendor_elements, 10);

		if (index == 0) {
			getCustomActions().clicking_enter(vendor_selection);
		} else {
			for (int i = 0; i < index; i++) {
				getCustomActions().clicking_arrow_down_key(vendor_selection);
			}
			getCustomActions().clicking_enter(vendor_selection);
		}
		getCustomActions().clicking_enter(vendor_selection);
		Allure.step("choosing vendor with index " + index + "from the drop down list");
		Loggers.logger.info("choosing vendor with index " + index + " from the drop down list");
	}

	public boolean check_search_field_inventory_page(String text) {
		getCustomActions().explicit_wait_till_visible(search_criteria, 10);
		getCustomActions().explicit_wait_till_visible(inventory_first_record_source_document, 10);
		return getCustomActions().is_text_correct(search_criteria, text.toLowerCase());
	}

	public boolean check_search_field_purchase_page(String text) {
		getCustomActions().explicit_wait_till_visible(search_criteria_purchase_page, 10);
//		getCustomActions().explicit_wait_till_visible(inventory_first_record_source_document, 10);

		return getCustomActions().is_text_correct(search_criteria_purchase_page, text.toLowerCase());
	}

	public boolean check_company_column() {
			return getCustomActions().is_element_displayed(compny_column);


	}

	public boolean check_credit_note() {
		getCustomActions().explicit_wait_till_visible(credit_note, 10);
		return getCustomActions().is_element_displayed(credit_note);
	}

	public boolean check_schedule_button() {
		getCustomActions().explicit_wait_till_visible(schedule_button, 20);
		return getCustomActions().is_element_displayed(schedule_button);
	}

	public void clicking_first_company_record() {
		getCustomActions().explicit_wait_till_visible(first_comapny_record, 20);
		getCustomActions().clicking_element(first_comapny_record);
		Allure.step("clicking on first company record");
		Loggers.logger.info("clicking on first company record");
	}

	public void clicking_confirm_payment() {
		getCustomActions().explicit_wait_till_visible(confirm_paymnet, 20);
		getCustomActions().clicking_element(confirm_paymnet);
		getCustomActions().explicit_wait_till_visible(register_payment_button, 20);
	}
	
	public void no_search(String text) {
		if(getCustomActions().is_element_displayed(text_not_found)==true) {
			getCustomActions().clicking_element(inv_cancel_search);			
			getCustomActions().explicit_wait_till_visible(inventory_first_record_source_document, 20);
			getCustomActions().typing_in_element(inventory_page_search_field, text);
			getCustomActions().clicking_enter(inventory_page_search_field);
			Allure.step("typing: " + text + " in the type_quantity field");
			Loggers.logger.info("typing: " + text + " in the type_quantity field");
			getCustomActions().explicit_wait_til_property_changes(table_body, 20, "childElementCount", "4");
			
		}
	}
	
	public boolean no_register( ) {
		return getCustomActions().is_element_displayed(register_payment_button) ;
	}


	public void clicking_tax() {
		getCustomActions().explicit_wait_till_visible(tax_field, 20);
		getCustomActions().clicking_element(tax_field);
	}

	public void clicking_cancel_tax() {
		getCustomActions().explicit_wait_till_visible(cancel_tax, 20);
		getCustomActions().clicking_element(cancel_tax);
	}

	public void clicking_activity() {
		getCustomActions().explicit_wait_till_visible(activity, 20);
		getCustomActions().clicking_element(activity);
	}

	public void clicking_invenetory_page_first_record_source_document(String text) {
		getCustomActions().search_elements_fro_text(inventory_first_record_source_document, text);
		getCustomActions().explicit_wait_till_visible(inventory_first_record_source_document, 20);
		getCustomActions().clicking_element(inventory_first_record_source_document);
	}

	public boolean check_to_send() {
		getCustomActions().explicit_wait_till_visible(check_send, 20);
		return getCustomActions().is_element_displayed(check_send);
	}

	public void uom_selection(int index) {
		getCustomActions().explicit_wait_till_visible(uom, 20);
		getCustomActions().drop_down_list_by_index(uom, index);
		Allure.step("choosing " + index + " from the drop down list");
		Loggers.logger.info("choosing " + index + " from the drop down list");
	}

	public void type_bill_date(String text) {
		getCustomActions().explicit_wait_till_visible(bill_date_field, 20);
		getCustomActions().typing_in_element(bill_date_field, text);
		getCustomActions().explicit_wait_till_visible(x_sign, 10);
		Allure.step("typing: " + text + " in the bill date field");
		Loggers.logger.info("typing: " + text + " in the bill date field");

	}

	public void type_quantity(String text) {
		getCustomActions().explicit_wait_till_visible(type_quantity, 20);
		getCustomActions().typing_in_element(type_quantity, text);
		Allure.step("typing: " + text + " in the type_quantity field");
		Loggers.logger.info("typing: " + text + " in the type_quantity field");
	}

	public void type_inventory_page_searvh_field(String text) {

		getCustomActions().explicit_wait_till_visible(inventory_page_search_field, 20);
		getCustomActions().typing_in_element(inventory_page_search_field, text);
		getCustomActions().clicking_enter(inventory_page_search_field);
		Allure.step("typing: " + text + " in the type_quantity field");
		Loggers.logger.info("typing: " + text + " in the type_quantity field");
		getCustomActions().explicit_wait_til_property_changes(table_body, 20, "childElementCount", "4");
	}

	public void select_product(int index) {

		getCustomActions().explicit_wait_till_visible(type_product_name, 20);
		getCustomActions().clicking_element(type_product_name);
		getCustomActions().explicit_wait_till_visible(products_selection, 20);
		getCustomActions().explicit_wait_til_property_not_be(products_selection, 10,"childElementCount","1");
		for (int i = 0; i < index; i++) {
			getCustomActions().clicking_arrow_down_key(type_product_name);
		}
		getCustomActions().clicking_enter(type_product_name);
	}

	public void select_product_with_search(int index, String text) {
		getCustomActions().explicit_wait_till_visible(type_product_name, 20);
		getCustomActions().typing_in_element(type_product_name, text);
		getCustomActions().explicit_wait_till_visible(products_selection, 20);
		if (index == 0) {
			getCustomActions().clicking_enter(type_product_name);
		} else {
			for (int i = 0; i < index; i++) {
				getCustomActions().clicking_arrow_down_key(type_product_name);
			}
			getCustomActions().clicking_enter(type_product_name);
		}
	}

	public void type_uom(String text) {
		getCustomActions().explicit_wait_till_visible(uom, 20);
		getCustomActions().typing_in_element(uom, text);
		Allure.step("typing: " + text + " in the uom field");
		Loggers.logger.info("typing: " + text + " in the uom field");
	}

	public void type_unit_price(String text) {
		getCustomActions().explicit_wait_till_visible(unit_price, 20);
		getCustomActions().typing_in_element(unit_price, text);
		Allure.step("typing: " + text + " in the unit_price field");
		Loggers.logger.info("typing: " + text + " in the unit_price field");
	}

	public void click_home_side_menu() {
		getCustomActions().explicit_wait_till_visible(home_side_menu, 20);
		getCustomActions().clicking_element(home_side_menu);
		getCustomActions().explicit_wait_till_visible(inventory_link_side_menu, 20);
		Allure.step("clickin on home side menu");
		Loggers.logger.info("clicking on home side menu ");
	}

	public void click_purchase_link_side_menu() {
		getCustomActions().explicit_wait_till_visible(purchase_link_side_menu, 20);
		getCustomActions().clicking_element(purchase_link_side_menu);
		Allure.step("clickin on purchase link from the side menu");
		Loggers.logger.info("clicking on purchase link from the side menu ");
	}

	public void click_inventory_link_side_menu() {
		getCustomActions().explicit_wait_till_visible(inventory_link_side_menu, 20);
		getCustomActions().clicking_element(inventory_link_side_menu);
		Allure.step("clickin on inventory link side menu");
		Loggers.logger.info("clicking on inventory link from side menu ");
	}

	public void click_add_new_button() {
		getCustomActions().explicit_wait_till_visible(add_new_button, 20);
		getCustomActions().clicking_element(add_new_button);
		Allure.step("clickin on add_new_button");
		Loggers.logger.info("clicking on add_new_button ");
	}

	public void click_waiting_button() {
		getCustomActions().explicit_wait_till_visible(waiting_button, 20);
		getCustomActions().clicking_element(waiting_button);
		Allure.step("clickin on waiting_button");
		Loggers.logger.info("clicking on waiting_button ");
	}

	public void click_to_send_button() {
		getCustomActions().explicit_wait_till_visible(to_send_button, 20);
		getCustomActions().clicking_element(to_send_button);
		Allure.step("clickin on to_send_button");
		Loggers.logger.info("clicking on to_send_button ");
	}

	public void click_late_button() {
		getCustomActions().explicit_wait_till_visible(late_button, 20);
		getCustomActions().clicking_element(late_button);
		Allure.step("clickin on late_button");
		Loggers.logger.info("clicking on late_button ");
	}

	public void click_select_all_checkbox() {
		getCustomActions().explicit_wait_till_visible(select_all_checkbox, 20);
		getCustomActions().clicking_element(select_all_checkbox);
		Allure.step("clickin on select_all_checkbox");
		Loggers.logger.info("clicking on select_all_checkbox ");
	}

	public boolean check_select_all_checkbox() {
		getCustomActions().explicit_wait_till_visible(select_all_checkbox, 20);
		return getCustomActions().is_element_selected(select_all_checkbox);
	}

	public void click_company_checkbox() {
		getCustomActions().explicit_wait_till_visible(company_checkbox, 20);
		getCustomActions().clicking_element(company_checkbox);
		Allure.step("clickin on company_checkbox");
		Loggers.logger.info("clicking on company_checkbox ");
	}

	public void click_edit_table_form() {
		getCustomActions().explicit_wait_till_visible(edit_table_form, 20);
		getCustomActions().clicking_element(edit_table_form);
		Allure.step("clickin on edit_table_form");
		Loggers.logger.info("clicking on edit_table_form ");
	}

	public void click_add_a_product() {
		getCustomActions().explicit_wait_till_visible(add_a_product_rfq_page, 20);
		getCustomActions().clicking_element(add_a_product_rfq_page);
		Allure.step("clickin on add_a_product");
		Loggers.logger.info("clicking on add_a_product ");

	}

	public boolean check_add_a_product() {
		getCustomActions().explicit_wait_till_visible(add_a_product_rfq_page, 20);
		return getCustomActions().is_element_displayed(add_a_product_rfq_page);

	}

	public boolean check_register_payment() {
		return getCustomActions().is_element_displayed(register_payment_button);

	}
	public void click_confirm_order_button(String text) {
		getCustomActions().explicit_wait_til_property_changes(quantity_amount, 20, "value", "1.00");
		getCustomActions().explicit_wait_till_visible(confirm_order_button, 20);
		getCustomActions().clicking_element(confirm_order_button);
		getCustomActions().explicit_wait_till_text_disappears(purchase_number, 20, text);
		Allure.step("clickin on confirm_order_button");
		Loggers.logger.info("clicking on confirm_order_button ");
	}

	public void click_receipts_link_button() {
		getCustomActions().explicit_wait_till_visible(receipts_link_button, 20);
		getCustomActions().clicking_element(receipts_link_button);
		getCustomActions().explicit_wait_till_visible(inv_search_condition, 20);
		Allure.step("clickin on receipts_link_button");
		Loggers.logger.info("clicking on receipts_link_button ");
	}

	public void click_create_bill() {
		getCustomActions().explicit_wait_till_visible(create_bill, 20);
		getCustomActions().clicking_element(create_bill);
		Allure.step("clickin on create_bill");
		Loggers.logger.info("clicking on create_bill ");
	}

	public void click_validate_button() {
		getCustomActions().explicit_wait_till_visible(validate_button, 20);
		getCustomActions().clicking_element(validate_button);
		Allure.step("clickin on validate_button");
		Loggers.logger.info("clicking on validate_button ");
	}

	
	

	public void click_receipt_link() {
		getCustomActions().explicit_wait_till_visible(receipt_link, 20);
		getCustomActions().clicking_element(receipt_link);
		Allure.step("clickin on receipt_link");
		Loggers.logger.info("clicking on receipt_link ");
	}

	public void click_register_payment_button() {
		getCustomActions().explicit_wait_till_visible(register_payment_button, 20);
		getCustomActions().clicking_element(register_payment_button);
		Allure.step("clickin on register_payment_button");
		Loggers.logger.info("clicking on register_payment_button ");
	}

	public void click_create_payment() {
		getCustomActions().explicit_wait_till_visible(create_payment, 20);
		getCustomActions().clicking_element(create_payment);
		Allure.step("clickin on create_payment");
		Loggers.logger.info("clicking on create_payment ");
	}

	public String get_purchase_order() {
		getCustomActions().explicit_wait_till_visible(purchase_number, 20);
		return getCustomActions().get_text(purchase_number);
		
	}

	public boolean check_purchase_order() {
		getCustomActions().explicit_wait_till_visible(purchase_number, 20);
		return getCustomActions().is_element_displayed(purchase_number);
	}

	public String get_inventory_order_numer() {
		getCustomActions().explicit_wait_till_visible(inventory_order_numer, 20);
		return getCustomActions().get_text(inventory_order_numer);
	}

	public String get_reference_id_in_page() {
		getCustomActions().explicit_wait_till_visible(reference_id_in_page, 20);
		return getCustomActions().get_text(reference_id_in_page);
	}
}
