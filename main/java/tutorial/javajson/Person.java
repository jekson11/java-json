package tutorial.javajson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Person {
    @JsonIgnore //ini akan meng ignore firstName untuk di jadikan json jadi firstNamenya tidak akan di tulis ke json
    private String firstName;
    @JsonProperty("last_name")//ini mengubah nama field saat di tulis ke json jadi namanya akan menjadi last_name
    private String lastName;
    private List<String> hobbies;
    private Address address;
    @JsonFormat(pattern = "yy-MM-dd")//ini untuk mengganti format waktunya jadi format yang kita stell di JacksonAnnotationTest itu akan di ganti menjadi ini
    private Date createAt;
    private Date updateAt;//kalau ini karena tidak di buat annotation ini @JsonFormat(pattern = "yy-MM-dd") maka formatnya akan mengikuti yang di JacksonAnnotationTest

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Person() {
    }

    public Person(String firstName, String lastName, List<String> hobbies, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobbies = hobbies;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
