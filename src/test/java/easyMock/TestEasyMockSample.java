package easyMock;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.easymock.EasyMock.*;
import static org.testng.Assert.*;

public class TestEasyMockSample {
	private IService mock;
	private MockSample sample;
	
	@BeforeMethod
	public void setupMock() {
		mock = createMock(IService.class);
		sample = new MockSample(mock);
	}
	
	@Test public void callEcho(){
		mock.echo();
		
		replay(mock);
		sample.execute();
		verify(mock);
	}
	
	@Test public void callGet(){
		expect(mock.get()).andReturn("hoge");
		
		replay(mock);
		String str = sample.getName();
		assertEquals(str, "hoge");
	}
}
