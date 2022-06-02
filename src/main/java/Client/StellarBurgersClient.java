package Client;
import User.User;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import java.util.ArrayList;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class StellarBurgersClient extends StellarBurgersRestClient{

    private static final String CREATE_USER_PATH = "api/auth/register";
    private static final String ORDER_PATH = "api/orders";
    private static final String INGREDIENTS_LIST = "api/ingredients";
    private static final String LOGIN_USER_PATH = "api/auth/login/";
    private static final String EDIT_USER_PATH = "api/auth/user/";

    @Step("Create new user")
    public ValidatableResponse createNewUser(User user) {

        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(CREATE_USER_PATH)
                .then();
    }

    @Step("Delete user")
    public ValidatableResponse deleteUser(String authorization){

        return given()
                .spec(getBaseSpec())
                .header("Authorization", authorization)
                .when()
                .delete(EDIT_USER_PATH)
                .then();
    }

    @Step("Edit user with authorization")
    public ValidatableResponse editUserWithAuthorization(User user, String authorization) {

        return given()
                .spec(getBaseSpec())
                .header("Authorization", authorization)
                .body(user)
                .when()
                .patch(EDIT_USER_PATH)
                .then();
    }

    @Step("Edit user without authorization")
    public ValidatableResponse editUserWithoutAuthorization(User user) {

        return given()
                .spec(getBaseSpec())

                .body(user)
                .when()
                .patch(EDIT_USER_PATH)
                .then();
    }

    @Step("Get ingredients list")
    public ValidatableResponse getIngredients() {
        return given()
                .spec(getBaseSpec())
                .when()
                .get(INGREDIENTS_LIST)
                .then();
    }






    @Step("Get Orders Authorized User")
    public ValidatableResponse getOrdersAuthorizedUser(User user, String authorization) {

        return given()
                .spec(getBaseSpec())
                .header("authorization", authorization)
                .contentType(ContentType.JSON)
                .when()
                .get(ORDER_PATH)
                .then();
    }
    @Step("Get Orders Unauthorized User")
    public ValidatableResponse getOrdersUnauthorizedUser() {

        return given()
                .spec(getBaseSpec())
                .when()
                .get(ORDER_PATH)
                .then();
    }
    }




