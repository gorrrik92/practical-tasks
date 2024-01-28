package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Предоставьте список сотрудников по каждому имени.
 * Имена должны быть представлены в алфавитном порядке.
 */
public class Task11 implements StatisticTask<SortedMap<String, List<Employee>>> {
    @Override
    public SortedMap<String, List<Employee>> calculate(List<Department> departments) {
        return departments.stream()
                .flatMap(d -> d.getEmployees().stream())
                .sorted(Comparator.comparing(e -> e.getName()))
                .collect(Collectors.groupingBy(Employee::getName,
                        () -> new TreeMap<String, List<Employee>>(),
                        Collectors.toList()));
    }
}
