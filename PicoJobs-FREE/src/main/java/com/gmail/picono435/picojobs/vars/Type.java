package com.gmail.picono435.picojobs.vars;

import java.util.Map;

import com.google.common.collect.Maps;

public enum Type {
	MINER(),
	KILL(),
	KILL_JOB(),
	FISHER();
	
	private final static Map<String,  Type> BY_NAME = Maps.newHashMap();
	
	public static Type getType(String name) {
		return BY_NAME.get(name);
	}
	
	static {
		for(Type type : values()) {
			BY_NAME.put(type.name(), type);
		}
	}
}
