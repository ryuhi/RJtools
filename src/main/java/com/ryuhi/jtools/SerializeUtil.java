package com.ryuhi.jtools;

import java.io.ObjectStreamClass;

/**
 * 序列化工具
 * @author ryuhi<tobutatu@gmail.com>
 */
public class SerializeUtil {
	
	/**
	 * 计算生成一个SerialVersionUID，和使用IDE计算的相同效果
	 * @param cls 类的实例
	 * @return SerialVersionUID
	 */
	public static long getSerialVersonUid(Class<?> cls) {
		return ObjectStreamClass.lookup(cls).getSerialVersionUID();
	}
}

