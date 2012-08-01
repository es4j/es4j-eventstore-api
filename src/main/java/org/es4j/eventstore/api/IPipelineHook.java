package org.es4j.eventstore.api;

import org.es4j.dotnet.IDisposable;


// Provides the ability to hook into the pipeline of persisting a commit.
// Instances of this class must be designed to be multi-thread safe such that they can be shared between threads.
public interface IPipelineHook extends IDisposable {

    // Hooks into the selection pipeline just prior to the commit being returned to the caller.
    // <param name="committed">The commit to be filtered.</param>
    // <returns>If successful, returns a populated commit; otherwise returns null.</returns>
    Commit select(Commit committed);

    // Hooks into the commit pipeline prior to persisting the commit to durable storage.
    // <param name="attempt">The attempt to be committed.</param>
    // <returns>If processing should continue, returns true; otherwise returns false.</returns>
    boolean preCommit(Commit attempt);

    // Hooks into the commit pipeline just after the commit has been *successfully* committed to durable storage.
    // <param name="committed">The commit which has been persisted.</param>
    void postCommit(Commit committed);
}
