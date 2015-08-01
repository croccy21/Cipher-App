package com.joelgoddard.cipherapp.cipher;

/**
 * Created by Joel Goddard on 01/08/2015.
 */
public class CharacterSet {
    protected String plain;
    protected String cipher;

    public CharacterSet(String plain, String cipher){
        if(plain.length()==cipher.length()){
            String used = "";
            boolean canContinue=true;
            for(int i=0;i<plain.length();i++){
                if(stringContains(used, plain.charAt(i))){
                    canContinue=false;
                    break;
                }
                if(stringContains(used, cipher.charAt(i))){
                    canContinue=false;
                    break;
                }
            }
            if (canContinue){
                this.plain = plain;
                this.cipher = cipher;
            }
        }
    }

    public static boolean stringContains(String container, char search){
        for(char c:container.toCharArray()){
            if(c==search) {
                return true;
            }
        }
        return false;
    }

    public String getPlain() {
        return plain;
    }

    public String getCipher() {
        return cipher;
    }

    public char getCorrespondingCipher(char plainChar){
        return cipher.charAt(plain.indexOf(plainChar));
    }

    public char getCorrespondingPlain(char cipherChar){
        return plain.charAt(cipher.indexOf(cipherChar));
    }
}
