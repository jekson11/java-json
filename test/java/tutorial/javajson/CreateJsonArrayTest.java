package tutorial.javajson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CreateJsonArrayTest {
    @Test
    void testCreateJsonArrayList() throws JsonProcessingException {
        //menulis json array dari list
        List<String> listJson = List.of("jekson", "tambunan", "sembilan belas tahun");

        ObjectMapper mapper = new ObjectMapper();
       String json = mapper.writeValueAsString(listJson);

        System.out.println(json);
    }

    @Test
    void testReadJsonArrayToList() throws JsonProcessingException {
        //ini membaca array json dari string kita juga bisa membaca nya dari file json sama seperti yang lain
        String json = """
                ["jekson","tambunan","sembilan belas tahun"]
                """;
        ObjectMapper mapper = new ObjectMapper();
        //method nya juga sama aja
        List<String> listJson = mapper.readValue(json, new TypeReference<List<String>>() {
        });

        Assertions.assertEquals(List.of("jekson","tambunan","sembilan belas tahun"), listJson);
    }
}
