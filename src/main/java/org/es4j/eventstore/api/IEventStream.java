package org.es4j.eventstore.api;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
//import org.es4j.dotnet.Guid;
import org.es4j.dotnet.IDisposable;
import org.es4j.messaging.api.EventMessage;

//using Persistence;
/// <summary>
/// Indicates the ability to track a series of events and commit them to durable storage.
/// </summary>
/// <remarks>
/// Instances of this class are single threaded and should not be shared between threads.
/// </remarks>
public interface IEventStream extends IDisposable {

    /// <summary>
    /// Gets the value which uniquely identifies the stream to which the stream belongs.
    /// </summary>
    UUID getStreamId(); // { get; }

    /// <summary>
    /// Gets the value which indiciates the most recent committed revision of event stream.
    /// </summary>
    int getStreamRevision(); // { get; }

    /// <summary>
    /// Gets the value which indicates the most recent committed sequence identifier of the event stream.
    /// </summary>
    int getCommitSequence(); // { get; }

    /// <summary>
    /// Gets the collection of events which have been successfully persisted to durable storage.
    /// </summary>
    Collection<EventMessage> getCommittedEvents(); // { get; }

    /// <summary>
    /// Gets the collection of committed headers associated with the stream.
    /// </summary>
    Map<String, Object> getCommittedHeaders(); // { get; }

    /// <summary>
    /// Gets the collection of yet-to-be-committed events that have not yet been persisted to durable storage.
    /// </summary>
    Collection<EventMessage> getUncommittedEvents(); // { get; }

    /// <summary>
    /// Gets the collection of yet-to-be-committed headers associated with the uncommitted events.
    /// </summary>
    Map<String, Object> getUncommittedHeaders(); // { get; }

    /// <summary>
    /// Adds the event messages provided to the session to be tracked.
    /// </summary>
    /// <param name="uncommittedEvent">The event to be tracked.</param>
    void add(EventMessage uncommittedEvent);

    /// <summary>
    /// Commits the changes to durable storage.
    /// </summary>
    /// <param name="commitId">The value which uniquely identifies the commit.</param>
    /// <exception cref="DuplicateCommitException" />
    /// <exception cref="ConcurrencyException" />
    /// <exception cref="StorageException" />
    /// <exception cref="StorageUnavailableException" />
    void commitChanges(UUID commitId);

    /// <summary>
    /// Clears the uncommitted changes.
    /// </summary>
    void clearChanges();
}