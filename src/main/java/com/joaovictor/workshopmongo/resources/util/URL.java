package com.joaovictor.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    public static String decodeParams(String text){ //codificador de string
     try{
         return URLDecoder.decode(text, "UTF-8");
     }catch (UnsupportedEncodingException e ){
         return "";
     }
    }
}
