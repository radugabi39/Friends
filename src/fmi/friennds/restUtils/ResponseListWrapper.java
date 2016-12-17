package fmi.friennds.restUtils;

import java.util.List;


public class ResponseListWrapper<T> {

	private List<T> list;


	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
}
