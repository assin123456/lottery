package com.dgd.lottery.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDaoImpl<T> implements BaseDao<T> {

	// 定义sessionFactory并注入
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	// 获取session对象
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	/*
	 * 1 getCurrentSession创建的session会和绑定到当前线程,而openSession不会。 2
	 * getCurrentSession创建的线程会在事务回滚或事物提交后自动关闭,而openSession必须手动关闭 //获取session对象
	 * public Session getopenSession(){ return sessionFactory.openSession(); }
	 */

	protected Class<T> clazz;

	// 构造器获取泛型
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		// 获取带有泛型的父类
		Type type = this.getClass().getGenericSuperclass();

		// ParameterizedType参数化类型，即泛型
		ParameterizedType ptype = (ParameterizedType) type;
		// getActualTypeArguments获取参数化类型的数组，泛型可能有多个
		clazz = (Class<T>) ptype.getActualTypeArguments()[0];
	}

	@Override
	public void add(T obj) throws HibernateException {
		getCurrentSession().save(obj);
	}

	@Override
	public void delete(Long id) throws HibernateException {
		getCurrentSession().delete(getCurrentSession().get(clazz, id));
	}

	// @Override
	// public void delete(Long[] ids) throws HibernateException {
	// for(Long id : ids){
	// getCurrentSession().delete(this.findById(id));
	// }
	// }
	@Override
	public void update(T obj) throws HibernateException {
		// getCurrentSession().update(obj);
		getCurrentSession().merge(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() throws HibernateException {
		List<T> list = getCurrentSession().createQuery(" from " + clazz.getSimpleName()).list();
		if (list != null) {
			return list;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHql(String hql) throws HibernateException {
		return getCurrentSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Long id) throws HibernateException {
		return (T) getCurrentSession().get(clazz, id);
	}

	@Override
	public Long findCount() throws HibernateException {
		Long count = (Long) getCurrentSession().createQuery("select count(*) from " + clazz.getSimpleName())
				.uniqueResult();
		return count;
	}

	@Override
	public Long findCountByHql(String hql) throws HibernateException {
		Long count = (Long) getCurrentSession().createQuery("select count(*) " + hql).uniqueResult();
		return count;
	}

	@Override
	public Pagenation find4Page(Integer pageNum, Integer pageSize) throws HibernateException {
		return find4PageByHql(" from " + clazz.getSimpleName(), pageNum, pageSize);
	}

	@Override
	public Pagenation find4PageByHql(final String hql, Integer pageNum, Integer pageSize) throws HibernateException {
		String pageNumStr = String.valueOf(pageNum);
		final Pagenation page = new Pagenation(pageNumStr, findCountByHql(hql), pageSize);
		// 获取总数
		Long count = page.getTotalCount();
		if (count == null || count == 0) {
			return page;
		}
		// 查询语句
		Query query = getCurrentSession().createQuery(hql);
		// 下面两行代码相当于limit(n, m),第一个参数指定第一个返回记录行的偏移量，第二个参数指定返回记录行的最大数目。初始记录行的偏移量是
		// 0(而不是 1)
		query.setFirstResult(page.getStartRowNum() - 1);
		query.setMaxResults(page.getPageSize());
		// Query的list()方法时获取到查询后的结果集
		page.setList(query.list());
		return page;
	}

	@Override
	public void removeFromSession(T obj) {
		Session session = getCurrentSession();
		session.evict(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByUniqueAndUnitId(String uniqueName, String uniqueValue, Long unitId) throws SQLException {
		return (T) getCurrentSession().createQuery(" from " + clazz.getSimpleName() + " where unitid = :unitid and " + uniqueName + " = :uniquevalue" ).setLong("unitid", unitId).setString("uniquevalue",uniqueValue).uniqueResult();
	}

}
