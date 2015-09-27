package com.AttracModel;

import java.util.List;

public interface DistDao {
	public abstract List<DistBean> select(int id);

	public abstract List<DistBean> selectall();
}
