/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package Service;

import Model.Employee;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author DUADEPTRAI
 */
@Stateless
@LocalBean
public class EmployeeService {

    @PersistenceContext
    private EntityManager em;
    
    public List<Employee> findAll(){
        return em.createQuery("Select a from Employee a")
                .getResultList();
    }
    
    public void addNew(Employee emp){
        em.persist(emp);
    }
    
    public void delete(Integer id){
        Employee emp = em.find(Employee.class, id);
        em.remove(emp);
    }
}
