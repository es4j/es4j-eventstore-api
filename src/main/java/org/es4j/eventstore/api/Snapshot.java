package org.es4j.eventstore.api;

import java.io.Serializable;
import java.util.UUID;
//import org.es4j.dotnet.Guid;

/// <summary>
/// Represents a materialized view of a stream at specific revision.
/// </summary>
//[DataContract, Serializable]
public class Snapshot implements Serializable {

    /// <summary>
    /// Initializes a new instance of the Snapshot class.
    /// </summary>
    /// <param name="streamId">The value which uniquely identifies the stream to which the snapshot applies.</param>
    /// <param name="streamRevision">The position at which the snapshot applies.</param>
    /// <param name="payload">The snapshot or materialized view of the stream at the revision indicated.</param>

    public Snapshot(UUID streamId, int streamRevision, Object payload) {
        this();
        this.streamId       = streamId;
        this.streamRevision = streamRevision;
        this.payload        = payload;
    }

    /// <summary>
    /// Initializes a new instance of the Snapshot class.
    /// </summary>
    protected Snapshot() {
    }

    /// <summary>
    /// Gets the value which uniquely identifies the stream to which the snapshot applies.
    /// </summary>
    //[DataMember] virtual
    private UUID streamId; // { get; private set; }

    /// <summary>
    /// Gets the position at which the snapshot applies.
    /// </summary>
    //[DataMember] virtual
    private int streamRevision; // { get; private set; }

    /// <summary>
    /// Gets the snapshot or materialized view of the stream at the revision indicated.
    /// </summary>
    //[DataMember] virtual
    private Object payload; // { get; private set; }


    public Object getPayload() {
        return payload;
    }

    public UUID getStreamId() {
        return streamId;
    }

    public int getStreamRevision() {
        return streamRevision;
    }

}