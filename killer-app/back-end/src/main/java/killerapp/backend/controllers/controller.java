package killerapp.backend;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class controller {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("eventName", "FIFA 2018");
        return "index";
    }
}
