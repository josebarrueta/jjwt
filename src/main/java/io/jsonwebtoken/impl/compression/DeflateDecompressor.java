package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionException;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Objects;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.InflaterOutputStream;

/**
 * DeflateDecompressor
 *
 * @since 0.5.2
 */
public class DeflateDecompressor implements Decompressor {

    @Override
    public byte[] decompress(byte[] compressed) {
        Assert.notNull(compressed, "compressed cannot be null.");

        InflaterOutputStream inflaterOutputStream = null;
        ByteArrayOutputStream decompressedOutputStream = null;

        try {
            decompressedOutputStream = new ByteArrayOutputStream();
            inflaterOutputStream = new InflaterOutputStream(decompressedOutputStream);
            inflaterOutputStream.write(compressed);
            inflaterOutputStream.flush();
            return decompressedOutputStream.toByteArray();
        } catch (IOException e) {
            throw new CompressionException("Unable to decompress compressed payload.", e);
        } finally {
            Objects.nullSafeClose(decompressedOutputStream, inflaterOutputStream);
        }
    }

    @Override
    public byte[] decompressBase64(String compressedBase64) {
        Assert.hasText(compressedBase64, "compressedBase64 cannot be null or empty.");
        return decompress(TextCodec.BASE64URL.decode(compressedBase64));
    }
}
