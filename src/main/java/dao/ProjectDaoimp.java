package dao;

import entity.Project;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoimp implements ProjectDao {
    public List<Project> findAll() {
        Connection con = null;
        CallableStatement callSt = null;
        List<Project> list = null;
        try {
            con = ConnectionDB.getConnection();
            callSt = con.prepareCall("{call find_all()}");
            ResultSet rs = callSt.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setImageUrl(rs.getString("image"));
                list.add(project);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return list;
    }

    @Override
    public boolean save(Project project) {
        Connection con = null;
        CallableStatement callSt = null;
        List<Project> list = null;
        Boolean result = false;
        try {
            con = ConnectionDB.getConnection();
            callSt = con.prepareCall("{call add_project(?,?,?)}");
            callSt.setString(1, project.getName());
            callSt.setString(2, project.getDescription());
            callSt.setString(3, project.getImageUrl());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return result;
    }

    @Override
    public Project findById(int id) {
        Connection con = null;
        CallableStatement callSt = null;
        Project project = null;
        try {
            con = ConnectionDB.getConnection();
            callSt = con.prepareCall("{call find_by_id(?) }");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setImageUrl(rs.getString("image"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(con, callSt);
        }
     return project;
    }

    @Override
    public boolean update(Project project) {
        Connection con = null;
        CallableStatement callSt = null;
        Boolean result = false;
        try {
            con = ConnectionDB.getConnection();
            callSt = con.prepareCall("{call update_project(?,?,?,?)}");
            callSt.setInt(1, project.getId());
            callSt.setString(2, project.getName());
            callSt.setString(3, project.getDescription());
            callSt.setString(4, project.getImageUrl());
            callSt.executeUpdate();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(con, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        Connection con = null;
        CallableStatement callSt = null;
        Boolean result = false;
        try {
            con = ConnectionDB.getConnection();
            callSt = con.prepareCall("{call delete_project(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(con, callSt);
        }
    return  result;
    }
}
