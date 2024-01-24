package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.repositories.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(1l, "Pau", "Amador");
        //then
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Pau"),
                () -> assertEquals(person.getLastName(), "Amador"));
    }

    @Test
    void groupedAssertionsMsgs() {
        //given
        Person person = new Person(1l, "Pau", "Amador");
        //then
        assertAll("Test Props Set",
                () -> assertEquals( "Pau", person.getFirstName(), "First Name failed"),
                () -> assertEquals( "Amador", person.getLastName(),"Last Name fails"));
    }
}