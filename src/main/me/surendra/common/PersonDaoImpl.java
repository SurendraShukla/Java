package me.surendra.common;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class PersonDaoImpl {
  public void test() {
    prepareData();
    
    List l = em.createQuery(
        "SELECT e, d  FROM Professor e LEFT JOIN e.department d")
        .getResultList();
    for (Object p : l) {
      printResult(p);
    }
  }

  private void prepareData() {
    Address address = new Address();
    address.setState("BC");
    
    Professor p = new Professor();
    p.setId(0);
    p.setName("TOM");
    p.setSalary(1111L);
    p.setAddress(address);

    Department d = new Department();
    d.setId(1);
    d.setName("Design");

    p.setDepartment(d);
    d.getProfessors().add(p);

    Phone phone = new Phone();
    phone.setId(1);
    phone.setNumber("111-111-1111");
    phone.setProfessor(p);
    
    em.persist(p);
    em.persist(phone);
    em.persist(address);
    em.persist(d);
  }

  private static void printResult(Object result) {
    if (result == null) {
      System.out.print("NULL");
    } else if (result instanceof Object[]) {
      Object[] row = (Object[]) result;
      System.out.print("[");
      for (int i = 0; i < row.length; i++) {
        printResult(row[i]);
      }
      System.out.print("]");
    } else if (result instanceof Long || result instanceof Double
        || result instanceof String) {
      System.out.print(result.getClass().getName() + ": " + result);
    } else {
      System.out.print(result);
    }
    System.out.println();
  }

  @PersistenceContext
  private EntityManager em;
}
