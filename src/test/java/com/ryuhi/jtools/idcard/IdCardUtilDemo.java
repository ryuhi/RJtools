package com.ryuhi.jtools.idcard;

import org.junit.Assert;
import org.junit.Test;

public class IdCardUtilDemo {
	
	@Test
	public void testIdCardUtil() throws Exception {
		String idcard = "7219106852486129911";
		boolean flag = IdCardUtil.getInstanceOf().check(idcard);
		Assert.assertTrue(flag);
	}

}
