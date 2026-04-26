package controller;

import util.ObjectConverter;
import entities.User;
import request.ApiRequest;

import static staticData.EndPoints.*;

public class UserController extends ApiRequest {
    public UserController(String URL) {
        super(URL);
    }


    public User[] getUsers() {
        this.response = get(getEndpoint(PUBLIC, V2, USERS));
        return this.response.as(User[].class);
    }

    public User crateUser(User user){
        this.response = post(getEndpoint(PUBLIC, V2, USERS), ObjectConverter.convertJavaObjectToJsonObject(user));
        return this.response.as(User.class);
    }


}
