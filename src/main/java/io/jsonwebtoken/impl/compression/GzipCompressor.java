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

import io.jsonwebtoken.impl.CompressionException;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Objects;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * GzipCompressor
 *
 * @since 0.5.2
 */
public class GzipCompressor implements Compressor {

    @Override
    public byte[] compress(byte[] payload) {
        Assert.notNull(payload, "payload cannot be null.");

        ByteArrayOutputStream outputStream = null;
        GZIPOutputStream gzipOutputStream = null;

        try {
            outputStream = new ByteArrayOutputStream();
            gzipOutputStream = new GZIPOutputStream(outputStream, true);
            gzipOutputStream.write(payload, 0, payload.length);
            gzipOutputStream.finish();
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new CompressionException("Unable to compress payload.", e);
        } finally {
            Objects.nullSafeClose(outputStream, gzipOutputStream);
        }

    }
}
