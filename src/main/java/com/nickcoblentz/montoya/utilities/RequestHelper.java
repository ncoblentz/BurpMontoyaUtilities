package com.nickcoblentz.montoya.utilities;

import burp.api.montoya.http.message.HttpHeader;
import burp.api.montoya.http.message.requests.HttpRequest;
import burp.api.montoya.proxy.http.InterceptedRequest;



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

    public static String GetHeaderValue(HttpRequest request, String headerName)
    {
        if(request!=null && request.headers()!=null)
        {
            for(HttpHeader header : request.headers())
            {
                if(header.name().equalsIgnoreCase(headerName))
                {
                    return header.value();
                }
            }
        }
        return null;
    }

}
