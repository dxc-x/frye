package com.qhc.frye.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qhc.frye.entity.DMaterialGroups;

@Repository
public interface SapMaterialGroupsRepository extends JpaRepository<DMaterialGroups, String> {
	public List<DMaterialGroups> findByIsenableNotOrderByCode(int i);
}
