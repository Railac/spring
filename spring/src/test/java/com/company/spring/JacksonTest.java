package com.company.spring;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;

import com.company.spring.controller.SlipVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

	
	@Test
	public void test1() {
		ObjectMapper mapper = new ObjectMapper();
		String str ="[{\"slipAmount\":14520,\"salDt\":\"\",\"customer\":\"114\",\"bankAcct\":\"ㅋ\"}]";
		try {
			JsonNode node = mapper.readTree(str);
			System.out.println(node.get(0).path("slipAmount"));
			
			SlipVO[] list= mapper.readValue(str, SlipVO[].class);
			System.out.println(list[0].getSlipAmount());
			URL url = new URL("http://");
			JsonNode movie = mapper.readTree(url);
			System.out.println(movie);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
