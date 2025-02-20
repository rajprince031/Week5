package com.practiceproblem.valideteschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;
public class SchemaValidation {
    public static void main(String[] args) throws IOException, ProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Load JSON Schema
        JsonNode schemaNode = objectMapper.readTree(new File("src/main/java/com/practiceproblem/valideteschema/schema.json"));
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schemaNode);
        // Load JSON Data
        JsonNode jsonData1 = objectMapper.readTree(new File("src/main/java/com/practiceproblem/valideteschema/demo1.json"));

        JsonNode jsonData2 = objectMapper.readTree(new File("src/main/java/com/practiceproblem/valideteschema/demo2.json"));
        // Validate JSON
        if (schema.validate(jsonData1).isSuccess()) {
            System.out.println("jsonData1 is valid!");
        } else {
            System.out.println("Invalid jsonData1!");
        }

        if (schema.validate(jsonData2).isSuccess()) {
            System.out.println("jsonData2 is valid!");
        } else {
            System.out.println("Invalid jsonData2!");
        }
    }
}

