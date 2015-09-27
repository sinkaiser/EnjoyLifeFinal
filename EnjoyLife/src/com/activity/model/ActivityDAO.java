package com.activity.model;

import java.util.List;

import org.json.simple.JSONArray;

public interface ActivityDAO {
	public abstract ActivityBean select(int activityNo);
	
	public abstract List<ActivityBean> select();
	
	public abstract ActivityBean insert(ActivityBean bean);
	
	public abstract ActivityBean update(ActivityBean bean);
	
	public abstract boolean delete(int activityid);

}
