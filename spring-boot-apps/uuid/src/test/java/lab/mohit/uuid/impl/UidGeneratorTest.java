package lab.mohit.uuid.impl;

import org.junit.jupiter.api.Test;

import static org.testng.Assert.*;

public class UidGeneratorTest {

    @Test
    public void testGetUid() {
        UidGenerator uidGenerator = new UidGenerator();
        long uid1 = uidGenerator.getUid();
        long uid2 = uidGenerator.getUid();
        assertEquals(Long.compare(uid1, uid2), -1);
    }

}