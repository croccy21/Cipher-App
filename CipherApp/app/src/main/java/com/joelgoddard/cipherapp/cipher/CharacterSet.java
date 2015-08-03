package com.joelgoddard.cipherapp.cipher;

/**
 * Created by Joel Goddard on 01/08/2015.
 */
public class CharacterSet {
    protected String plain;
    protected String cipher;
    protected int length;

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

    public char getRelative(char c, int diff, boolean switchSet){
        boolean usePlain;
        int index = plain.indexOf(c);
        if(index==-1){
            index = cipher.indexOf(c);
            if(index==-1){
                return 0;
            }
            usePlain = !switchSet;

        }
        else{
            usePlain = switchSet;
        }
        int newIndex = (index+diff)%length;
        if(usePlain){
            return plain.charAt(newIndex);
        }
        else{
            return cipher.charAt(newIndex);
        }
    }
}
