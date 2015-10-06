package com.AttracModel;

import java.util.List;

public interface PhotoDao {
	public abstract List<PhotoBean> select(int id);
	public abstract List<PhotoBean> selectall();
	public abstract boolean insert(PhotoBean bean);
	public abstract boolean delete(int id);
	public abstract Integer selectPK();
	public List<PhotoBean> selectImgByAttracNo(String attracNo);
	public PhotoBean selectByNo(int photono);
	public String selectTop1ByAttrNo(int id);
}
