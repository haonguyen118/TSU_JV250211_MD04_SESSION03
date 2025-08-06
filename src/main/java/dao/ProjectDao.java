package dao;

import entity.Project;

import java.util.List;

public interface ProjectDao {
    List<Project> findAll();

    boolean save(Project project);

    Project findById(int id);

    boolean update(Project project);

    boolean delete(int id);
}

