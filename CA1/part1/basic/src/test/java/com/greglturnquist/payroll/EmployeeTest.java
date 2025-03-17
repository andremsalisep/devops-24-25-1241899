package com.greglturnquist.payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testEmployeeConstructorNoArgs() {
        //arrenge
        Employee employee = new Employee();
        // act + assert
        assertNotNull(employee);
        assertNull(employee.getId());
        assertNull(employee.getFirstName());
        assertNull(employee.getLastName());
        assertNull(employee.getDescription());
        assertEquals(0, employee.getJobYears());
        assertNull(employee.getEmail());
    }

    @Test
    void shouldSuccessfullyCreateAnObjectEmployee() throws Exception {
        // arrange + act
        Employee employee = new Employee("Andre", "Salgado", "Graduated", "SWITCH Student", 1,"1241899@isep.ipp.pt");

        //assert
        assertEquals("Andre", employee.getFirstName());
        assertEquals("Salgado", employee.getLastName());
        assertEquals("Graduated", employee.getDescription());
        assertEquals("SWITCH Student", employee.getJobTitle());
        assertEquals(1, employee.getJobYears());
        assertEquals("1241899@isep.ipp.pt", employee.getEmail());
    }

    @Test
    void testEmployeeConstructorInvalidFirstName() {
        //arrenge + act + assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt"));
        assertThrows(IllegalArgumentException.class, () -> new Employee(" ", "Salgado", "Graduated", "SWITCH Student", 1,"1241899@isep.ipp.pt"));
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, "Salgado", "Graduated", "SWITCH Student", 1,"1241899@isep.ipp.pt"));
    }

    @Test
    void testEmployeeConstructorInvalidLastName() {
        //arrenge + act + assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "", "Graduated", "SWITCH Student", 1,"1241899@isep.ipp.pt"));
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", " ", "Graduated", "SWITCH Student", 1,"1241899@isep.ipp.pt"));
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", null, "Graduated", "SWITCH Student", 1,"1241899@isep.ipp.pt"));
    }

    @Test
    void testEmployeeConstructorInvalidDescription() {
        //arrenge + act + assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", "", "SWITCH Student",1,"1241899@isep.ipp.pt"));
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", " ", "SWITCH Student", 1,"1241899@isep.ipp.pt"));
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", null, "SWITCH Student", 1,"1241899@isep.ipp.pt"));
    }

    @Test
    void testEmployeeConstructorInvalidJobTitle() {
        //arrenge + act + assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", "Graduated", "",1,"1241899@isep.ipp.pt"));
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", "Graduated", " ", 1,"1241899@isep.ipp.pt"));
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", "Graduated", null, 1,"1241899@isep.ipp.pt"));
    }

    @Test
    void testEmployeeConstructorInvalidJobYear() {
        //arrenge + act + assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", "Graduated","SWITCH Student", -1,"1241899@isep.ipp.pt"));
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", "Graduated", "SWITCH Student", -2,"1241899@isep.ipp.pt"));
    }

    @Test
    void testEmployeeConstructorInvalidEmail() {
        //arrenge + act + assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,""));
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", "Graduated", "SWITCH Student", 1," "));
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", "Graduated", "SWITCH Student", 1,null));
    }

    @Test
    void testSetFirstNameValid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "Graduated", "SWITCH Student", 1,"1241899@isep.ipp.pt");
        //act
        employee.setFirstName("Fulano");
        //assert
        assertEquals("Fulano", employee.getFirstName());
    }

    @Test
    void testSetFirstNameInvalid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> employee.setFirstName(""));
    }

    @Test
    void testSetLastNameValid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");
        //act
        employee.setLastName("Doce");
        //assert
        assertEquals("Doce", employee.getLastName());
    }

    @Test
    void testSetLastNameInvalid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> employee.setLastName(""));
    }

    @Test
    void testSetDescriptionValid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");
        //act
        employee.setDescription("Junior Developer");
        //assert
        assertEquals("Junior Developer", employee.getDescription());
    }

    @Test
    void testSetJobTitleValid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");
        //act
        employee.setJobTitle("Junior Developer");
        //assert
        assertEquals("Junior Developer", employee.getJobTitle());
    }

    @Test
    void testSetJobTitleInvalid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> employee.setJobTitle(""));
    }

    @Test
    void testSetDescriptionInvalid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> employee.setDescription(""));
    }

    @Test
    void testSetJobYearsValid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");
        //act
        employee.setJobYears(10);
        //assert
        assertEquals(10, employee.getJobYears());
    }

    @Test
    void testSetJobYearsInvalid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> employee.setJobYears(-1));
    }



    @Test
    void testEqualsAndHashCodeWithIdenticalEmployees() {
        //arrenge
        Employee employee1 = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");
        Employee employee2 = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");
        //act + assert
        assertTrue(employee1.equals(employee2));
        assertEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void testEqualsAndHashCodeWithDifferentEmployees() {
        //arrenge
        Employee employee1 = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");
        Employee employee2 = new Employee("Fulano", "Doce", "Master","Junior Developer", 1,"1241899@isep.ipp.pt");
        //act + assert
        assertFalse(employee1.equals(employee2));
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void testToString() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");
        //act
        String expectedString = "Employee{id=null, firstName='Andre', lastName='Salgado', description='Graduated', jobTitle='SWITCH Student', jobYears='1', email='1241899@isep.ipp.pt'}";
        //assert
        assertEquals(expectedString, employee.toString());
    }

    @Test
    void testGetId() {
        //arrenge + act
        Employee employee = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");

        //assert
        assertNull(employee.getId());
    }

    @Test
    void testSetId() {
        //arrenge
        Employee employee = new Employee("John", "Doe", "NoDescription","Developer", 5,"1241899@isep.ipp.pt");
        Long newId = 123L;
        //act
        employee.setId(newId);
        //assert
        assertEquals(newId, employee.getId());
    }

    @Test
    void testSetEmailValid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "Graduated", "SWITCH Student", 1,"1241899@isep.ipp.pt");
        //act
        employee.setEmail("1234@isep.ipp.pt");
        //assert
        assertEquals("1234@isep.ipp.pt", employee.getEmail());
    }

    @Test
    void testSetEmailInvalid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "Graduated","SWITCH Student", 1,"1241899@isep.ipp.pt");
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> employee.setEmail(""));
    }
}