package com.plassertheurer.platform.u20231b475.monitoring.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plassertheurer.platform.u20231b475.monitoring.domain.model.aggregates.MaintenanceTask;

@Repository
public interface MaintenanceTaskRepository extends JpaRepository<MaintenanceTask, Long> {
}
