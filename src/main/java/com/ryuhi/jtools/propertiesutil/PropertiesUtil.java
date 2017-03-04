package com.ryuhi.jtools.propertiesutil;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public final class PropertiesUtil extends Properties {
	private static final long serialVersionUID = -401804861245600270L;
	private static PropertiesUtil instance = new PropertiesUtil();

	public static PropertiesUtil getInstance() {
		return instance;
	}

	private PropertiesUtil() {}
	
	/**
	 * 获取配置文件某键的值
	 * @param file 配置文件的文件名，从classpath开始写，以/开头
	 * @param key 键的名称
	 * @return
	 */
	public String getValues(String file, String key) {
		InputStream is = getClass().getResourceAsStream(file);
		try {
			instance.load(new InputStreamReader(is,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return instance.getProperty(key);
	}
}