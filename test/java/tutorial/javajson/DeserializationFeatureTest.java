package tutorial.javajson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class DeserializationFeatureTest {
    @Test
    void testDeserializationFeature() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper()
                //ini membiarkan array singgle kalau ada ini kita tidak perlu menulis arraynya kalau misal nilainya cuma satu
                //defaulya ini false jadi tidak boleh walau nilainya satu kita harus tetap menulis dia array kalau memang array
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                //kalau ini membiarkan kolom yang tidak di kenal jika ada kolom yang tidak sesuai dengan class person
                //maka akan di ignore atau di biarkan defaultnya ini tru jadi akan error
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                //penjelasannya di MapperFeatureTest
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        String json = """
                {
                "lastname":"tambunan",
                "firstname":"jekson",
                "hobbies":"explore",
                "unknow":"colum"
                }
                """;
        //hobbies contoh array
        Person person = mapper.readValue(json, Person.class);

        Assertions.assertEquals("jekson", person.getFirstName());
        Assertions.assertEquals("tambunan", person.getLastName());
        Assertions.assertEquals(List.of("explore"), person.getHobbies());
    }
}
