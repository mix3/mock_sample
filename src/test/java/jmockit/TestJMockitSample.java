package jmockit;

import mockit.Mockit;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TestJMockitSample {
	@Test public void jmockTest() {
		// クラスの差し替え
		Mockit.redefineMethods(ServiceImpl.class, new MockServiceImpl());
		MockSample sample = new MockSample();
		assertEquals(sample.execute(), "Mocked!!!");
	}
	
	private class MockServiceImpl implements IService{
		public String get() {
			return "Mocked!!!";
		}
	}
}
