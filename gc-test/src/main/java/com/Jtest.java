package com;
/**
 * 
 * 参数配置
-Xms20m
-Xmx20m
-XX:+PrintGCTimeStamps
-XX:+PrintGCDetails
-verbose:gc
-Xmn10M
-XX:SurvivorRatio=8
 */
public class Jtest {
	private static final int _1M = 1024*1024;
	public static void main(String[] args) {
		byte[] allocation1,allocation2,allocation3,allocation4;
//		allocation1 = new byte[_1M/4];
//		allocation2 = new byte[_1M/4];
//		allocation3 = new byte[4*_1M];
//		allocation4 = new byte[4*_1M];
//		allocation4 = null;
//		allocation4 = new byte[4*_1M];
//		
//		allocation1 = new byte[_1M/4];
//		allocation2 = new byte[_1M/4];
//		allocation3 = new byte[4*_1M];
//		allocation4 = new byte[4*_1M];
//		allocation4 = null;
//		allocation4 = new byte[4*_1M];
		while(true) {
			allocation4 = new byte[4*_1M];
			try{
				Thread.sleep(1000);
			}catch(Exception e) {
				
			}
		}
	}
}	