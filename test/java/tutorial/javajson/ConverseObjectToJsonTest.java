package tutorial.javajson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ConverseObjectToJsonTest {
    @Test
    void testCreateJsonFromObject() throws JsonProcessingException {
        //sebenarnya itu kalau mau membuat json itu kita buatnya dari object class seperti ini
        //field yang ada pada object tersebut akan menjadi json
        Person person = new Person();
        person.setFirstName("Jekson");
        person.setLastName("tambunan");
        person.setHobbies(List.of("explore", "read", "movie"));
        person.setAddress(new Address("jl kamboja", "jakarta", "indonesia"));

        ObjectMapper mapper = new ObjectMapper();
        //ini yang menggunaka writeValueAsString tanpa di simpan ke file jadi hanya di simpan di memory saja
        //jadi ini bersifat sementara hanya saat programnya jalan
        String json = mapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void testCreateJsonFromObjectToFile(){
        //kalau ini yang di simpan di file format json
        Person person = new Person();
        person.setFirstName("Jekson");
        person.setLastName("tambunan");
        person.setHobbies(List.of("explore", "read", "movie"));
        person.setAddress(new Address("jl kamboja", "jakarta", "indonesia"));

        ObjectMapper mapper = new ObjectMapper();
        Path path = Path.of("file.json");
        try(Writer writer = Files.newBufferedWriter(path)){
            //menggunakan writeValue kita masukkan writer dari java io dan object class nya
            mapper.writeValue(writer, person);
            writer.flush();

        }catch (IOException exception){
            Assertions.fail(exception);
        }
    }

}
