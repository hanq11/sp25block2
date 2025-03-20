package com.example.sof301202.buoi5.repository;

import com.example.sof301202.buoi5.model.DieuHoa;
import com.example.sof301202.buoi5.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class DieuHoaRepository {
    Session session = null;

    public DieuHoaRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<DieuHoa> getAll() {
        return session.createQuery("FROM DieuHoa").list();
    }

    public DieuHoa getDetail(Integer id) {
        return session.find(DieuHoa.class, id);
    }

    public void themDieuHoa(DieuHoa dieuHoa) {
        try {
            session.getTransaction().begin();
            session.save(dieuHoa);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void suaDieuHoa(DieuHoa dieuHoa) {
        try {
            session.getTransaction().begin();
            session.merge(dieuHoa);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void xoaDieuHoa(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getDetail(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
