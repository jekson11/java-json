package tutorial.javajson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JacksonAnnotationTest {
    @Test
    void testPersonFormatJson() throws JsonProcessingException {
        Person person = new Person();
        person.setFirstName("jekson");
        person.setLastName("tambunan");
        person.setCreateAt(new Date());
        person.setUpdateAt(new Date());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss");

        ObjectMapper mapper = new ObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true)
                .setDateFormat(simpleDateFormat)
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String json = mapper.writeValueAsString(person);

        System.out.println(json);
    }
}
