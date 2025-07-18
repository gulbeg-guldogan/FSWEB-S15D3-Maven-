package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1,"gülbeg","Güldoğan"));
        employees.add(new Employee(1,"çetin","yavuz"));
        employees.add(new Employee(2,"dilara","gürbak"));
        employees.add(new Employee(3,"bora","erk"));
    }

    public static List<Employee> findDuplicates(List<Employee> liste){
        Map<Integer, Employee> employeeMap = new HashMap<>();
        List<Employee> newList = new LinkedList<>();
        Iterator<Employee> iterator = liste.iterator();

        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println("null record");
                continue;
            }
            if(employeeMap.containsKey(employee.getId())){
                newList.add(employee);
            } else{
                employeeMap.put(employee.getId(), employee);
            }
        }
        return newList;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> liste){
        Map<Integer, Employee> employeeMap = new HashMap<>();
        List<Employee> newList = new LinkedList<>();
        Iterator<Employee> iterator = liste.iterator();

        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null){
                System.out.println("null record");
                continue;
            }
            if(!employeeMap.containsKey(employee.getId())){
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> liste){
        List<Employee> duplicates = findDuplicates(liste);
        Map<Integer, Employee> uniques = findUniques(liste);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(duplicates);

        return onlyUnique;
    }
}