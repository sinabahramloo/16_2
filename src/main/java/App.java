import Model.*;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import util.JPAUtil;

public class App {
    private static EmployeeDao employeeDao;
    private static PhoneNumberDao phoneNumberDao;
    private static AddressDao addressDao;
    private static final Integer CHECK_IMP_ID = 1;


    private static void deleteAllData(EntityManager entityManager) {

    }

    private static void initializeData() {
//        Employee employee1=createEmployee("sina",11111,100.11);
//        Address address1=createAddress("tehran","valiasr",111111);
//        Address address2=createAddress("esfahan","valiasr",222222);
        PhoneNumber phoneNumber1 = createPhoneNumber("0111111111", "01111111111");
        PhoneNumber phoneNumber2 = createPhoneNumber("0222222222", "02222222222");
        PhoneNumber phoneNumber3 = createPhoneNumber("0333333333", "03333333333");
        PhoneNumber phoneNumber4 = createPhoneNumber("0444444444", "04444444444");
        Address address1=createAddress("tehran","valiasr",111111);
        Address address2=createAddress("esfahan","valiasr",222222);
        Employee employee1=createEmployee("sina",11111,100.11);
        Employee employee2=createEmployee("sina2",11112,200.11);
//        Set<PhoneNumber> phoneNumbers1 = new HashSet<>();
//        Set<PhoneNumber> phoneNumbers2 = new HashSet<>();
        phoneNumber1.setAddress(address1);
        phoneNumber2.setAddress(address1);
        phoneNumber3.setAddress(address2);
        phoneNumber4.setAddress(address2);
        address1.setEmployee(employee1);
        address2.setEmployee(employee1);
//        phoneNumbers1.add(phoneNumber1);
//        phoneNumbers1.add(phoneNumber2);
//        phoneNumbers2.add(phoneNumber3);
//        phoneNumbers2.add(phoneNumber4);
//        Address address1=createAddress("tehran","valiasr",111111);
//        Address address2=createAddress("esfahan","valiasr",222222);
//        address1.setPhoneNumbers(phoneNumbers1);
//        address2.setPhoneNumbers(phoneNumbers2);
//        Set<Address> addresses=new HashSet<>();
//        addresses.add(address1);
//        addresses.add(address2);
//        employee1.setAddresses(addresses);
//        Employee employee1=createEmployee("sina",11111,100.11);
    }

    private static PhoneNumber createPhoneNumber(String telNumber, String mobNumber) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setMobNumber(mobNumber);
        phoneNumber.setTelNumber(telNumber);
        phoneNumberDao.save(phoneNumber);
        return phoneNumber;
    }

    private static Employee createEmployee(String name, Integer empCode, Double salary) {
        Employee employee = new Employee();
        employee.setEmpCode(empCode);
        employee.setName(name);
        employee.setSalary(salary);
        employeeDao.save(employee);
        return employee;
    }

    private static Address createAddress(String city, String postalAddress, Integer postalCode) {
        Address address = new Address();
        address.setCity(city);
        address.setPostalAddress(postalAddress);
        address.setPostalCode(postalCode);
        addressDao.save(address);
        return address;
    }


    private static void initializeDao(EntityManager entityManager) {
        employeeDao = new EmployeeDao(entityManager);
        addressDao = new AddressDao(entityManager);
        phoneNumberDao = new PhoneNumberDao(entityManager);
    }

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        initializeDao(entityManager);
        entityManager.getTransaction().begin();
        initializeData();
        entityManager.getTransaction().commit();
        Employee employee = employeeDao.load(CHECK_IMP_ID);
        PhoneNumber phoneNumber = phoneNumberDao.load(CHECK_IMP_ID);
        Address address = addressDao.load(CHECK_IMP_ID);

        System.out.println(employeeDao.loadByMostSalary().toString());
        System.out.println(employeeDao.MostSalary());
        System.out.println("before delete");
        System.out.println(employee.getName());
        System.out.println(address.getCity());
        System.out.println(phoneNumber.getMobNumber());
        entityManager.getTransaction().begin();
        addressDao.delete(address);
        entityManager.getTransaction().commit();
        System.out.println("after delete address id = 1");
        System.out.println(employee.getName());
        System.out.println(address.getCity());
        entityManager.getTransaction().begin();
        employeeDao.delete(employee);
        entityManager.getTransaction().commit();
        System.out.println("after delete employee id = 1");
        System.out.println(employee.getName());
        System.out.println(address.getCity());
        System.out.println();
        entityManager.close();
        JPAUtil.shutdown();

    }
}
