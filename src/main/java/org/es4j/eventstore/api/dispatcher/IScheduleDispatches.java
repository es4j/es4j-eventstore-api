package org.es4j.eventstore.api.dispatcher;

import org.es4j.dotnet.IDisposable;
import org.es4j.eventstore.api.Commit;


/// <summary>
/// Indicates the ability to schedule the specified commit for delivery--either now or in the future.
/// </summary>
/// <remarks>
/// Instances of this class must be designed to be multi-thread safe such that they can be shared between threads.
/// </remarks>
public interface IScheduleDispatches extends IDisposable {

    /// <summary>
    /// Schedules the series of messages contained within the commit provided for delivery to all interested parties.
    /// </summary>
    /// <param name="commit">The commit representing the series of messages to be dispatched.</param>
    void scheduleDispatch(Commit commit);
}
