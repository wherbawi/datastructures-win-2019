package edu.bu.datastructures.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller4 {
	@GetMapping("/somepath4")
	public String c4(@RequestParam Double lat) {
		System.out.println(lat);
		return "lat " + lat ;

	}
}
