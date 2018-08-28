package com.example.MediaStart;

import com.example.MediaZkRegistry.MediaZookeepRegistry;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: houMedia
 * @Description:
 * @Date: Created in 21:40 2018/8/28
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationStartingEvent>{
	@Override
	public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
		doSomething();
	}

	private void doSomething(){
		System.out.println("启动");
		MediaZookeepRegistry mediaZookeepRegistry = new MediaZookeepRegistry();
		mediaZookeepRegistry.registry();
	}
}
