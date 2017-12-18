package com.tany.jpos;

import com.tany.jpos.interfaces.Prefix;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.fail;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class BCDPrefixTest {

    @Test
    public void testUnpack(){
        byte[] b = new byte[]{0x01,0x02,0x33,0x34,0x01,0x32};
        Prefix prefix = new BCDPrefix(2);
        Assert.assertEquals(prefix.unpack(b,1), 2);

        prefix = new BCDPrefix(3);
        Assert.assertEquals(prefix.unpack(b,1), 233);
        try{
            prefix.unpack(b,2);
            fail("超出长度没有判断");
        }catch (Exception e){
            Assert.assertTrue(e instanceof ISORuntimeException);
        }
    }

}
