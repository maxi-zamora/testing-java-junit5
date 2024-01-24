package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.repositories.model.Owner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l, "Paulina", "Amador");
        owner.setCity("Mexico city");
        owner.setTelephone("1234567891");
        assertAll("Properties test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Paulina", owner.getFirstName(), "First Name didn't match"),
                        () -> assertEquals("Amador", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Mexico city", owner.getCity(), "City didn't match"),
                        () -> assertEquals("1234567891", owner.getTelephone())
                ));
    }

}