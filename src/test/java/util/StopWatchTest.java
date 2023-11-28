package util;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

/**
 * org.springframework.util.StopWatch 테스트 슈트<br>
 * 아파치의 org.apache.commons.lang3.time.StopWatch가 더 좋으니 그걸 쓰자.<br>
 * 스프링꺼는 나노초가 안나옴.
 * 
 * @since 2017-07-27
 * @author fixalot
 */
public class StopWatchTest {
//	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(StopWatchTest.class);

	@Test
	public void test() {
		StopWatch watch = new StopWatch("IN SOVIET RUSSIA, MONITOR WATCHES YOU");

		watch.start("first");
		Assert.assertEquals("first", watch.currentTaskName());
		doUselessThing();
		watch.stop();

		watch.start("second");
		doUselessThing();
		watch.stop();

		watch.start("third");
		doUselessThing();
		watch.stop();

		logger.debug(watch.prettyPrint());

		Assert.assertEquals(3, watch.getTaskCount());
		Assert.assertEquals(3, watch.getTaskInfo().length);

		logger.debug(watch.shortSummary());

		Assert.assertEquals("IN SOVIET RUSSIA, MONITOR WATCHES YOU", watch.getId());

		TaskInfo info = watch.getLastTaskInfo();
		Assert.assertEquals("third", info.getTaskName());
		logger.debug("{}", info.getTimeMillis());
		logger.debug("{}", info.getTimeSeconds());
	}

	private long doUselessThing() {
		long sum = 0;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		return sum;
	}
}
