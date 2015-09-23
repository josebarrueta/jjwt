package io.jsonwebtoken.impl.compression

import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.MatcherAssert.assertThat

class GzipCompressionTest {
    Decompressor decompressor = new GzipDecompressor();
    Compressor compressor = new GzipCompressor();

    @Test
    void testCompressDecompress() {
        String body = "compress this message.  The quick brown fox jumped over the lazy dog.  It has to be long enough " +
                "to be able to compress and get smaller, not bigger with header info and stuff"
        byte[] compressed = compressor.compress(body.bytes);
        assertThat "it did compress", compressed.length < (body.bytes.length)
        String decompressed = new String(decompressor.decompress(compressed))
        assertThat "it decompressed to the same", decompressed, equalTo(body)
    }

}
