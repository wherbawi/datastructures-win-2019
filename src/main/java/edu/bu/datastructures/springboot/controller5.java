package edu.bu.datastructures.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller5 {
	@GetMapping("/somepath5")
	public String c5(@RequestParam Double lat, @RequestParam Double lon) {
		System.out.println(lat);
		return "{\"type\": \"Point\", \"coordinates\" : [" + lon + "," + lat + "]}";

	}
}
