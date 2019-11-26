package com.ai.pos.dao;

import com.ai.pos.model.MstEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class Employee_DaoImpl implements Employee_Dao {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

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
    public List<MstEmployee> listMstEmployee() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(MstEmployee.class).list();
    }
}
