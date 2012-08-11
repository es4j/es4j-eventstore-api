package org.es4j.eventstore.api;

import org.es4j.dotnet.SerializationInfo;
import org.es4j.dotnet.streams.StreamingContext;


/// <summary>
/// Represents an attempt to retrieve a nonexistent event stream.
/// </summary>
//[Serializable]
@SuppressWarnings("serial")
public class StreamNotFoundException extends EventStoreRuntimeException {

    /// <summary>
    /// Initializes a new instance of the StreamNotFoundException class.
    /// </summary>

    public StreamNotFoundException() {
    }

    /// <summary>
    /// Initializes a new instance of the StreamNotFoundException class.
    /// </summary>
    /// <param name="message">The message that describes the error.</param>
    public StreamNotFoundException(String message) {
        super(message);
    }

    /// <summary>
    /// Initializes a new instance of the StreamNotFoundException class.
    /// </summary>
    /// <param name="message">The message that describes the error.</param>
    /// <param name="innerException">The message that is the cause of the current exception.</param>
    public StreamNotFoundException(String message, Exception innerException) {
        super(message, innerException);
    }

    /// <summary>
    /// Initializes a new instance of the StreamNotFoundException class.
    /// </summary>
    /// <param name="info">The SerializationInfo that holds the serialized object data of the exception being thrown.</param>
    /// <param name="context">The StreamingContext that contains contextual information about the source or destination.</param>
    protected StreamNotFoundException(SerializationInfo info, StreamingContext context) {
        super(info, context);
    }
}