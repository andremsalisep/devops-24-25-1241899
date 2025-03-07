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
    }

    @Test
    void shouldSuccessfullyCreateAnObjectEmployee() throws Exception {
        // arrange + act
        Employee employee = new Employee("Andre", "Salgado", "SWITCH Student", 1);

        //assert
        assertEquals("Andre", employee.getFirstName());
        assertEquals("Salgado", employee.getLastName());
        assertEquals("SWITCH Student", employee.getDescription());
        assertEquals(1, employee.getJobYears());
    }

    @Test
    void testEmployeeConstructorInvalidFirstName() {
        //arrenge + act + assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("", "Salgado", "SWITCH Student", 1));
        assertThrows(IllegalArgumentException.class, () -> new Employee(" ", "Salgado", "SWITCH Student", 1));
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, "Salgado", "SWITCH Student", 1));
    }

    @Test
    void testEmployeeConstructorInvalidLastName() {
        //arrenge + act + assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "", "SWITCH Student", 1));
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", " ", "SWITCH Student", 1));
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", null, "SWITCH Student", 1));
    }

    @Test
    void testEmployeeConstructorInvalidDescription() {
        //arrenge + act + assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", "", 1));
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", " ", 1));
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", null, 1));
    }

    @Test
    void testEmployeeConstructorInvalidJobYear() {
        //arrenge + act + assert
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", "SWITCH Student", -1));
        assertThrows(IllegalArgumentException.class, () -> new Employee("Andre", "Salgado", "SWITCH Student", -2));
    }

    @Test
    void testSetFirstNameValid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "SWITCH Student", 1);
        //act
        employee.setFirstName("Fulano");
        //assert
        assertEquals("Fulano", employee.getFirstName());
    }

    @Test
    void testSetFirstNameInvalid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "SWITCH Student", 1);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> employee.setFirstName(""));
    }

    @Test
    void testSetLastNameValid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "SWITCH Student", 1);
        //act
        employee.setLastName("Doce");
        //assert
        assertEquals("Doce", employee.getLastName());
    }

    @Test
    void testSetLastNameInvalid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "SWITCH Student", 1);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> employee.setLastName(""));
    }

    @Test
    void testSetDescriptionValid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "SWITCH Student", 1);
        //act
        employee.setDescription("Junior Developer");
        //assert
        assertEquals("Junior Developer", employee.getDescription());
    }

    @Test
    void testSetDescriptionInvalid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "SWITCH Student", 1);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> employee.setDescription(""));
    }

    @Test
    void testSetJobYearsValid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "SWITCH Student", 1);
        //act
        employee.setJobYears(10);
        //assert
        assertEquals(10, employee.getJobYears());
    }

    @Test
    void testSetJobYearsInvalid() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "SWITCH Student", 1);
        //act + assert
        assertThrows(IllegalArgumentException.class, () -> employee.setJobYears(-1));
    }

    @Test
    void testEqualsAndHashCodeWithIdenticalEmployees() {
        //arrenge
        Employee employee1 = new Employee("Andre", "Salgado", "SWITCH Student", 1);
        Employee employee2 = new Employee("Andre", "Salgado", "SWITCH Student", 1);
        //act + assert
        assertTrue(employee1.equals(employee2));
        assertEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void testEqualsAndHashCodeWithDifferentEmployees() {
        //arrenge
        Employee employee1 = new Employee("Andre", "Salgado", "SWITCH Student", 1);
        Employee employee2 = new Employee("Fulano", "Doce", "Junior Developer", 1);
        //act + assert
        assertFalse(employee1.equals(employee2));
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test
    void testToString() {
        //arrenge
        Employee employee = new Employee("Andre", "Salgado", "SWITCH Student", 1);
        //act
        String expectedString = "Employee{id=null, firstName='Andre', lastName='Salgado', description='SWITCH Student', jobYears='1'}";
        //assert
        assertEquals(expectedString, employee.toString());
    }

    @Test
    void testGetId() {
        //arrenge + act
        Employee employee = new Employee("Andre", "Salgado", "SWITCH Student", 1);

        //assert
        assertNull(employee.getId());
    }

    @Test
    void testSetId() {
        //arrenge
        Employee employee = new Employee("John", "Doe", "Developer", 5);
        Long newId = 123L;
        //act
        employee.setId(newId);
        //assert
        assertEquals(newId, employee.getId());
    }
}