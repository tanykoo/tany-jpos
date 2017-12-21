package com.tany.jpos;

import com.tany.jpos.interfaces.Prefix;
import com.tany.jpos.iso.ISORuntimeException;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.fail;

/**
 * @Author ThinkPad
 * @Since 1.0
 */
public class StringPrefixTest {
    @Test
    public void testPack(){
        Prefix prefix = new StringPrefix(3);

        Assert.assertArrayEquals(prefix.pack(12),new byte[]{'0', '1', '2'});
        Assert.assertArrayEquals(prefix.pack(831),new byte[]{'8', '3', '1'});

        try{
            prefix.pack(1381);
            fail("前缀长度没校验");
        }catch (Exception e){
            Assert.assertTrue(e instanceof ISORuntimeException);
        }
    }
    @Test
    public void testUnPack(){
        byte[] b = new byte[]{0x01,0x02,0x33,0x34,0x01,0x32};
        Prefix prefix = new StringPrefix(2);
        Assert.assertEquals(prefix.unpack(b,2), 34);

        prefix = new StringPrefix(1);
        Assert.assertEquals(prefix.unpack(b,3), 4);
    }

}
