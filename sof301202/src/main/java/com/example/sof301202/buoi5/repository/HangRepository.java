package com.example.sof301202.buoi5.repository;

import com.example.sof301202.buoi5.model.Hang;
import com.example.sof301202.buoi5.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class HangRepository {
    Session session = null;

    public HangRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<Hang> getAll() {
        return session.createQuery("FROM Hang").list();
    }

    public Hang getDetail(Integer id) {
        return session.find(Hang.class, id);
    }
}
