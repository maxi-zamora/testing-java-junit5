package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("Controllers")
public interface ControllerTests {
    @BeforeAll
    default void beforeAll() {
        System.out.println("Lets do something here");
    }
}
