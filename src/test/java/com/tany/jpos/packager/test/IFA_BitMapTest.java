package com.tany.jpos.packager.test;

import com.tany.jpos.pacakger.IFA_BitMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author ThinkPad
 * @Since 1.0
 */

public class IFA_BitMapTest {

    @Test
    public void testtoLocalByte(){
        byte[] bitmap = new byte[]{(byte)0x0F,(byte)0xff,(byte)0x01,(byte)0x01,(byte)0xb1,(byte)0xa1,(byte)0x01,(byte)0xc1};

        Assert.assertEquals(new String(new IFA_BitMap().toLocalByte(bitmap)),"0FFF0101B1A101C1");
    }
}
