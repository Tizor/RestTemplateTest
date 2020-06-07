package restApp.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import restApp.entity.User;

@Component
public class RestTemplateController {

    private static RestTemplate restTemplate;

    final static String uri = "http://localhost:8080/users";
    final static String uriEureka = "http://Rest-test-server/users";


    public RestTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static void getUsersListRequest()
    {
        String result = restTemplate.getForObject(uriEureka, String.class);
        System.out.println("getUsersListRequest method -> " + result);
    }

    public static User getUserByIdRequest(Long customerNumber) {
        String URL = "http://localhost:8080/users/" + customerNumber;
        User user = restTemplate.getForObject(URL, User.class);
        System.out.println("getUserByIdRequest method -> " + user);
        return user;
    }

    public static void postUserRequest(User user) {
        restTemplate.postForEntity(uri, user, User.class);
        System.out.println("postUserRequest method -> " + user);
    }

    public static void putUserRequest(User user) {
        restTemplate.put(uri, user, User.class);
        System.out.println("putUserRequest method -> " + user);
    }

    public static void patchUserRequest(User user) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        restTemplate.setRequestFactory(requestFactory);
        restTemplate.exchange(uri, HttpMethod.PATCH, entity, Void.class);
//        restTemplate.patchForObject(uri, user, User.class);
        System.out.println("patchUserRequest method -> " + user);
    }

    public static void deleteUserRequest(User user) {
        restTemplate.delete((uri + "/" + user.getCustomerNumber()));
        System.out.println("deleteUserRequest method -> " + user);
    }

//    public static Long userRequest(Long customerNumber) {
//        String URL = "http://localhost:8080/users/" + customerNumber;
//        ResponseEntity<User> user = restTemplate.getForEntity(URL, User.class);
//        System.out.println("userRequest method -> " + user);
//        return user.getBody().getCustomerNumber();
//    }

//    public static void updateIngredient(User user) {
//        String URL = "http://localhost:8080/users/" + user.getCustomerNumber();
//        restTemplate.put(URL, user, user.getCustomerNumber());
//    }

//    public static void updateIngredient(User user) {
//        HttpEntity<user> requestUpdate = new HttpEntity<>(updatedInstance, headers);
//        restTemplate.exchange(resourceUrl, HttpMethod.PUT, requestUpdate, Void.class);
//    }


//    @GetMapping("/getUserFromAnotherApp/{id}")
//    @ResponseStatus(code= HttpStatus.OK)
//    public ResponseEntity<User> userRequest(@PathVariable("id") Long id) {
//        String URL = "http://localhost:8080/users/{id}";
//        ResponseEntity<User> user = restTemplate.getForEntity(URL, User.class, id);
//        System.out.println(user.getStatusCode() + "\n");
//        System.out.println(user.getStatusCodeValue() + "\n");
//        System.out.println(user.getHeaders() + "\n");
//        System.out.println(user.getHeaders().getDate() + "\n");
//        System.out.println(user.getBody() + "\n");
//        return user;
//    }

//    @PutMapping("/setUserFromAnotherApp")
//    @ResponseStatus(code= HttpStatus.OK)
//    public void userRequest(@RequestBody User user) {
//        Long f = user.getId();
//        String URL = "http://localhost:8080/users/"+f;
//        restTemplate.put(URL, user, f);
//    }

//    @PutMapping("/setUserFromAnotherApp")
//    @ResponseStatus(code= HttpStatus.OK)
//    public void userRequest(@RequestBody User user) {
//        final String uri = "http://localhost:8080/springrestexample/employees/{id}";
//        String URL = "http://localhost:8080/users/"+f;
//        Map<String, Long> params = new HashMap<>();
//        params.put("id", 1L);
//        restTemplate.put(URL, user, f);
//    }






//    @GetMapping("/getUserFromAnotherApp/{id}")
//    @ResponseStatus(code= HttpStatus.OK)
//    public User getIngredientById(@PathVariable("id") Long id) {
//        Map<String,String> urlVariables = new HashMap<>();
//        urlVariables.put("id", id);
//        return restTemplate.getForObject("http://localhost:8080/users/{id}",
//                User.class, urlVariables);
//    }
}
