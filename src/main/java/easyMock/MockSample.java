package easyMock;

public class MockSample {
	private IService service;
	
	public MockSample(IService service){
		this.service = service;
	}
	
	public void execute(){
		service.echo();
	}
	
	public String getName(){
		return service.get();
	}
}
