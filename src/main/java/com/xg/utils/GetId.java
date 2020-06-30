package com.xg.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;


public class GetId {
	public static String getIdDate(){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			StringBuffer sb = new StringBuffer(sdf.format(new Date()));
			sb.append(fillZero(3,String.valueOf(new Random().nextInt(1000))));
			return sb.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("生成随机Id失败");
		}
	}
	public static String getId(){
		UUID uuid = UUID.randomUUID();
		String ids = uuid.toString();
		String id = ids.replace("-","");
		return id;
	}
	/**
	 * @return
	 */
	private static String fillZero(int length, String source) {
		StringBuilder result = new StringBuilder(source);
		for(int i=result.length();i<length;i++){
			result.insert(0, '0');
		}
		return result.toString();
	}
}
