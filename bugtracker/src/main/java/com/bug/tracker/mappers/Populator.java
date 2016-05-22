package com.bug.tracker.mappers;

import org.modelmapper.ModelMapper;

/** T1 is the source variable and T2 is the target variable */
public class Populator<T1,T2> {

	@SuppressWarnings("unchecked")
	public T2 convert(T1 source, T2 target){
		ModelMapper modelMapper = new ModelMapper();
		return	(T2) modelMapper.map(source, target.getClass());
	}
}
