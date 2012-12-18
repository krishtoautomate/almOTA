package HPQC;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.ibm.misc.BASE64Decoder;
import com.ibm.misc.BASE64Encoder;

public class EncryptUtil {
    public static final String DEFAULT_ENCODING="UTF-8";
    static BASE64Encoder enc=new BASE64Encoder();
    static BASE64Decoder dec=new BASE64Decoder();
    
    public static String encrypt(String toEncrypt) {
        try {
            return enc.encode(toEncrypt.getBytes(DEFAULT_ENCODING));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
    
    public static String decrypt(String toDecrypt){
        try {
            return new String(dec.decodeBuffer(toDecrypt), DEFAULT_ENCODING);
        } catch (IOException e) {
            return null;
        }
    }
    
    public static void main(String args[]) {
        String password = "";
        System.out.println(encrypt(password));
    }
}