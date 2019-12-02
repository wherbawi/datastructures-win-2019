
package edu.bu.datastructures.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {
	@RequestMapping("/")
	public String c1() {
		return "hello world from bu stds";

	}
}
