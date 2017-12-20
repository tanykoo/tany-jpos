package com.tany.jpos.util;


/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class StringUtils {

    public static String byte2hex(byte [] b){
        StringBuilder tmp = new StringBuilder();
        for(int i =0 ; i < b.length; i++){
            String bs = Integer.toHexString((b[i] & 0xff)).toUpperCase();
            tmp.append(bs.length()==2 ? bs : "0" + bs);
        }
        return tmp.toString();
    }

    public static byte[] hex2byte(String hex){
        if(!hex.matches("[0-9,a-f,A-F]*")){
            throw new RuntimeException("非16进制字符串");
        }
        if(hex.length() % 2 ==0 ){
            hex = hex.toUpperCase();
        }else {
            hex = '0' + hex.toUpperCase();
        }
        byte[] b = new byte[(hex.length() + 1)/2];
        for(int i = b.length-1 ; i >= 0; i--){
            int end4 = JPosUtils.UPPER_HEX_STR.indexOf(hex.charAt(i*2+1));
            int frount4 = JPosUtils.UPPER_HEX_STR.indexOf(hex.charAt(i*2));

            b[i] = (byte) (((frount4 << 4) + end4)&0xff);

        }
        return b;
    }
}
