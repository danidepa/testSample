package ve.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ve.com.model.User;
import ve.com.services.UserService;

import java.util.List;

/**
 * Created by 893414 on 4/30/2015.
 */
@Controller
@RequestMapping("rest/users")
public class UserResourceController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<User> findAll()
    {
        return userService.findAll();
    }

    @RequestMapping(value="{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User findUser(@PathVariable("id") Long id)
    {
        return userService.findUserById(id);
    }

    @RequestMapping(value="", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User savedUser = userService.create(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    @RequestMapping(value="", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        User savedUser = userService.update(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }

    @RequestMapping(value="{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id)
    {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
