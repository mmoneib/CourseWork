package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private final AtomicLong counter = new AtomicLong();
	private static final String template = "Hello %s!";

	@RequestMapping(path = "/greeting", method = RequestMethod.GET)
	public Greeting getGreeting(@RequestParam(defaultValue = "World", name = "message") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
