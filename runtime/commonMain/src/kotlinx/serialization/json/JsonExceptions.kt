/*
 * Copyright 2017-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

package kotlinx.serialization.json

import kotlinx.serialization.SerializationException

/**
 * Exception thrown when [Json] is unable to read or write a JSON.
 */
public sealed class JsonException(message: String) : SerializationException(message)

/**
 * Exception thrown when [Json] has failed to parse provided JSON.
 * Such exception usually indicate that [Json] input is not a valid JSON.
 */
public class JsonParsingException(message: String) : JsonException("Invalid JSON: $message")

/**
 * Exception thrown when requested [JsonElement] type differs from the actual one.
 * E.g.:
 * ```
 * val element: JsonElement = JsonLiteral("value")
 * val array = element.jsonArray // Raise JsonElementTypeMismatchException
 * ```
 */
public class JsonElementTypeMismatchException(key: String, expected: String) : JsonException("Element $key is not a $expected")
