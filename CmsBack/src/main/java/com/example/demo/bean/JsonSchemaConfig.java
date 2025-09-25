package com.example.demo.bean;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class JsonSchemaConfig {

	@Bean
	public JsonSchema chargingRecSchema() {
		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
		InputStream schemaStream = getClass().getClassLoader()
				.getResourceAsStream("schema/ChargingRec_validation.json");

		if (schemaStream == null) {
			throw new RuntimeException("找不到 ChargingRec_validation.json");
		}
		return factory.getSchema(schemaStream);
	}
}
