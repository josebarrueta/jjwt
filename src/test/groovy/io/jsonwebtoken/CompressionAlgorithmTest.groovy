package io.jsonwebtoken

import io.jsonwebtoken.impl.CompressionException
import org.junit.Test

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.CoreMatchers.is

/**
 * Test for the enum for supported algorithms
 */
class CompressionAlgorithmTest {
    @Test
    void testForName() {
        assertThat CompressionAlgorithm.forName("GZIP"), is(CompressionAlgorithm.GZIP)
        assertThat CompressionAlgorithm.forName("DEF"), is(CompressionAlgorithm.DEFLATE)
    }

    @Test(expected = CompressionException.class)
    void testForNameUnknown() {
        CompressionAlgorithm.forName("NO_SUCH_ALGORITHM")
    }
}
