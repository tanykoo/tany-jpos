package com.tany.jpos.packager;

import com.tany.jpos.iso.ISOBitMap;
import com.tany.jpos.iso.ISOException;
import com.tany.jpos.iso.ISORuntimeException;
import com.tany.jpos.iso.pacakger.IFA_BitMap;
import com.tany.jpos.iso.pacakger.IFB_BitMap;
import com.tany.jpos.util.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static junit.framework.TestCase.fail;

/**
 * @Author ThinkPad
 * @Since 1.0
 */

public class IFA_BitMapTest {

    @Test
    public void testtoLocalByte(){

        byte[] bitmap = "0FFF0101B1A101C10FFF0101B1A101C1".getBytes();
        try {
            Assert.assertEquals(new IFA_BitMap().unPack(bitmap,0).toString(),"0000111111111111000000010000000110110001101000010000000111000001");
        } catch (ISOException e) {
            e.printStackTrace();
            fail("解包报错");
        } catch (Exception e){
            Assert.assertTrue(e instanceof RuntimeException);
        }
        ISOBitMap isoBitMap = new ISOBitMap();
        String bit = "0000111111111111000000010000000110110001101000010000000111000001";
        for(int i = 0 ; i < bit.length(); i++){
            if(bit.charAt(i) == '1'){
                isoBitMap.setYes(i);
            }
        }
        try {
            Assert.assertEquals(new String((new IFA_BitMap().pack(isoBitMap))),"0FFF0101B1A101C1");
        } catch (ISOException e) {
            e.printStackTrace();
            fail("解包报错");
        }
    }
}
