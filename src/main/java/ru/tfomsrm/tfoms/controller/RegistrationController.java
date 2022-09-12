package ru.tfomsrm.tfoms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.tfomsrm.tfoms.other.MyLogger;
import ru.tfomsrm.tfoms.domain.Role;
import ru.tfomsrm.tfoms.domain.User;
import ru.tfomsrm.tfoms.repos.UserRepo;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private static MyLogger LOG = MyLogger.getInstance();

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        LOG.info("Пользователь " + user.getUsername() + " успешно создан!");

        return "redirect:/user";
    }
}
