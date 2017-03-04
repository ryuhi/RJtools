package com.ryuhi.jtools.propertiesutil;

import org.junit.Assert;
import org.junit.Test;



public class PropertiesUtilDemo {

	@Test
	public void testPropertiesUtil() {
		String url = PropertiesUtil.getInstance().getValues("/dev/config.properties", "database.postgre.url");
		System.out.println(url);
		Assert.assertNotNull(url);
	}
}
