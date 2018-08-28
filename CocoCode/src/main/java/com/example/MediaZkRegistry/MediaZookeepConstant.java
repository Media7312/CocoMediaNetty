package com.example.MediaZkRegistry;

/**
 * @Author: houMedia
 * @Description:
 * @Date: Created in 14:35 2018/8/28
 */
public interface MediaZookeepConstant {
	int ZK_SESSION_TIMEOUT = 2400;
	String ZK_REGISTRY_PATH = "/registry";
	String ZK_DATA_PATH = ZK_REGISTRY_PATH + "/data";
}
