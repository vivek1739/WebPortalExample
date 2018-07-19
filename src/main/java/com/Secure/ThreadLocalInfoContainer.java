package com.Secure;

import java.util.Map;

public class ThreadLocalInfoContainer {
	public static ThreadLocal<Map<String,Object>> INFO_CONTAINER=new ThreadLocal<Map<String,Object>>();
}
