package org.es4j.eventstore.api.persistence;

import java.util.UUID;
//import org.es4j.dotnet.Guid;


/// <summary>
/// Indicates the most recent information representing the head of a given stream.
/// </summary>
public class StreamHead {

    /// <summary>
    /// Initializes a new instance of the StreamHead class.
    /// </summary>
    /// <param name="streamId">The value which uniquely identifies the stream where the last snapshot exceeds the allowed threshold.</param>
    /// <param name="headRevision">The value which indicates the revision, length, or number of events committed to the stream.</param>
    /// <param name="snapshotRevision">The value which indicates the revision at which the last snapshot was taken.</param>
    public StreamHead(UUID streamId, 
                      int   headRevision, 
                      int   snapshotRevision) {
        this();
	this.streamId         = streamId;
        this.headRevision     = headRevision;
        this.snapshotRevision = snapshotRevision;
    }

    /// <summary>
    /// Initializes a new instance of the StreamHead class.
    /// </summary>
    protected StreamHead() {
    }
    /// <summary>
    /// Gets the value which uniquely identifies the stream where the last snapshot exceeds the allowed threshold.
    /// </summary>
    private UUID streamId; // { get; private set; }

    /// <summary>
    /// Gets the value which indicates the revision, length, or number of events committed to the stream.
    /// </summary>
    private int headRevision; // { get; private set; }
    /// <summary>
    /// Gets the value which indicates the revision at which the last snapshot was taken.
    /// </summary>
    private int snapshotRevision; // { get; private set; }

    /// <summary>
    /// Determines whether the specified object is equal to the current object.
    /// </summary>
    /// <param name="obj">The object to compare with the current object.</param>
    /// <returns>If the two objects are equal, returns true; otherwise false.</returns>
    @Override // override
    public boolean equals(Object obj) {
        StreamHead streamHead = (obj instanceof StreamHead)? (StreamHead)obj : null; // as StreamHead;
        return streamHead != null && streamHead.getStreamId() == this.streamId;
    }

    /// <summary>
    /// Returns the hash code for this instance.
    /// </summary>
    /// <returns>The hash code for this instance.</returns>
    @Override // override
    public int hashCode() {
        return this.streamId.hashCode();
    }

    public int getHeadRevision() {
        return headRevision;
    }

    public int getSnapshotRevision() {
        return snapshotRevision;
    }

    public UUID getStreamId() {
        return streamId;
    }
}