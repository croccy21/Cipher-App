package com.joelgoddard.cipherapp;

import android.util.Log;

import java.text.MessageFormat;

/**
 * Created by Joel Goddard on 01/08/2015.
 */
public class Cipher {

    public static int CIPHER_ENCODE = 0;
    public static int CIPHER_DECODE = 1;
    public static int CIPHER_AUTO_SOLVE = 2;

    protected String name;
    protected String type;
    protected String description;
    protected boolean[] availableModes = new boolean[3];
    protected int securityRating;
    protected boolean possiblyInsecure;

    public Cipher(){

    }

    public Cipher(String serialCode){
        if(serialCode.startsWith("Cipher[") && serialCode.endsWith("]")) {
            String code = serialCode.substring(serialCode.indexOf('[')+1, serialCode.indexOf(']'));
            String[] arguments = code.split(",");
            for (String arg:arguments){
                String[] split = arg.split(":");
                String var = split[0];
                String val = split[1];
                Log.d("Debug", arg+") "+var+":"+val);
                switch (var){
                    case "name": name=val;break;
                    case "type": type=val;break;
                    case "description": description=val;break;
                    case "mode0":availableModes[0]=Boolean.valueOf(val);break;
                    case "mode1":availableModes[1]=Boolean.valueOf(val);break;
                    case "mode2":availableModes[2]=Boolean.valueOf(val);break;
                    case "rating":securityRating=Integer.valueOf(val);break;
                    case "insecure":possiblyInsecure=Boolean.getBoolean(val);break;
                }
            }
        }
        Log.d("Debug", serialize());
    }

    public String encipher(String plain, CipherData data){
        return plain.toUpperCase();
    }

    public String decipher(String cipher, CipherData data){
        return cipher.toLowerCase();
    }

    public String autoSolve(String cipher, CipherSolveData data){
        return cipher.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String cipherType) {
        this.type = cipherType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean[] getAvailableModes() {
        return availableModes;
    }

    public boolean getAvailableMode(int index){
        return availableModes[index];
    }

    public void setAvailableModes(boolean[] availableModes) {
        this.availableModes = availableModes;
    }

    public int getSecurityRating() {
        return securityRating;
    }

    public void setSecurityRating(int securityRating) {
        this.securityRating = securityRating;
    }

    public boolean isPossiblyInsecure() {
        return possiblyInsecure;
    }

    public void setPossiblyInsecure(boolean possiblyInsecure) {
        this.possiblyInsecure = possiblyInsecure;
    }

    public String serialize(){
        return MessageFormat.format("Cipher[name:{0},type:{1},description:{2},mode0:{3},mode1:{4},mode2:{5},rating:{6},insecure:{}]",
                name, type, description, availableModes[CIPHER_ENCODE], availableModes[CIPHER_DECODE], availableModes[CIPHER_AUTO_SOLVE],
                securityRating, possiblyInsecure);
    }
}
