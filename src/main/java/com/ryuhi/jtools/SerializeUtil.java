package com.ryuhi.couplecard.util;

import java.io.ObjectStreamClass;

public class SerializeUtil {
	
	public static long getSerialVersonUid(Class<?> cls) {
		return ObjectStreamClass.lookup(cls).getSerialVersionUID();
	}
	
	public static void main(String[] args) {
		long svid = getSerialVersonUid(com.ryuhi.couplecard.user.entity.User.class);
		System.out.println(svid);
	}
}

