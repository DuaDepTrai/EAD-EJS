package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "t_students")
public class SinhVien implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Lop lop;

    @OneToMany(mappedBy = "sinhVien")
    private List<Diem> diems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public List<Diem> getDiems() {
        return diems;
    }

    public void setDiems(List<Diem> diems) {
        this.diems = diems;
    }

    
}