package com.situ.layoa.role.domain;

import java.io.Serializable;
import java.util.List;

public class RoleLayResult implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer code;// 结果状态 0：为成功
	private String msg;// 结果消息 ，如果不成功请书写原因
	private Integer count;//消息数
	private Object data;// 返回结果，可以实任意的数据类型

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public RoleLayResult(Integer code, String msg, Integer count, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	public RoleLayResult() {
		super();
	}

}
