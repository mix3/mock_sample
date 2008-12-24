package jMock;

import jMock.IService;
import jMock.MockSample;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestJMockSample {
	private Mockery context;
	private MockSample sample;
	private IService service;
	
	@BeforeMethod
	public void setupMock(){
		context = new Mockery();
		service = context.mock(IService.class);
		sample = new MockSample(service);
	}
	
	@Test public void callEcho(){
		context.checking(new Expectations(){{
			oneOf (service).echo();
		}});
		sample.execute();
		context.assertIsSatisfied();
	}
	
	@Test public void callGet(){
		context.checking(new Expectations(){{
			oneOf (service).get();
			will(returnValue("hoge"));
		}});
		assertEquals(sample.getName(), "hoge");
		context.assertIsSatisfied();
	}
}
