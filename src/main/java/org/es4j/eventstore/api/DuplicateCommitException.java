package org.es4j.eventstore.api;


import org.es4j.dotnet.SerializationInfo;
import org.es4j.dotnet.StreamingContext;


/// <summary>
/// Represents an attempt to commit the same information more than once.
/// </summary>
//[Serializable]
public class DuplicateCommitException extends EventStoreRuntimeException {

    /// <summary>
    /// Initializes a new instance of the DuplicateCommitException class.
    /// </summary>
    public DuplicateCommitException() {
    }

    /// <summary>
    /// Initializes a new instance of the DuplicateCommitException class.
    /// </summary>
    /// <param name="message">The message that describes the error.</param>
    public DuplicateCommitException(String message) {
        super(message);
    }

    /// <summary>
    /// Initializes a new instance of the DuplicateCommitException class.
    /// </summary>
    /// <param name="message">The message that describes the error.</param>
    /// <param name="innerException">The message that is the cause of the current exception.</param>
    public DuplicateCommitException(String message, Exception innerException) {
        super(message, innerException);
    }

    /// <summary>
    /// Initializes a new instance of the DuplicateCommitException class.
    /// </summary>
    /// <param name="info">The SerializationInfo that holds the serialized object data of the exception being thrown.</param>
    /// <param name="context">The StreamingContext that contains contextual information about the source or destination.</param>
    protected DuplicateCommitException(SerializationInfo info, StreamingContext context) {
        super(info, context);
    }
}


/*
namespace EventStore
{
	using System;
	using System.Runtime.Serialization;

	/// <summary>
	/// Represents an attempt to commit the same information more than once.
	/// </summary>
	[Serializable]
	public class DuplicateCommitException : Exception
	{
		/// <summary>
		/// Initializes a new instance of the DuplicateCommitException class.
		/// </summary>
		public DuplicateCommitException()
		{
		}

		/// <summary>
		/// Initializes a new instance of the DuplicateCommitException class.
		/// </summary>
		/// <param name="message">The message that describes the error.</param>
		public DuplicateCommitException(string message)
			: base(message)
		{
		}

		/// <summary>
		/// Initializes a new instance of the DuplicateCommitException class.
		/// </summary>
		/// <param name="message">The message that describes the error.</param>
		/// <param name="innerException">The message that is the cause of the current exception.</param>
		public DuplicateCommitException(string message, Exception innerException)
			: base(message, innerException)
		{
		}

		/// <summary>
		/// Initializes a new instance of the DuplicateCommitException class.
		/// </summary>
		/// <param name="info">The SerializationInfo that holds the serialized object data of the exception being thrown.</param>
		/// <param name="context">The StreamingContext that contains contextual information about the source or destination.</param>
		protected DuplicateCommitException(SerializationInfo info, StreamingContext context)
			: base(info, context)
		{
		}
	}
}
 */