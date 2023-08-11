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
                //dengan menambahkan yang di bawah ini saat pembuatan ObjectMapper
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        //makan akan di biarkan kita membuat object person dengan field yang huruf besar dan kecilnya
        //tidak sama dengan field yang ada di class person kalau defaultnya ini false jadi tidak di biarkan/tidak bisa
        //coba aja hapus kalau tidak percaya dan masih banyak lagi MapperFeature nya

        //ini json nya boleh dari file juga y
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
