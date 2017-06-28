package com.primeton.storm.filters;

import org.apache.storm.trident.operation.BaseFilter;
import org.apache.storm.trident.tuple.TridentTuple;

public class BooleanFilter extends BaseFilter {

	private static final long serialVersionUID = -921857927751613039L;

	@Override
	public boolean isKeep(TridentTuple tuple) {
		return tuple.getBoolean(0);
	}

}
