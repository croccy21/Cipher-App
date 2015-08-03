package com.joelgoddard.cipherapp.cipher;

/**
 * Created by Joel Goddard on 02/08/2015.
 */
public class CipherCeasar extends Cipher {

    public CipherCeasar(){
        super();
        availableModes[CIPHER_ENCODE] = true;
        availableModes[CIPHER_DECODE] = true;
        availableModes[CIPHER_AUTO_SOLVE] = false;
    }

    @Override
    public String encipher(String plain, CipherData data) {
        String cipher ="";
        if(data instanceof CipherShift) {
            char[] plainLetters = plain.toCharArray();
            for (char letter : plainLetters) {

            }
        }
        return cipher;
    }
}
