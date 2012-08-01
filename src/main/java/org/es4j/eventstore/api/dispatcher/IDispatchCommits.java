package org.es4j.eventstore.api.dispatcher;

import org.es4j.dotnet.IDisposable;
import org.es4j.eventstore.api.Commit;


/// <summary>
/// Indicates the ability to dispatch the specified commit to some kind of communications infrastructure.
/// </summary>
/// <remarks>
/// Instances of this class must be designed to be multi-thread safe such that they can be shared between threads.
/// </remarks>
public interface IDispatchCommits extends IDisposable {

    /// <summary>
    /// Dispatches the commit specified to the messaging infrastructure.
    /// </summary>
    /// <param name="commit">The commmit to be dispatched.</param>
    void dispatch(Commit commit);
}