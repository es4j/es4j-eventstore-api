package org.es4j.eventstore.api;

//import org.es4j.dotnet.Guid;
import org.es4j.eventstore.api.persistence.IPersistStreams;
import java.util.UUID;
import org.es4j.dotnet.IDisposable;
//import org.es4j.eventstore.api.persistence.IPersistStreams;


/// <summary>
/// Indicates the ability to store and retreive a stream of events.
/// </summary>
/// <remarks>
/// Instances of this class must be designed to be multi-thread safe such that they can be shared between threads.
/// </remarks>
public interface IStoreEvents extends IDisposable {

    /// <summary>
    /// Creates a new stream.
    /// </summary>
    /// <param name="streamId">The value which uniquely identifies the stream to be created.</param>
    /// <returns>An empty stream.</returns>
    IEventStream createStream(UUID streamId);

    /// <summary>
    /// Reads the stream indicated from the minimum revision specified up to the maximum revision specified or creates
    /// an empty stream if no commits are found and a minimum revision of zero is provided.
    /// </summary>
    /// <param name="streamId">The value which uniquely identifies the stream from which the events will be read.</param>
    /// <param name="minRevision">The minimum revision of the stream to be read.</param>
    /// <param name="maxRevision">The maximum revision of the stream to be read.</param>
    /// <returns>A series of committed events represented as a stream.</returns>
    /// <exception cref="StorageException" />
    /// <exception cref="StorageUnavailableException" />
    /// <exception cref="StreamNotFoundException" />
    IEventStream openStream(UUID streamId, int minRevision, int maxRevision);

    /// <summary>
    /// Reads the stream indicated from the point of the snapshot forward until the maximum revision specified.
    /// </summary>
    /// <param name="snapshot">The snapshot of the stream to be read.</param>
    /// <param name="maxRevision">The maximum revision of the stream to be read.</param>
    /// <returns>A series of committed events represented as a stream.</returns>
    /// <exception cref="StorageException" />
    /// <exception cref="StorageUnavailableException" />
    IEventStream openStream(Snapshot snapshot, int maxRevision);

    /// <summary>
    /// Gets a reference to the underlying persistence engine which allows direct access to persistence operations.
    /// </summary>
    IPersistStreams advanced(); // { get; }
}