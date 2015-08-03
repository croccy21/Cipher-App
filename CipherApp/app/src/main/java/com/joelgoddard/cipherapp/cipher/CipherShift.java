package com.joelgoddard.cipherapp.cipher;

/**
 * Created by Joel Goddard on 02/08/2015.
 */
public class CipherShift extends CipherData{

    protected int shift;

    public CipherShift(int shift){
        this.shift = shift;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }
}
