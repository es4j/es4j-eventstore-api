package org.es4j.eventstore.api;

import org.es4j.dotnet.SerializationInfo;
import org.es4j.dotnet.StreamingContext;

/// <summary>
/// Represents an optimistic concurrency conflict between multiple writers.
/// </summary>
//[Serializable]
public class ConcurrencyException extends EventStoreRuntimeException {
    /// <summary>
    /// Initializes a new instance of the ConcurrencyException class.
    /// </summary>

    public ConcurrencyException() {
    }

    /// <summary>
    /// Initializes a new instance of the ConcurrencyException class.
    /// </summary>
    /// <param name="message">The message that describes the error.</param>
    public ConcurrencyException(String message) {
        super(message);
    }

    /// <summary>
    /// Initializes a new instance of the ConcurrencyException class.
    /// </summary>
    /// <param name="message">The message that describes the error.</param>
    /// <param name="innerException">The message that is the cause of the current exception.</param>
    public ConcurrencyException(String message, Exception innerException) {
        super(message, innerException);
    }

    /// <summary>
    /// Initializes a new instance of the ConcurrencyException class.
    /// </summary>
    /// <param name="info">The SerializationInfo that holds the serialized object data of the exception being thrown.</param>
    /// <param name="context">The StreamingContext that contains contextual information about the source or destination.</param>
    protected ConcurrencyException(SerializationInfo info, StreamingContext context) {
        super(info, context);
    }
}