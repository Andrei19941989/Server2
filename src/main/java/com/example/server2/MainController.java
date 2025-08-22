package com.example.server2;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController//анатация с помощью корлер спринг понимает что это класс конролер
@Controller//анотация для html страницы
public class MainController {
    @Autowired//автомтаическое  присванивание переменной
    private UserRepository userRepository;
    @GetMapping("/")//обрабатывает  запросы к серверу
    public String mainPage()
    {
        return "Main";
    }
    @GetMapping("/contacts")//метод для получения контактов
    public String contacts()
    {
        return "+79998283019 \n Moscow";
    }
    @GetMapping("/users")//метод для получения всех пользотвалей
    public String getAllUsers(Model model)
    {
        model.addAttribute("users", userRepository.findAll());
        return "ListUsers";
    }
    @ResponseBody
    @GetMapping("/users/{id}")//метод для получения пользовтаеля по id
    public User getUserById(@PathVariable long id){return userRepository.findById((Long)id).get();}
    @PostMapping("/users/add")//метод ьдля добавления нового пользователя
    @Transactional//анотацяи которая офрмирует действия с базой данных в рамках однйо тразакцией(одлна транзация эт о один список действий)
    public String addUsers(@RequestParam String username,@RequestParam String password,@RequestParam String name,@RequestParam String secondname,@RequestParam int age)
    {
        User u=new User(username,password,name,secondname,age);
        userRepository.save(u);//сохранение в базу данных ноовго пользователя
        return "redirect:/users";//перенаправление на другую страницу
    }
    @GetMapping("/users/formuser")
    public String formUser(Model model)
    {
        model.addAttribute("user",new User());
        return "AddUser";
    }

}