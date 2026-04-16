import asserts.ApiAssert;
import config.ConfigurationManager;
import controller.UserController;
import org.junit.jupiter.api.Test;
import entities.User;
import staticData.StatusCodes;

public class UserTest {

    @Test
    void getAllUsers() {
        UserController userController = new UserController(ConfigurationManager.getAppConfig().baseUrl());
        User[] users = userController.getUsers();
        for (User u : users) {
            System.out.println(u.getName());
        }
    }

    @Test
    void createUserWithValidData() {
        UserController userController = new UserController(ConfigurationManager.getAppConfig().baseUrl());
        User user = User.builder()
                .name("Sam")
                .email("samsung9@gmail.com")
                .gender("male")
                .status("active")
                .build();

        User createdUser = userController.crateUser(user);

        ApiAssert.assertThat(userController.getResponse())
                .isCorrectStatusCode(StatusCodes.HTTP_CREATED);
    }
}
