/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;



/**
 * @author Greg Turnquist
 */
// tag::code[]
@Entity // <1>
public class Employee {

	private @Id
	@GeneratedValue Long id; // <2>
	private String firstName;
	private String lastName;
	private String description;
	private String jobTitle;
	private int jobYears;
	private String email;

	protected Employee() {}

	public Employee(String firstName, String lastName, String description, String jobTitle, int jobYears, String email) {
		if (!isStringParameterValid(firstName) || !isStringParameterValid(lastName) || !isStringParameterValid(description) || !isStringParameterValid(jobTitle) || !isJobYearsValid(jobYears) || !isEmailValid(email)) {
			throw new IllegalArgumentException("Invalid parameters");
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.jobTitle = jobTitle;
		this.jobYears = jobYears;
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return Objects.equals(id, employee.id) &&
			Objects.equals(firstName, employee.firstName) &&
			Objects.equals(lastName, employee.lastName) &&
			Objects.equals(description, employee.description) &&
			Objects.equals(jobTitle, employee.jobTitle) &&
			Objects.equals(jobYears, employee.jobYears) &&
			Objects.equals(email, employee.email);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, firstName, lastName, description, jobTitle, jobYears, email);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (!isStringParameterValid(firstName)) {
			throw new IllegalArgumentException("Invalid parameters");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (!isStringParameterValid(lastName)) {
			throw new IllegalArgumentException("Invalid parameters");
		}
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (!isStringParameterValid(description)) {
			throw new IllegalArgumentException("Invalid parameters");
		}
		this.description = description;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		if (!isStringParameterValid(jobTitle)) {
			throw new IllegalArgumentException("Invalid parameters");
		}
		this.jobTitle = jobTitle;
	}

	public int getJobYears() {
		return jobYears;
	}

	public void setJobYears(int jobYears) {
		if (!isJobYearsValid(jobYears)) {
			throw new IllegalArgumentException("Invalid parameters");
		}
		this.jobYears = jobYears;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (!isStringParameterValid(email)) {
			throw new IllegalArgumentException("Invalid parameters");
		}
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", description='" + description + '\'' +
			", jobTitle='" + jobTitle + '\'' +
			", jobYears='" + jobYears + '\'' +
			", email='" + email + '\'' +
			'}';
	}
	private boolean isStringParameterValid(String x) {
        return x != null && !x.isBlank();
    }

	private boolean isJobYearsValid(int x) {
		return x >= 0;
    }

	private boolean isEmailValid(String email) {
		return isStringParameterValid(email) && email.contains("@");
	}
}
// end::code[]
