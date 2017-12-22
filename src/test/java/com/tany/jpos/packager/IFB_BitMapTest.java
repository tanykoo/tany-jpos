package com.tany.jpos.packager;

import com.tany.jpos.iso.ISOBitMap;
import com.tany.jpos.iso.ISOException;
import com.tany.jpos.iso.pacakger.IFA_BitMap;
import com.tany.jpos.iso.pacakger.IFB_BitMap;
import com.tany.jpos.util.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.fail;

/**
 * @Author ThinkPad
 * @Since 1.0
 */

public class IFB_BitMapTest {

    @Test
    public void testtoLocalByte(){

        byte[] bitmap = new byte[]{(byte)0x0F,(byte)0xff,(byte)0x01,(byte)0x01,(byte)0xb1,(byte)0xa1,(byte)0x01,(byte)0xc1,(byte)0x0F,(byte)0xff,(byte)0x01,(byte)0x01,(byte)0xb1,(byte)0xa1,(byte)0x01,(byte)0xc1};

        try {
            Assert.assertEquals(new IFB_BitMap().unPack(bitmap,0).toString(),"0000111111111111000000010000000110110001101000010000000111000001");
        } catch (ISOException e) {
            e.printStackTrace();
            fail("解包报错");
        }
        ISOBitMap isoBitMap = new ISOBitMap();
        String bit = "10001111111111110000000100000001101100011010000100000001110000011";
        for(int i = 0 ; i < bit.length(); i++){
            if(bit.charAt(i) == '1'){
                isoBitMap.setYes(i);
            }
        }
        try {
            Assert.assertEquals(StringUtils.byte2hex((new IFB_BitMap().pack(isoBitMap))),"8FFF0101B1A101C18000000000000000");
        } catch (ISOException e) {
            e.printStackTrace();
            fail("解包报错");
        }
    }
}
