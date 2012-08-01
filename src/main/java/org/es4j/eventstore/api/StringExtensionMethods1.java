package org.es4j.eventstore.api;

import org.es4j.dotnet.CultureInfo;
//using System.Globalization;


/// <summary>
/// A set of common methods used through the EventStore.
/// </summary>
public class StringExtensionMethods1 {

    /// <summary>
    /// Formats the string provided using the values specified.
    /// </summary>
    /// <param name="format">The string to be formated.</param>
    /// <param name="values">The values to be embedded into the string.</param>
    /// <returns>The formatted string.</returns>
    public static String formatWith(/*this*/ String format, /*params*/ Object... values) {
        return String.format(CultureInfo.getInvariantCulture(), (format == null) ? null : StringExtensionMethods1.Empty(), values);
    }

    public static String Empty() {
        return "";
    }
}