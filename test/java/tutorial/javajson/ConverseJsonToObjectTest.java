package tutorial.javajson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ConverseJsonToObjectTest {
    @Test
    void testJsonToObjectClass() throws JsonProcessingException {
        //membuat object class dari json
        String json = """
                {
                  "firstName": "Jekson",
                  "lastName": "tambunan",
                  "hobbies": [
                    "explore",
                    "read",
                    "movie"
                  ],
                  "address": {
                    "street": "jl kamboja",
                    "city": "jakarta",
                    "country": "indonesia"
                  }
                }
                """;

        ObjectMapper mapper = new ObjectMapper();
        //caranya sama aja kayak yang membuat json ke map ata ke list cuma bedanya di readValue nya kita menyebut nama cassnya
        Person person = mapper.readValue(json, Person.class);

        Assertions.assertEquals("Jekson", person.getFirstName());
        Assertions.assertEquals("tambunan", person.getLastName());
        Assertions.assertEquals(List.of("explore", "read", "movie"), person.getHobbies());
        Assertions.assertEquals("jl kamboja", person.getAddress().getStreet());
        Assertions.assertEquals("jakarta", person.getAddress().getCity());
        Assertions.assertEquals("indonesia", person.getAddress().getCountry());

    }
}
