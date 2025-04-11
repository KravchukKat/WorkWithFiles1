package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Group;
import model.UserName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JsonParsingFilesTests {

    @Test
    void testJsonParsingFiles() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("example.json")) {
            assertNotNull(is, "Файл example.json не найден!");

            ObjectMapper objectMapper = new ObjectMapper();
            Group group = objectMapper.readValue(is, Group.class);

            assertEquals("34-qa-guru", group.getGroup());
            assertEquals(2, group.getChecklist().size());

            UserName petrUserName = group.getChecklist().get(0);
            assertEquals("Petr", petrUserName.getUsername());
            assertEquals("123 Main St", petrUserName.getAddresses().get(0).getStreet());
            assertEquals("212-555-1234", petrUserName.getAddresses().get(0).getPhone());

            UserName johnUserName = group.getChecklist().get(1);
            assertEquals("John", johnUserName.getUsername());
            assertEquals("59th Street", johnUserName.getAddresses().get(0).getStreet());
            assertEquals("646-555-4567", johnUserName.getAddresses().get(0).getPhone());
        }
    }
}
