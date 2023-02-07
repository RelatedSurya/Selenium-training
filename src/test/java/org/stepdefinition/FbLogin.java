package org.stepdefinition;

import org.bas.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FbLogin extends BaseClass {
	
	   //------->Cucumber scenario
	
	//@Given("To launch the chrome browser and maximize window")
	//public void to_launch_the_chrome_browser_and_maximize_window() {
		//launchBrowser();
		//windowMaximize();
	    
	//}

	//@When("To launch the url of the facebook application")
	//public void to_launch_the_url_of_the_facebook_application() {
		//launchUrl("https://www.facebook.com/login/");
	  
	//}

	//@When("To pass the valid username in email field")
	//public void to_pass_the_valid_username_in_email_field() {
		//Flipkart f = new Flipkart();
		//passText("suryanathan2819@gmail.com", f.getemail());
	   
	//}

	//@When("To pass the invalid password in password field")
	//public void to_pass_the_invalid_password_in_password_field() {
		//Flipkart f = new Flipkart();
		//passText("  ", f.getpassword());
	   
	//}

	//@When("To click the login button")
	//public void to_click_the_login_button() {
		//Flipkart f = new Flipkart();
		//clickBtn(f.getLoginBtn());
	    
	//}

	//@When("To check whether navigate to the home page or not")
	//public void to_check_whether_navigate_to_the_home_page_or_not() {
		//System.out.println("To check your login credentials");
	   
	//}

	//@Then("To close the browser")
	//public void to_close_the_browser() {
		//closeEntireBrowser();
	    
	//}
	
	 //------->Cucumber scenario outline 
	
	@Given("User has to launch thr browser and maximize the window")
	public void user_has_to_launch_thr_browser_and_maximize_the_window() {
		launchBrowser();
		windowMaximize();
	    
	}

	@When("User has to hit the facebook url")
	public void user_has_to_hit_the_facebook_url() {
		launchUrl("https://www.facebook.com/login/");
	    
	}

	@When("User has to pass the data {string} in email field")
	public void user_has_to_pass_the_data_in_email_field(String em) {
		Flipkart f = new Flipkart();
		passText(em, f.getemail());
	    
	}

	@When("User has to pass the data {string} in passwoed field")
	public void user_has_to_pass_the_data_in_passwoed_field(String pass) {
		Flipkart f = new Flipkart();
		passText(pass, f.getpassword());
	   
	}

	@When("User has to click the login button")
	public void user_has_to_click_the_login_button() {
		Flipkart f = new Flipkart();
		clickBtn(f.getLoginBtn());
	   
	}

	@Then("User has to close the browser")
	public void user_has_to_close_the_browser() {
		closeEntireBrowser();
	    
	}

}
	
	