import io.qameta.allure.junit4.DisplayName;
import org.junit.BeforeClass;
import org.junit.Test;
import specifications.SpecificationsRest;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.notNullValue;

@DisplayName("REST ASSURED TEST")
public class RestAssuredTest {
    static final String URL = "http://127.0.0.1:8080/";

       @BeforeClass
     public static void init() {

           SpecificationsRest.setSpecForRestAssured(SpecificationsRest.setReqSpec(URL), SpecificationsRest.setResponceSpec200());

      }
    @DisplayName("USERS WITH FILLED EMAILS")
        @Test
        public void test1(){
            given()
            .when()

                    .get( "users")
                    .then().log().all()
            .body("email", notNullValue());

        }
    @DisplayName("GET USER BY USERNAME{username}")
        @Test
    public void test3(){
           String username="Fibi";
            given()
                    .when()
                    .get("users/findByUsername/" + username)
                    .then().log().all();



        }
}
