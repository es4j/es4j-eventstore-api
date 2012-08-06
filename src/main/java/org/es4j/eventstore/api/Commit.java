package org.es4j.eventstore.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.es4j.messaging.api.EventMessage;
import org.es4j.util.DateTime;


// Represents a series of events which have been fully committed as a single unit and which apply to the stream indicated.
// [DataContract, Serializable]
public final class Commit implements Serializable /*, Cloneable*/ {

    // <summary>
    // Initializes a new instance of the Commit class.
    // </summary>
    // <param name="streamId">The value which uniquely identifies the stream to which the commit belongs.</param>
    // <param name="streamRevision">The value which indicates the revision of the most recent event in the stream to which this commit applies.</param>
    // <param name="commitId">The value which uniquely identifies the commit within the stream.</param>
    // <param name="commitSequence">The value which indicates the sequence (or position) in the stream to which this commit applies.</param>
    // <param name="commitStamp">The point in time at which the commit was persisted.</param>
    // <param name="headers">The metadata which provides additional, unstructured information about this commit.</param>
    // <param name="events">The collection of event messages to be committed as a single unit.</param>
    public Commit(
            UUID                streamId,
            int                 streamRevision,
            UUID                commitId,
            int                 commitSequence,
            DateTime            commitStamp,
            Map<String, Object> headers,
            List<EventMessage>  events) {
        //this();
        this.streamId       = streamId;
        this.commitId       = commitId;
        this.streamRevision = streamRevision;
        this.commitSequence = commitSequence;
        this.commitStamp    = new DateTime(commitStamp.getMillis());

        //this.headers = (headers != null)? Collections.unmodifiableMap(new HashMap<String, Object>(headers))
        //                                : Collections.unmodifiableMap(new HashMap<String, Object>());
        this.headers = (headers != null)? new HashMap<String, Object>(headers)
                                        : new HashMap<String, Object>();
        this.events  = (events  != null)? Collections.unmodifiableList(new ArrayList<EventMessage>(events))
                                        : Collections.unmodifiableList(new ArrayList<EventMessage>());
    }

    /// <summary>
    /// Initializes a new instance of the Commit class.
    /// </summary>
    //protected Commit() {
    //}

    /// <summary>
    /// Gets the value which uniquely identifies the stream to which the commit belongs.
    /// </summary>
    //[DataMember] // virtual
    private final UUID streamId; // { get; private set; }

    /// <summary>
    /// Gets the value which indicates the revision of the most recent event in the stream to which this commit applies.
    /// </summary>
    //[DataMember] // virtual
    private final int streamRevision; // { get; private set; }

    /// <summary>
    /// Gets the value which uniquely identifies the commit within the stream.
    /// </summary>
    //[DataMember] // virtual
    private final UUID commitId; // { get; private set; }

    /// <summary>
    /// Gets the value which indicates the sequence (or position) in the stream to which this commit applies.
    /// </summary>
    //[DataMember] virtual
    private final int commitSequence; // { get; private set; }

    /// <summary>
    /// Gets the point in time at which the commit was persisted.
    /// </summary>
    //[DataMember] virtual
    private final DateTime commitStamp; // { get; private set; }

    /// <summary>
    /// Gets the metadata which provides additional, unstructured information about this commit.
    /// </summary>
    //[DataMember] virtual
    private final Map<String, Object> headers; // { get; private set; }

    // <summary>
    // Gets the collection of event messages to be committed as a single unit.
    // </summary>
    // [DataMember] virtual
    private final List<EventMessage> events; // { get; private set; }

    // Determines whether the specified object is equal to the current object.
    // <param name="obj">The object to compare with the current object.</param>
    // <returns>If the two objects are equal, returns true; otherwise false.</returns>
    @Override
    public boolean equals(Object obj) {
        Commit commit = (obj instanceof Commit)? (Commit) obj : null;
        return commit != null &&
               commit.getStreamId() == this.streamId &&
               commit.getCommitId() == this.commitId;
    }

    // Returns the hash code for this instance.
    // <returns>The hash code for this instance.</returns>
    @Override
    public int hashCode() {
        return this.streamId.hashCode() ^ this.commitId.hashCode();
    }

    /**
    * Implement clone as follows
    * <ul>
    * <li>the class declaration "implements Cloneable" (not needed if already declared in superclass)
    * <li>declare clone method as public
    * <li>if the class is final, clone does not need to throw CloneNotSupportedException
    * <li>call super.clone and cast to this class
    * <li>as in defensive copying, ensure each mutable field has an independent copy
    *     constructed, to avoid sharing internal state between objects
    * </ul>
    */
    /*
    @Override
    public Object clone() throws CloneNotSupportedException {
        //get initial bit-by-bit copy, which handles all immutable fields
        Commit result = (Commit) super.clone();

        // mutable fields need to be made independent of this object, for reasons similar to those for
        // defensive copies - to prevent unwanted access to this object's internal state
        //result.fBestBeforeDate = new Date(this.fBestBeforeDate.getTime());

        if(true) throw new UnsupportedOperationException("Not yet implemented"); // for now
        //result.events  = new ArrayList(this.events);
        //result.headers = new TreeMap(this.headers);

        return result;
    }
    */

    public final UUID getCommitId() {
        return commitId;
    }

    public final int getCommitSequence() {
        return commitSequence;
    }

    public final DateTime getCommitStamp() {
        return new DateTime(commitStamp.getMillis());
    }

    public final List<EventMessage> getEvents() {
        return Collections.unmodifiableList(events);
    }

    public final Map<String, Object> getHeaders() {
        return headers; // Collections.unmodifiableMap(headers);
    }

    public final UUID getStreamId() {
        return streamId;
    }

    public final int getStreamRevision() {
        return streamRevision;
    }
}