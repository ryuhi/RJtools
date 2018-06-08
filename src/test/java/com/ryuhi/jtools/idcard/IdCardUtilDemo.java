package com.ryuhi.jtools.idcard;

import org.junit.Assert;
import org.junit.Test;

public class IdCardUtilDemo {
	
	@Test
	public void testIdCardUtil() throws Exception {
// 		String idcard = "7219106852486129911";
 		String idcard = "330106197610300011";
		boolean flag = IdCardUtilFactory.INSTANCE.check(idcard);
		Assert.assertEquals(true, flag);
	}

}
