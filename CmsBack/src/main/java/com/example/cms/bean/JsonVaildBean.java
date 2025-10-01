package com.example.cms.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;

@Configuration
public class JsonVaildBean {

	private static final String ChargingREC_Validation = "/json_schema/ChargingREC.json";

	@Bean
	public JsonSchema jsonSchema() {
		return JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7)
				.getSchema(getClass().getResourceAsStream(ChargingREC_Validation));
	}
}
