package War.controller;

import War.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String userGreeting (Model model) {
        model.addAttribute("message", "¡Bienvenido!");
        User userObject = new User("David", "david@example.com");
        model.addAttribute("userObject", userObject);
        return "user-greeting";
    }

    @GetMapping("/helloworld")
    public String greeting (@RequestParam(required = false) String username, Model model) {
        model.addAttribute("message", "Hola " + username);
        return "greeting";
    }

    @GetMapping("/saludos")
    public String saludosVarios (@RequestParam String name1, @RequestParam String name2, Model model) {
        model.addAttribute("message", "¡Hola " + name1 + " y " + name2 + "!");
        return "greeting"; // Reutilizamos la plantilla que ya tienes
    }
}