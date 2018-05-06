package org.santander.produban.BDMBot.Tests;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainTests {
	public static void main2(String[] args) {

		String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5," + "  \"owners\" : [\"John\", \"Jack\", \"Jill\"],"
				+ "  \"nestedObject\" : { \"field\" : \"value\" } }";

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			JsonNode node = objectMapper.readValue(carJson, JsonNode.class);

			JsonNode brandNode = node.get("brand");
			String brand = brandNode.asText();
			System.out.println("brand = " + brand);

			JsonNode doorsNode = node.get("doors");
			int doors = doorsNode.asInt();
			System.out.println("doors = " + doors);

			JsonNode array = node.get("owners");
			JsonNode jsonNode = array.get(0);
			String john = jsonNode.asText();
			System.out.println("john  = " + john);

			JsonNode child = node.get("nestedObject");
			JsonNode childField = child.get("field");
			String field = childField.asText();
			System.out.println("field = " + field);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonFactory factory = mapper.getJsonFactory();
			JsonParser parse = factory.createJsonParser(
					"{\"resize_keyboard\": false, \"one_time_keyboard\": false, \"keyboard\": [[\"A\", \"B\"]]}}");
			// JsonParser parse = factory.createJsonParser("{\"k1\":\"v1\"}");
			JsonNode node = mapper.readTree(parse);
			System.out.println(node);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
