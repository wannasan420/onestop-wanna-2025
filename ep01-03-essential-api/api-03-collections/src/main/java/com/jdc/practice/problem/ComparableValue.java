package com.jdc.practice.problem;

public record ComparableValue(int data, String name) implements Comparable<ComparableValue> {

	@Override
	public int compareTo(ComparableValue other) {
		
		var result = data - other.data;
		if(result == 0) {
			if(null == name && null == other.name) {
				return 0;
			}
			
			if(null != name && null == other.name) {
				return 1;
			}
			
			if(null == name && null != other.name) {
				return -1;
			}
			return name.compareTo(other.name);
		}
		return result;
	}

}
