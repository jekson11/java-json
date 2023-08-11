package tutorial.javajson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SerializationFeatureTest {
    @Test
    void testSerializationFeature(){
        Person person = new Person();
        person.setFirstName("Jekson");
        person.setLastName("tambunan");
        person.setHobbies(List.of("explore", "read", "movie"));
        person.setAddress(new Address("jl kamboja", "jakarta", "indonesia"));

        ObjectMapper mapper = new ObjectMapper()
                //ini agar outputnya di file atau di console menjadi rapiih tidak satu barus saja seperti sebelunya
                .configure(SerializationFeature.INDENT_OUTPUT, true);

        Path path = Path.of("file.json");
        try (Writer writer = Files.newBufferedWriter(path)){

            mapper.writeValue(writer, person);

        }catch (IOException exception){
            Assertions.fail(exception);
        }
    }
}
