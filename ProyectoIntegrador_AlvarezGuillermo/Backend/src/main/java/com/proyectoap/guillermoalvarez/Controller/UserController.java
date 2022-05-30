
package com.proyectoap.guillermoalvarez.Controller;

import com.proyectoap.guillermoalvarez.Entity.User;
import com.proyectoap.guillermoalvarez.Interface.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired IUserService iuserService;
    
    @GetMapping("users/get")
    public List<User> getUser(){
        return iuserService.getUser();
    }
    
    @PostMapping("/users/create")
    public String createUser(@RequestBody User user){
        iuserService.saveUser(user);
        return "Usuario creado!";
    }
    
    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id){
            iuserService.deleteUser(id);
            return "Usuario borrado!";
    }
    
    @PutMapping("/users/edit/{id}")
    public User editUser(@PathVariable Long id, @RequestParam("nombre") String nuevoNombre, @RequestParam("apellido") String nuevoApellido, @RequestParam("img") String nuevoImg ){
        
        User user = iuserService.findUser(id);
        user.setNombre(nuevoNombre);
        user.setApellido(nuevoApellido);
        user.setImg(nuevoImg);
        
        iuserService.saveUser(user);
        return user;
    }
}
