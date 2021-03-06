/*
 * Copyright (C) 2015 jsonwebtoken.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionException;

/**
 * @since 0.5.2
 * @see DeflateCompressor
 * @see GzipCompressor
 */
public interface Compressor {

    /**
     * Compresses the {@code payload} passed as argument.
     *
     * @param payload the data to be compressed
     * @return {@code compressed} payload.
     * @throws CompressionException if an error occurs while compressing the {@code payload}.
     */
    byte[] compress(byte[] payload) throws CompressionException;

}
