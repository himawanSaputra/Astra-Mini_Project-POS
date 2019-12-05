package com.ai.pos.dao;

import com.ai.pos.model.MstEmployee;
import com.ai.pos.model.MstRole;
import com.ai.pos.model.MstUser;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Repository
public class Employee_DaoImpl implements Employee_Dao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addEmployee(MstEmployee mstEmployee) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(mstEmployee);
        session.flush();
    }

    @Override
    public void updateEmployee(MstEmployee mstEmployee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(mstEmployee);
        session.flush();
    }

    @Override
    public void deleteEmployee(MstEmployee mstEmployee) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(mstEmployee);
        session.flush();
    }

    @Override
    public MstEmployee getEmployeeByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<MstEmployee> query = cb.createQuery(MstEmployee.class);
        Root<MstEmployee> root = query.from(MstEmployee.class);
        query.select(root)
                .where(cb.equal(root.get("email"), email));
        Query q = session.createQuery(query);
        List<MstEmployee> employee = q.getResultList();
        if(employee.isEmpty()){
            return null;
        }
        return (MstEmployee) q.getSingleResult();
    }

    @Override
    public MstEmployee findOne(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(MstEmployee.class, id);
    }

    @Override
    public List<MstEmployee> listMstEmployes() {
//        Session session = sessionFactory.getCurrentSession();
//        Criteria criteria = session.createCriteria(MstEmployee.class);
//        criteria.add(Restrictions.eq("active","1"));
//        return session.createCriteria(MstEmployee.class).list();

        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<MstEmployee> query = cb.createQuery(MstEmployee.class);
        Root<MstEmployee> root = query.from(MstEmployee.class);
        query.select(root);

        Query q = session.createQuery(query);
        return q.getResultList();

    }
}
