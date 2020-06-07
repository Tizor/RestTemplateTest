package restApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import restApp.controller.RestTemplateController;
import restApp.entity.User;

@SpringBootApplication(exclude =  GsonAutoConfiguration.class)
@EnableDiscoveryClient
public class RestApp {
    public static void main(String[] args) {
        SpringApplication.run(RestApp.class, args);
        User user1 = new User(2L, "Kane", 55L, "TC");
        User user2 = new User(2L, "Jack", 55L, "TC");
        User user3 = new User(2L, "John");
        User user4 = new User(2L, 35L, "NY");
        RestTemplateController.getUsersListRequest();
//        RestTemplateController.getUserByIdRequest(2L);
////        RestTemplateController.postUserRequest(user1);
//        RestTemplateController.putUserRequest(user2);
//        RestTemplateController.getUserByIdRequest(2L);
//        RestTemplateController.patchUserRequest(user4);
//        RestTemplateController.getUserByIdRequest(2L);
//          RestTemplateController.deleteUserRequest(user4);
//        RestTemplateController.deleteUserRequest();
//        RestTemplateController.updateIngredient(new User(2L, "Kane", 55L, "TC"));


    }
}
