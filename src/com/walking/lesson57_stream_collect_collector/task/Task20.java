package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;
import com.walking.lesson57_stream_collect_collector.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Предоставьте информацию по разнице в возрасте между самым молодым
 * и самым старым сотрудником по каждому департаменту.
 */
public class Task20 implements StatisticTask<Map<String, Integer>> {
    @Override
    public Map<String, Integer> calculate(List<Department> departments) {
        return departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        department -> {
                            TreeSet<Integer> ages = department.getEmployees().stream()
                                    .sorted(Comparator.comparing(Employee::getAge))
                                    .map(Employee::getAge)
                                    .collect(Collectors.toCollection(TreeSet::new));
                            return ages.isEmpty() ? 0 : ages.last() - ages.first();
                        }
                ));
    }
}
