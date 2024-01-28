package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Предоставьте самого старшего обладателя каждого из имен.
 * Попробуйте сделать это без использования downstream.
 */
public class Task5 implements StatisticTask<Map<String, Employee>> {
    @Override
    public Map<String, Employee> calculate(List<Department> departments) {
        return departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        d -> d.getEmployees().stream()
                                .max(Comparator.comparing(employee -> employee.getAge()))
                                .get()
                ));
    }
}
