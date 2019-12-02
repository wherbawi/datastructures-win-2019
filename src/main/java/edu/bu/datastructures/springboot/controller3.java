package edu.bu.datastructures.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller3 {
	@GetMapping("/somepath3/{id}")
	public String c3(@PathVariable String id) {
		System.out.println(id);
		return "another hello from somepath dear " + id;

	}
}
