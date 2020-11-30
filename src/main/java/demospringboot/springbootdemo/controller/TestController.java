package demospringboot.springbootdemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController
{
	@GetMapping("/index")
	public Map<String, String> index()
	{
		Map<String, String> result = new HashMap<>();
		result.put("test1", "AAAAAAAAAA");
		result.put("test2", "BBBBBBBBBB");
		result.put("test3", "CCCCCCCCCC");
		return result;
	}
}
