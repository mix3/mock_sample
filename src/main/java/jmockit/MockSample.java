package jmockit;

public class MockSample {
	private ServiceImpl serviceImpl;
	
	public MockSample(){
		this.serviceImpl = new ServiceImpl();
	}
	
	public String execute(){
		return serviceImpl.get();
	}
}
