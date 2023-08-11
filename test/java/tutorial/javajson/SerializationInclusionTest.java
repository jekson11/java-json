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
                //ini agar kalau ada yang nilai nya null maka json nya tidak akan mengambil nilai tersebut
                //kalau ini tidak ada maka nilai null itu akan di tulis di json nta
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                //ini jika ada yang empty maka tidak akan di tulis di json nya
                .setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        Person person = new Person();
        person.setFirstName("jekson");
        person.setLastName("");

        //kita pake writeValueAsString aja gak usah yang writeValue/gk usah menulis jsonnya di file biar cepat
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }
}
