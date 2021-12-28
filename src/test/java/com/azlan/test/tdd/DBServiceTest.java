package com.azlan.test.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/*
 * This is an example of BDD which derives from TDD
 * Problem Statement: I want to mock a DB call to validate a query
 */
@ExtendWith(MockitoExtension.class)
class DBServiceTest {

    @Mock
    Database dbMock;    // we will mock the DB

    @Test
    void dbCheckTest()  {
        assertNotNull(dbMock);  // assert that the DB exist
        when(dbMock.isAvailable()).thenReturn(true);    // BDD -> Given-When-Then approach

        DBService t  = new DBService(dbMock);   // initialize the service with the mocked DB
        boolean check = t.dbCheck();

        assertTrue(check);  // assert that the DB is available
    }

    @Test
    void ensureQueryReturnConfiguredValue() {

        // define return value for method getUniqueId() where in actuality returning 123
        when(dbMock.getUniqueID()).thenReturn(456);

        DBService service = new DBService(dbMock);
        // use mock in test....
        assertEquals(456, service.query("* from t"));
    }

    @Test
    void ensureQueryReturnString() {
        when(dbMock.getUniqueID()).thenReturn(123); // mocking the default return value 123

        DBService service = new DBService(dbMock);

        // You can try changing the 123 to some other value to fail it
        assertEquals("Using database with id: 123" , service.toString());
    }
}
