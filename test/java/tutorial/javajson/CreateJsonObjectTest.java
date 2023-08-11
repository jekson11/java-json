package tutorial.javajson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CreateJsonObjectTest {
    @Test
    void testCreateJsonObjectWithMap() throws JsonProcessingException {
        //menulis json ke console
        Map<String, Object> person = Map.of(
                "firstName", "jekson",
                "lastName", "tambunan",
                "age", 19,
                "married", false,
                "address", Map.of(
                        "street", "Jl kamboja",
                        "city", "Jakarta",
                        "country", "Indonesia"
                ),
                "'hobbies", List.of(
                        "explore", "read", "movie"
                )
        );

        ObjectMapper mapper = new ObjectMapper();
        //menggunakan method writeValueAsString dimana hasilnya adalah JSON dalam String
        String json = mapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void testCreateJsonObjectWithMapWriteValue(){
        //menulis json ke file json
        //dimana output bisa Writer, File, OutputStream
        Map<String, Object> person = Map.of(
                "firstName", "ucup",
                "lastName", "marucup",
                "age", 17,
                "married", false,
                "address", Map.of(
                        "street", "Jl melati",
                        "city", "Jakarta",
                        "country", "Indonesia"
                ),
                "'hobbies", List.of(
                        "game", "football", "running"
                )
        );

        ObjectMapper mapper = new ObjectMapper();
        //file tujuan
        Path path = Path.of("file.json");
        //membuat Writer nya dari java io
        try (Writer writer = Files.newBufferedWriter(path)){
            //menggunakan method writeValue(Writer w, Object o)
            mapper.writeValue(writer,person);

        }catch (IOException exception){
            Assertions.fail(exception);
        }
    }

    @Test
    void testCreateJsonObject() throws JsonProcessingException {
        //menulis json ke console tapi hasilnya byte
        Map<String, Object> person = Map.of(
                "firstName", "ucup",
                "lastName", "marucup",
                "age", 17,
                "married", false,
                "address", Map.of(
                        "street", "Jl melati",
                        "city", "Jakarta",
                        "country", "Indonesia"
                ),
                "'hobbies", List.of(
                        "game", "football", "running"
                )
        );

        ObjectMapper mapper = new ObjectMapper();
        //menggunakan method writeValueAsBytes
        byte[] bytesJson = mapper.writeValueAsBytes(person);
        System.out.println(Arrays.toString(bytesJson));
    }
}
