package com.example.MediaZkRegistry;

import jdk.nashorn.internal.runtime.GlobalConstants;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: houMedia
 * @Description: Zookeeper服务注册
 * @Date: Created in 14:07 2018/8/28
 */
public class MediaZookeepRegistry {

	//CountDownLatch 实现多个线程开始执行任务的最大并行性（不是并发性）
	private CountDownLatch countDownLatch = new CountDownLatch(1);

	//Zookeeper服务器地址
	private static String zookeeperAddress = "140.143.15.124:2181";

	/**
	 * 服务注册
	 */
	public void registry(){
		String data ="140.143.15.124:2181";
		if (data != null){
			System.out.println("MediaZookeepRegistry is start");
			//创建zk实例
			ZooKeeper zk = connectZookeeper();
			if (zk != null){
				createNode(zk, data);
			}
		}
	}

	/** 连接Zookeeper*/
	private ZooKeeper connectZookeeper(){
		ZooKeeper zk = null;
		try {
			zk = new ZooKeeper(zookeeperAddress, MediaZookeepConstant.ZK_SESSION_TIMEOUT, new Watcher() {
				@Override
				public void process(WatchedEvent watchedEvent) {
					if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
						countDownLatch.countDown();
					}
				}
			});
			countDownLatch.await();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return zk;
	}

	/** 创建节点*/
	private void createNode(ZooKeeper zk,String data){
		try {
			System.out.println("createNode method");
			byte[] bytes = data.getBytes();

			String path = zk.create(MediaZookeepConstant.ZK_DATA_PATH,bytes, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
			System.out.println(path);
		} catch (KeeperException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
