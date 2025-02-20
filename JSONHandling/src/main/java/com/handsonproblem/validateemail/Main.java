package com.handsonproblem.validateemail;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException, ProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Load JSON Schema
        JsonNode schemaNode = objectMapper.readTree(new File("src/main/java/com/handsonproblem/validateemail/Schema.json"));
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schemaNode);

        JsonNode jsonArray = objectMapper.readTree(new File("src/main/java/com/handsonproblem/validateemail/demo.json"));

        Iterator<JsonNode> elements = jsonArray.elements();
        ArrayNode filterArray = objectMapper.createArrayNode();
        while(elements.hasNext()){
            JsonNode element = elements.next();
            // Validate JSON
            if (schema.validate(element).isSuccess()) {
                filterArray.add(element);
            }
        }


        System.out.println(filterArray.toString());
    }
}
