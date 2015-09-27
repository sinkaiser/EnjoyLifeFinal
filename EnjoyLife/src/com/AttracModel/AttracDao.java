package com.AttracModel;

import java.util.List;



public interface AttracDao {
	public abstract AttracBean select(int id);

	public abstract List<AttracBean> selectall();

	public abstract boolean insert(AttracBean bean);

	public abstract boolean update(AttracBean bean);

	public abstract boolean delete(int id);
	
	public abstract Integer selectAttracNo(AttracBean bean);
	
	public abstract Integer selectPK();
}
