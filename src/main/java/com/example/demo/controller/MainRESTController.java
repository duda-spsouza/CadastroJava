package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import com.example.demo.model.UserForm;

@RestController 
public class MainRESTController {
  
    @Autowired
    private UserDAO userDAO;
  
  
     @RequestMapping(value = "/users", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<User> getUsers() {
        List<User> list = userDAO.getAllUsers();
        return list;
    }
 
    @RequestMapping(value = "/user/{userId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public User getUser(@PathVariable("userId") Long userId) {
        return userDAO.getUser(userId);
    }
  
  
    @RequestMapping(value = "/user", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public User addUser(@RequestBody UserForm userForm) {
  
        System.out.println("(Service Side) Usuario Criado: " + userForm.getUserNome());
  
        return userDAO.addUser(userForm);
    }
  
       @RequestMapping(value = "/user", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public User updateUser(@RequestBody UserForm userForm) {
  
        System.out.println("(Service Side) editar usuario: " + userForm.getUserId());
  
        return userDAO.updateUser(userForm);
    }
    @RequestMapping(value = "/user/{userId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteUser(@PathVariable("userId") Long userId) {
  
        System.out.println("(Service Side) Deletando o usuário: " + userId);
  
        userDAO.deleteUser(userId);
    }
  
}
