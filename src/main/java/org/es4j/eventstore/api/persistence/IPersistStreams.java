package org.es4j.eventstore.api.persistence;

import org.es4j.dotnet.IDisposable;
import org.es4j.eventstore.api.Commit;
import org.es4j.eventstore.api.IAccessSnapshots;
import org.es4j.eventstore.api.ICommitEvents;
import org.es4j.util.DateTime;


/// <summary>
/// Indicates the ability to adapt the underlying persistence infrastructure to behave like a stream of events.
/// </summary>
/// <remarks>
/// Instances of this class must be designed to be multi-thread safe such that they can be shared between threads.
/// </remarks>
public interface IPersistStreams extends IDisposable, ICommitEvents, IAccessSnapshots {

    /// <summary>
    /// Initializes and prepares the storage for use, if not already performed.
    /// </summary>
    /// <exception cref="StorageException" />
    /// <exception cref="StorageUnavailableException" />
    void initialize();

    /// <summary>
    /// Gets all commits on or after from the specified starting time.
    /// </summary>
    /// <param name="start">The point in time at which to start.</param>
    /// <returns>All commits that have occurred on or after the specified starting time.</returns>
    /// <exception cref="StorageException" />
    /// <exception cref="StorageUnavailableException" />
    Iterable<Commit> getFrom(DateTime start);

    /// <summary>
    /// Gets a set of commits that has not yet been dispatched.
    /// </summary>
    /// <returns>The set of commits to be dispatched.</returns>
    /// <exception cref="StorageException" />
    /// <exception cref="StorageUnavailableException" />
    Iterable<Commit> getUndispatchedCommits();

    /// <summary>
    /// Marks the commit specified as dispatched.
    /// </summary>
    /// <param name="commit">The commit to be marked as dispatched.</param>
    /// <exception cref="StorageException" />
    /// <exception cref="StorageUnavailableException" />
    void markCommitAsDispatched(Commit commit);

    /// <summary>
    /// Completely DESTROYS the contents of ANY and ALL streams that have been successfully persisted.  Use with caution.
    /// </summary>
    void purge();
}