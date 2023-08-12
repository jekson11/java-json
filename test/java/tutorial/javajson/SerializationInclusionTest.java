package tutorial.javajson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

public class SerializationInclusionTest {
    @Test
    void testSerializationInclude() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                //agar outputnya rapih
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        Person person = new Person();
        person.setFirstName("jekson");
        person.setLastName("");

        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }
}
