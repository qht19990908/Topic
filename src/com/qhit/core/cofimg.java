package com.qhit.core;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class cofimg {

	private static Properties pro;

	static {
		InputStream is = null;
		is = cofimg.class.getClassLoader().getResourceAsStream("database.properties");
		if (is == null) {
			throw new RuntimeException("找不到数据库配置文件！");

		}
		pro = new Properties();
		try {
			pro.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static String proper(String key) {
		String value = pro.getProperty(key);
		return value;
	}

	}

