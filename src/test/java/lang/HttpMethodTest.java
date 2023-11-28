package lang;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

/**
 * spring HttpMethod 테스트 유닛
 * 
 * @since 2019-12-12
 * @author noritersand
 */
public class HttpMethodTest {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(HttpMethodTest.class);

	@Test
	public void getStringValue() {
		Assert.assertEquals("POST", HttpMethod.POST.name());
		Assert.assertEquals("POST", HttpMethod.POST.toString());
	}
	
	@Test
	public void compare() {
		Assert.assertEquals(HttpMethod.PUT, HttpMethod.resolve("PUT")); // 문자열을 변환
		Assert.assertEquals(null, HttpMethod.resolve("put")); // 소문자는 안됨
		Assert.assertTrue(HttpMethod.HEAD.matches("HEAD")); // 문자열과 비교
		Assert.assertFalse(HttpMethod.HEAD.matches("head")); // 소문자는 안됨
	}
}
