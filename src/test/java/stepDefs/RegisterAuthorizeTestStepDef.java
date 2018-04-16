package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Credentials;
import model.Register;
import model.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;

public class RegisterAuthorizeTestStepDef {
    private RequestAuthorize requestAuthorize = new RequestAuthorize();
    private RequestRegister requestRegister = new RequestRegister();
    private HashMap<String, String> results = new HashMap<String, String>();
    private Credentials credentials = new Credentials();
    private Register register = new Register();
    private Address address = new Address();
    public static final Logger LOGGER = LogManager.getLogger(RegisterAuthorizeTestStepDef.class);

    @Given("LOGIN (.*)")
    public void input_login(String login) {
        credentials.setLogin(login);
    }

    @Given("PASSWORD (.*)")
    public void input_password(String pwd) {
        credentials.setPwd(pwd);
    }

    @When("we are requesting authorisation")
    public void get_autorize_response() throws IOException {
        results = requestAuthorize.getAuthorize(credentials);
    }

    @Then("RESULT should be (.*)")
    public void check_result(Boolean result) {
        RegisterAuthorizeTestStepDef.LOGGER.info("Result: " + result + "\n");
        assertEquals("Wrong RESULT", result, results.get("Result"));
    }

    @Then("DETAILS should be (.*)")
    public void check_details(String details) {
        RegisterAuthorizeTestStepDef.LOGGER.info("Details: " + details + "\n");
        assertEquals("Wrong DETAILS", details, results.get("Details"));
    }

    @Given("EMAIL (.*)")
    public void input_email(String email) {
        register.setEmail(email);
    }

    @Given("PWD (.*)")
    public void input_pwd(String pwd) {
        register.setPwd(pwd);
    }

    @Given("PHONE (.*)")
    public void input_phone(String phone) {
        register.setPhone(phone);
    }

    @Given("BIRTHDATE (.*)")
    public void input_birthDate(String birthDate) {
        register.setBirthDate(birthDate);
        Period.between(LocalDate.parse(register.getBirthDate().toString().substring(0, 10)), LocalDate.now()).getYears();
        RegisterAuthorizeTestStepDef.LOGGER.info("Age: " +
                Period.between(LocalDate.parse(register.getBirthDate().toString().substring(0, 10)),
                               LocalDate.now()).getYears() + "\n");
    }

    @Given("DESCRIPTION (.*)")
    public void input_description(String description) {
        register.setDescription(description);
    }

    @Given("COUNTRY (.*)")
    public void input_country(String country) {
        address.setCountry(country);
    }

    @Given("CITY (.*)")
    public void input_city(String city) {
        address.setCity(city);
    }

    @Given("STATE (.*)")
    public void input_state(String state) {
        address.setState(state);
    }

    @Given("ZIP (.*)")
    public void input_zip(String zip) {
        address.setZip(zip);
    }

    @Given("STREET (.*)")
    public void input_steet(String street) {
        address.setStreet(street);
    }

    @When("we are requesting registration")
    public void get_register_response() throws IOException {
        register.setAddress(address);
        results = requestRegister.getRegister(register);
    }
}
