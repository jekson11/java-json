package tutorial.javajson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class ReadJsonObjectTest {
    @Test
    void testReadValue() throws JsonProcessingException {
        //membaca json dari string biasa dan mengubahnya ke map
        String json = """
                {
                  "'hobbies": [
                    "game",
                    "football",
                    "running"
                  ],
                  "married": false,
                  "lastName": "marucup",
                  "age": 17,
                  "firstName": "ucup",
                  "address": {
                    "street": "Jl melati",
                    "city": "Jakarta",
                    "country": "Indonesia"
                  }
                }
                """;

        ObjectMapper mapper = new ObjectMapper();
        //menggunakan metho readValue
        Map<String, Object> mapJson = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        mapJson.forEach((key, value) -> System.out.println(key+" : "+value));
        Assertions.assertEquals("ucup", mapJson.get("firstName"));
        Assertions.assertEquals("marucup", mapJson.get("lastName"));

    }

    @Test
    void testReadValueJsonFile(){
        //membaca json dari file json dan mengubahnya ke map
        Path path = Path.of("file.json");
        ObjectMapper objectMapper = new ObjectMapper();

        try(Reader reader = Files.newBufferedReader(path)){
            Map<String, Object> mapJson = objectMapper
                    //sama menggunakan method readValue juga bedanya yang kita masukkan itu Reader dari java io
                    //bukan string langsung kayak yang di atas
                    .readValue(reader, new TypeReference<Map<String, Object>>(){});

            mapJson.forEach((key, value) -> System.out.println(key+" : "+value));
            Assertions.assertEquals("ucup", mapJson.get("firstName"));
            Assertions.assertEquals("marucup", mapJson.get("lastName"));

        }catch (IOException exception){
            Assertions.fail(exception);
        }
    }
}
