package service;

import java.util.List;

import utils.SearchInfo;

public interface BasicService<T> {
	public List<T> selectAll(SearchInfo info);

	public T selectById(int id);

	public void insert(T u);

	public void delete(int id);

	public void update(T u);

}
