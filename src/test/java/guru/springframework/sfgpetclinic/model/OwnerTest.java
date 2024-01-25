package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import guru.springframework.sfgpetclinic.repositories.model.Owner;
import guru.springframework.sfgpetclinic.repositories.model.OwnerType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class OwnerTest implements ModelTests {

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

    @DisplayName("Value Source Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments} " )
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum Source Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments} " )
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType){
        System.out.println(ownerType);
    }

    @DisplayName("CSV Input Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments} " )
    @CsvSource({
            "FL, 1, 1",
            "OH, 2, 2",
            "MI, 3, 3"
    })
    void csvInputTest(String stateName, int val1, int val2){
        System.out.println(stateName + " = " + val1 + " : " + val2);

    }

    @DisplayName("CSV From File Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments} " )
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileTest(String stateName, int val1, int val2){
        System.out.println(stateName + " = " + val1 + " : " + val2);
    }

    @DisplayName("Method Provider Test ")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments} " )
    @MethodSource("getargs")
    void fromMethodTest(String stateName, int val1, int val2){
        System.out.println(stateName + " = " + val1 + " : " + val2);
    }

    static Stream<Arguments> getargs(){
        return Stream.of(
                Arguments.of("FL", 1, 1),
                Arguments.of("OH", 2, 2),
                Arguments.of("MI", 3, 5));
    }


}