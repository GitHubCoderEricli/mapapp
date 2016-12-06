package com.huashan.utils;

import java.util.List;

public class Result<T> {



	private Pager pager;

	private List<T> list ;

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Result(Pager pager, List<T> list) {
		this.pager = pager;
		this.list = list;
	}
	public Result(){
	}
}
