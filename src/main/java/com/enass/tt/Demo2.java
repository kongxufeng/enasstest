package com.enass.tt;

import java.text.SimpleDateFormat;


public class Demo2 {
	public static void main(String[] args) {
		Long time = System.currentTimeMillis();// 获得系统当前时间的毫秒数

		System.out.println("获取当前系统时间为：" + new SimpleDateFormat("yyyy-MM-dd").format(time));// 转换成标准年月日的形式
		//Date date = new Date(time);

		time += 7 * 24 * 60 * 1000 * 60;// 在当前系统时间的基础上往后加30分钟

		System.out.println("三十分钟后的时间为：" + new SimpleDateFormat("yyyyMMddHHmmss").format(time));
	}
}
