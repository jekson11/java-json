package tutorial.javajson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeTest {
    @Test
    void testDateTimeObjectClass() throws JsonProcessingException {
        Person person = new Person();
        person.setFirstName("jekson");
        person.setLastName("tambunan");
        //jika field object memiliki format waktu maka
        person.setCreateAt(new Date());
        person.setUpdateAt(new Date());

        //saat di write menjadi json dia akan keluar format millis (1691341490547) time nya itu default nya
        ObjectMapper mapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(SerializationFeature.INDENT_OUTPUT, true);
        //jika kita ingin dia keluar dengan forman yyyy-MM-dd sampai detiknya kita bisa atur itu lihat di test bawah
        String json = mapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void testNonMillis() throws JsonProcessingException {
        Person person = new Person();
        person.setFirstName("jekson");
        person.setLastName("tambunan");
        person.setCreateAt(new Date());
        person.setUpdateAt(new Date());

        //pertama kita buat dulu format waktu nya
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss");

       ObjectMapper mapper = new ObjectMapper()
               //ini kita matika fiture millisya tanpa di matikan pun bisa juga sih
               .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true)
               //kita bisa gunakan ini agar format yang keluar 2023-08-07 00:11:32 bukan millis
               .setDateFormat(simpleDateFormat)
               .configure(SerializationFeature.INDENT_OUTPUT, true)
               .setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String json = mapper.writeValueAsString(person);

        System.out.println(json);
    }
}
