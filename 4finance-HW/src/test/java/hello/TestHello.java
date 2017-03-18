package hello;

import io.fourfinanceit.homework.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class TestHello {

	private RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void test() {
		System.out.println(restTemplate.getForEntity(
				"http://localhost:8080/hello/", String.class));
	}

}
