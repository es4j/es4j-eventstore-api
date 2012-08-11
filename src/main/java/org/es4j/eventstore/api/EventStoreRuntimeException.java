package org.es4j.eventstore.api;

import org.es4j.dotnet.SerializationInfo;
import org.es4j.dotnet.streams.StreamingContext;


@SuppressWarnings("serial")
public class EventStoreRuntimeException extends RuntimeException {

    public EventStoreRuntimeException() {
    }

    public EventStoreRuntimeException(String message) {
    }

    public EventStoreRuntimeException(String message, Throwable innerException) {
    }

    public EventStoreRuntimeException(SerializationInfo info, StreamingContext context) {
    }
}
