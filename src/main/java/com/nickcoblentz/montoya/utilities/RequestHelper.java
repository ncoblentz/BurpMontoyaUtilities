package com.nickcoblentz.montoya.utilities;

import burp.api.montoya.proxy.http.InterceptedRequest;

import java.net.http.HttpRequest;

public class RequestHelper {
    private static String GetEmptyNoteIfNull(String note)
    {
        if (note == null) {
            note = "";
        }
        return note;
    }
    public static void PrependNote(InterceptedRequest interceptedRequest, String note)
    {
        if(interceptedRequest!=null) {
            interceptedRequest.annotations().setNotes(note + ", " + GetEmptyNoteIfNull(interceptedRequest.annotations().notes()));
        }
    }

    public static void AppendNote(InterceptedRequest interceptedRequest, String note)
    {
        if(interceptedRequest!=null) {
            interceptedRequest.annotations().setNotes(GetEmptyNoteIfNull(interceptedRequest.annotations().notes())+", " + note);
        }
    }
}
