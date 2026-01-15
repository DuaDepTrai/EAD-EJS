package service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.SinhVien;
import model.Lop;
import jakarta.ejb.LocalBean;
import java.util.List;

@Stateless
@LocalBean
public class SinhVienServiceBean {

    @PersistenceContext(unitName = "EADPU")
    private EntityManager em;

    public List<SinhVien> findAllSV() {
        return em.createQuery("SELECT s FROM SinhVien s", SinhVien.class).getResultList();
    }

    public List<Lop> findAllLop() {
        return em.createQuery("SELECT l FROM Lop l", Lop.class).getResultList();
    }

    public void addSinhVien(String name, int idLop) {
        Lop lop = em.find(Lop.class, idLop);
        SinhVien sv = new SinhVien();
        sv.setName(name);
        sv.setLop(lop);
        em.persist(sv);
    }
    
    public void updateSinhVien(int id, String name, int idLop) {
        SinhVien sv = em.find(SinhVien.class, id);
        if (sv != null) {
            Lop lop = em.find(Lop.class, idLop);
            sv.setName(name);
            sv.setLop(lop);
            em.merge(sv);
        }
    }

    public void deleteSinhVien(int id) {
        SinhVien sv = em.find(SinhVien.class, id);
        if (sv != null) {
            em.remove(sv);
        }
    }

    public SinhVien findSinhVienById(int id) {
        return em.find(SinhVien.class, id);
    }

    public void chuyenLop(int idSV, int idLop) {
        SinhVien sv = em.find(SinhVien.class, idSV);
        if (sv != null) {
            Lop lop = em.find(Lop.class, idLop);
            sv.setLop(lop);
            em.merge(sv);
        }
    }
}