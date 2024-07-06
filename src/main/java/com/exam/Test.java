package com.exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	private static Validator validator;

	public static void main(String[] args) {
	    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();

        Person user = getUserInput();
        Set<ConstraintViolation<Person>> violations = validator.validate(user);

        if (violations.isEmpty()) {
            saveToDatabase(user);
            System.out.println("User data saved to database.");
        } else {
            System.out.println("Invalid user data found:");
            for (ConstraintViolation<Person> violation : violations) {
                System.out.println(violation.getMessage());
            }
        }
        Customer customer = getcustInput();
        Set<ConstraintViolation<Person>> violations1 = validator.validate(user);

        if (violations1.isEmpty()) {
            saveToDatabase1(customer);
            System.out.println("User data saved to database.");
        } else {
            System.out.println("Invalid user data found:");
            for (ConstraintViolation<Person> violation : violations1) {
                System.out.println(violation.getMessage());
            }
        }
        Employee employee = getempInput();
        Set<ConstraintViolation<Person>> violations11 = validator.validate(user);

        if (violations11.isEmpty()) {
            saveToDatabase2(employee);
            System.out.println("User data saved to database.");
        } else {
            System.out.println("Invalid user data found:");
            for (ConstraintViolation<Person> violation : violations11) {
                System.out.println(violation.getMessage());
            }}
        }
        
        private static Person getUserInput() {
        	Scanner sc = new Scanner(System.in);
        	
      
			System.out.print("Name : ");
			String name = sc.nextLine();
			
			System.out.print("Address : ");
			String address = sc.nextLine();
			return new Person( name, address);
        }private static Customer getcustInput() {
        	Scanner sc = new Scanner(System.in);
			
			System.out.print("Customer name : ");
			String Cname = sc.nextLine();
			
			System.out.print("customer's Address : ");
			String Caddress = sc.nextLine();
			
			System.out.print("Email : ");
			String email = sc.nextLine();
			
			System.out.print("Mobile no : ");
			String mobile = sc.nextLine();
			
			
			System.out.print("Customer Type : ");
			String customertype = sc.nextLine();
			
			return new Customer( email, Cname, Caddress, mobile, customertype);
        }
        private static Employee getempInput() {
        
        Scanner sc = new Scanner(System.in);
			
			System.out.print("Employee Name : ");
			String Ename = sc.nextLine();
			
			System.out.print("Emplyee Address : ");
			String Eaddress = sc.nextLine();
			
			System.out.print("Salary of Employee : ");
			float salary = sc.nextFloat();
			sc.nextLine();
			
			System.out.print("Employee's Destination : ");
			String destination = sc.nextLine();
			
			System.out.print("Date(yyyy-mm-dd) : ");
			String date = sc.nextLine();
			Date date1 = parseDate(date);
			return new Employee(Ename,Eaddress,salary,destination,date1);
        }
		
        private static void saveToDatabase(Person user) {
            Session session = HBUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.merge(user); 
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
        private static Date parseDate(String date) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(date);
            } catch (ParseException e) {
                throw new RuntimeException("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
        private static void saveToDatabase1(Customer cust) {
            Session session = HBUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.merge(cust); 
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
        private static void saveToDatabase2( Employee emp) {
            Session session = HBUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                session.merge(emp); 
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
}