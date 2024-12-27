package data;

import lombok.Data;

import java.util.UUID;


@Data
public class TestData {
    String city = "58c665588b6aa52311afa01b",
            block_id = "6551d4c79032d626185ad7f4",
            apartment_id = "63c5691528d3bc959a086465";

    String session;

    public TestData() {
        this.session = generateNewSession();
    }

    private String generateNewSession() {
        return UUID.randomUUID().toString();
    }
}
