package com.walking.lesson57_stream_collect_collector.task;

import com.walking.lesson57_stream_collect_collector.model.Department;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Предоставьте количество сотрудников старше 50 по каждому департаменту.
 */
public class Task12 implements StatisticTask<Map<String, Long>> {
    @Override
    public Map<String, Long> calculate(List<Department> departments) {
        return departments.stream()
                .collect(Collectors.toMap(
                        Department::getName,
                        d -> d.getEmployees().stream()
                            .filter(e -> e.getAge() > 50)
                            .count()
                ));
    }
}
