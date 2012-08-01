package org.es4j.eventstore.api.conversion;

import org.es4j.dotnet.SerializationInfo;
import org.es4j.dotnet.StreamingContext;
import org.es4j.eventstore.api.EventStoreRuntimeException;

/// <summary>
/// Represents the failure that occurs when there are two or more event converters created for the same source type.
/// </summary>
// [Serializable]
public class MultipleConvertersFoundException extends EventStoreRuntimeException {
    /// <summary>
    /// Initializes a new instance of the MultipleConvertersFoundException class.
    /// </summary>

    public MultipleConvertersFoundException() {
    }

    /// <summary>
    /// Initializes a new instance of the MultipleConvertersFoundException class.
    /// </summary>
    /// <param name="message">The message that describes the error.</param>
    public MultipleConvertersFoundException(String message) {
        super(message);
    }

    /// <summary>
    /// Initializes a new instance of the MultipleConvertersFoundException class.
    /// </summary>
    /// <param name="message">The message that describes the error.</param>
    /// <param name="innerException">The exception that is the cause of the current exception.</param>
    public MultipleConvertersFoundException(String message, Exception innerException) {
        super(message, innerException);
    }

    /// <summary>
    /// Initializes a new instance of the MultipleConvertersFoundException class.
    /// </summary>
    /// <param name="info">The serialization info.</param>
    /// <param name="context">The streaming context.</param>
    protected MultipleConvertersFoundException(SerializationInfo info, StreamingContext context) {
        super(info, context);
    }
}