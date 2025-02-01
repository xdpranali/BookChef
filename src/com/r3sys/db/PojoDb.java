package com.r3sys.db;

public class PojoDb 
{
     public static int uid;
     public static int cid;

	public static int getCid() {
		return cid;
	}

	public static void setCid(int cid) {
		PojoDb.cid = cid;
	}

	public static int getUid() {
		return uid;
	}

	public static void setUid(int uid) {
		PojoDb.uid = uid;
	}	
}
