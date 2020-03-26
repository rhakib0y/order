package com.order.access.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PageParam {

	@Valid
	@NotNull
	private Integer page;

	@Valid
	@NotNull
	private Integer limit;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}
