package com.nickcoblentz.montoya.utilities;

import burp.api.montoya.http.message.HttpHeader;
import burp.api.montoya.http.message.requests.HttpRequest;
import burp.api.montoya.proxy.http.InterceptedRequest;



public class RequestHelper {
    private static String CombineNotes(String note1,String seperator, String note2)
    {
        if(note1==null || note1.length()<1){
            return note2;
        }
        if(note2==null || note1.length()<1){
            return note1;
        }
        return note1+seperator+note2;
    }
    public static void PrependNote(InterceptedRequest interceptedRequest, String note)
    {
        if(interceptedRequest!=null) {
            interceptedRequest.annotations().setNotes(CombineNotes(note,",",interceptedRequest.annotations().notes()));
        }
    }

    public static void AppendNote(InterceptedRequest interceptedRequest, String note)
    {
        if(interceptedRequest!=null) {
            interceptedRequest.annotations().setNotes(CombineNotes(interceptedRequest.annotations().notes(),",",note));
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
