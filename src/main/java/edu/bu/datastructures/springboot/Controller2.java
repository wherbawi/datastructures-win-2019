package edu.bu.datastructures.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {
	@RequestMapping("/somepath")
	public String c2() {
		return "another hello from somepath";

	}
}
