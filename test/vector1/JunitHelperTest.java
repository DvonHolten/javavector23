package vector1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JunitHelperTest {

    /**
     * Method under test: {@link JunitHelper#JunitHelper(String[])}
     */
    @Test
    void testConstructor() {
        // Arrange
        String[] args = new String[]{ "Args" };

        // Act
        new JunitHelper( args );

        // Assert
        assertEquals( 1, args.length );
        assertArrayEquals( new String[]{ "Args" }, args );
        assertEquals( "Args", args[ 0 ] );
    }

}

