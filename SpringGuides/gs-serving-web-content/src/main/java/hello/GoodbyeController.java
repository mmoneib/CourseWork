package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoodbyeController {

	@RequestMapping("/saygoodbye")
	public String sayAGoodbye(@RequestParam(name = "myname", required = true) String name, Model model) {
		model.addAttribute("name1", name); // attribute to be parsed in view.
		return "goodbyes"; // name of the html page in templates.
	}

}
