package org.vote.dao;

import org.vote.utils.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Hql on 2016/12/28.
 * 公共的方法
 */
public class BaseDao<T> {
    //添加
    public boolean save(T t){
        //获取EntityManager对象
        EntityManager em = HibernateUtils.getEntityManager();
        //开启事务
        em.getTransaction().begin();
        boolean b = false;
        try {
            //执行保存操作
            em.persist(t);
            //提交事务
            em.getTransaction().commit();
            b = true;
        }catch (Exception e){
            e.printStackTrace();
            //事务回滚
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        return b;
    }

    //删除
    public void delete(T t){
        //获取EntityManager对象
        EntityManager em = HibernateUtils.getEntityManager();
        //开启事务
        em.getTransaction().begin();
        try {
            //执行删除
            //remove方法删除的实体必须在同一个EntityManager对象中
            em.remove(em.merge(t));
            //提交事务
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            //事务回滚
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    //修改
    public void update(T t){
        //获取EntityManager对象
        EntityManager em = HibernateUtils.getEntityManager();
        //开启事务
        em.getTransaction().begin();
        try {
            //合并操作
            em.merge(t);
            //提交事务
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            //事务回滚
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

    //依据id查询
    public  T finById(Class<T> EntityClass, Object id){
        //获取EntityManager对象
        EntityManager em = HibernateUtils.getEntityManager();
        //开启事务
        em.getTransaction().begin();
        T entity = null;
        try {
            //查询操作
            entity = em.find(EntityClass, id);
            //提交事务
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            //事务回滚
            em.getTransaction().rollback();
        }finally {
            em.close();
        }

        return entity;
    }

    //查出列表
    public List<T> finList(Class<T> EntityClass){
        //编写jpql语句
        String jpql = "from" + EntityClass.getName();
        //获取EntityManager对象
        EntityManager em = HibernateUtils.getEntityManager();
        //开启事务
        em.getTransaction().begin();
        List<T> list = null;
        try {
            //创建查询
            list = em.createQuery(jpql).getResultList();
            //提交事务
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            //事务回滚
            em.getTransaction().rollback();
        }finally {
            em.close();
        }

        return list;
    }


    //jpql条件查询单个实体
    public <T> T singleFind(Class<T> entityClass, String jpql, Object... condition) {
        //String jpql = "from Book b where b.id = ?1";
        EntityManager em = HibernateUtils.getEntityManager();
        em.getTransaction().begin();
        T obj = null;
        try {
            Query query = em.createQuery(jpql);
            for (int i = 1; i <= condition.length; i++) {
                query.setParameter(i, condition[i - 1]);//?号
            }
            obj = (T) query.getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return obj;
    }

    //jpql查询list集合
    public <T> List<T> allFind(Class<T> entityClass) {
        String jpql = "from " + entityClass.getName();
        EntityManager em = HibernateUtils.getEntityManager();
        em.getTransaction().begin();
        List<T> list = null;
        try {
            Query query = em.createQuery(jpql);
            list = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return list;
    }

    //jpql条件查询list集合
    public <T> List<T> allConditionFind(Class<T> entityClass, String jpql, Object... condition) {
        EntityManager em = HibernateUtils.getEntityManager();
        em.getTransaction().begin();
        List<T> list = null;
        try {
            Query query = em.createQuery(jpql);
            for (int i = 1; i <= condition.length; i++) {
                query.setParameter(i, condition[i - 1]);
            }
            list = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return list;
    }

    public static void main(String[] args) {
        /*List<Release> list = new BaseDao().allConditionFind(Release.class,"from Release b where b.releaseCategory = ?1 ","cbc504d7-c9ca-4ff5-9dd3-4eef7edfe1ce");
        for (Release r:list) {
            System.out.println("1231231:"+r.getId());
        }*/
    }
}
