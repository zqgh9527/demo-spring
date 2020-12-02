package demospringboot.springbootdemo.controller;


import demospringboot.springbootdemo.common.GlobalConfig;
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
		result.put("test1", "AAAA1111111111111111111111111111111111111111111111AAAAAA");
		result.put("test2", "BBBBBBBBBB");
		result.put("test3", "CCCCCCCCCC");
		result.put("环境", GlobalConfig.getEnv());
		return result;
	}
}
