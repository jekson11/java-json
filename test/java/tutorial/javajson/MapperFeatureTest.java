package tutorial.javajson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapperFeatureTest {
    @Test
    void testMapperFeature() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
       String json = """
                {
                "FirstName":"jekson",
                "LastName":"tambunan"
                }
                """;

        Person person = mapper.readValue(json, Person.class);
        Assertions.assertEquals("jekson", person.getFirstName());
        Assertions.assertEquals("tambunan", person.getLastName());
    }
}
