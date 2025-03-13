package com.example.sof301202.buoi1.repository;

import com.example.sof301202.buoi1.model.ButXoa;
import com.example.sof301202.buoi1.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class ButXoaRepository {
    private Session session;

    public ButXoaRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<ButXoa> getAll() {
        return session.createQuery("FROM ButXoa").list();
    }

    public ButXoa getOne(Integer id) {
        return session.find(ButXoa.class, id);
    }

    public void add(ButXoa butXoa) {
        try {
            session.getTransaction().begin();
            session.save(butXoa);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(ButXoa butXoa) {
        try {
            session.getTransaction().begin();
            session.merge(butXoa);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getOne(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
