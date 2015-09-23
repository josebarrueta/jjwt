package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionAlgorithm;

/**
 * CompressorFactory
 *
 * @since 0.5.2
 */
public interface CompressorFactory {

    Compressor createCompressor(CompressionAlgorithm algorithm);

}
