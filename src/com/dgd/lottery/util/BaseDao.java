package com.dgd.lottery.util;

import java.sql.SQLException;
import java.util.List;


import org.hibernate.HibernateException;

/**
 * 基础Dao接口
 * @author liushan
 * @version	2016-07-06
 * @param <T>	类名称
 */

public interface BaseDao<T> {

	/**
	 * 添加一个记录
	 * @param obj				操作对象
	 * @throws SQLException	异常信息
	 */
	void add(T obj) throws SQLException;
	
	/**
	 * 根据ID删除一条记录
	 * @param id					ID参数
	 * @throws HibernateException	异常信息
	 */
	void delete(Long id) throws SQLException;
	
	/**
	 * 根据id删除多条记录
	 * @param ids				删除记录对应的ID数组参数	
	 * @throws SQLException	异常信息
	 */
//	void delete(Long[] ids) throws Exception;
	
	/**
	 * 修改一条信息
	 * @param obj
	 * @throws SQLException
	 */
	void update(T obj) throws SQLException;
	
	/**
	 * 查询所有记录
	 * @return					返回对象集合
	 * @throws SQLException	异常信息
	 */
	List<T> findAll() throws SQLException;
	
	/**
	 * 根据hql查询记录
	 * @param hql				查询hql语句
	 * @return					符合条件的记录
	 * @throws SQLException	异常信息
	 */
	List<T> findByHql(String hql) throws SQLException;
	
	/**
	 * 根据ID查询一条记录
	 * @param id				参数ID
	 * @return					ID对应的对象
	 * @throws SQLException	异常信息
	 */
	T findById(Long id) throws SQLException;
	
	/**
	 * 查询记录总数
	 * @return					总记录数
	 * @throws SQLException	异常信息
	 */
	Long findCount() throws SQLException;
	
	/**
	 * 根据hql查询记录总数
	 * @param hql				查询条件hql语句
	 * @return					符合条件的记录数
	 * @throws SQLException	异常信息
	 */
	Long findCountByHql(String hql) throws SQLException;
	
	/**
	 * 无条件的分页查询
	 * @param pageNum				页码
	 * @param pageSize				每页条数
	 * @return						分页对象	
	 * @throws HibernateException	异常信息
	 */
	Pagenation find4Page(Integer pageNum, Integer pageSize) throws SQLException;
	
	/**
	 * 根据HQL语句进行条件分页查询
	 * @param hql					hql查询语句				
	 * @param pageNum				页码
	 * @param pageSize				每页显示条数
	 * @return						分页对象
	 * @throws SQLException	异常信息
	 */
	Pagenation find4PageByHql(String hql, Integer pageNum, Integer pageSize) throws SQLException;
	
	void removeFromSession(T obj);
	
	/**
	 * 根据唯一约束条件和运维单位id查询 (在添加或修改时判断是否有同名时时用)
	 * @param uniqueName		唯一约束名称
	 * @param unitId			运维单位id
	 * @return
	 * @throws SQLException
	 */
	
	T findByUniqueAndUnitId(String uniqueName, String uniqueValue, Long unitId) throws SQLException;
	
}
