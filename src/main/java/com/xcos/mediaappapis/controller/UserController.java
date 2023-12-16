package com.xcos.mediaappapis.controller;


import com.xcos.mediaappapis.exception.UserNotFoundException;
import com.xcos.mediaappapis.model.User;
import com.xcos.mediaappapis.repository.MyUserRepository;
import com.xcos.mediaappapis.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Operation(summary = "This a method to create user")

    @PostMapping(value = "/media-api/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
    }


    @Operation(summary = "This a method to get all user")
    @GetMapping(value = "/media-api/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> retrieveAllUsers(){
        return userService.getAllUsers();
    }

    @Operation(summary = "This request will delete user by id")
    @DeleteMapping(value = "/media-api/users/{id}")
    public ResponseEntity<String> deleteUserById(@Parameter(description = "id of user to be deleted") @PathVariable String id){
         userService.deleteUser(id);
         return new ResponseEntity<>("Account deleted successfully", HttpStatus.OK);
    }

    @Operation(summary = "This request will update user by id")
    @PutMapping(value = "/media-api/users/{id}")
    public ResponseEntity<Object> updateUserById(@Parameter(description = "id of user to be updated") @PathVariable String id,  @Valid @RequestBody User user) {
          boolean updated = userService.updateUser(id, user);
          if(updated) {
              return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
          }else  {
              throw  new UserNotFoundException("User does not exists");
          }
    }

}
