package com.order.access.mapper;

import java.util.Collections;
import java.util.List;

public interface BaseMapper<E, D> {

	boolean isEntityValid(E entity);
	
	boolean isDtoValid(D dto);
	
	E mapEntity(D dto);

	D mapDto(E entity);

	default List<E> mapEntityList(List<D> dto) {
		return Collections.emptyList();
	}

	default List<D> mapDtoList(List<E> entity) {
		return Collections.emptyList();
	}
}
