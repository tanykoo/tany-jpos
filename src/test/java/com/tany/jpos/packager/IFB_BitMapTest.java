package com.tany.jpos.packager;

import com.tany.jpos.iso.ISOException;
import com.tany.jpos.iso.pacakger.IFA_BitMap;
import com.tany.jpos.iso.pacakger.IFB_BitMap;
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
    }
}
