package com.check_in.dao;

import com.check_in.dto.AgentAccountLogDTO;

import java.sql.SQLException;
import java.util.List;

public interface AgentAccountLogDAO {
    public List<AgentAccountLogDTO> readAll(AgentAccountLogDTO dto) throws SQLException, ClassNotFoundException;
    public int insert(AgentAccountLogDTO dto) throws SQLException, ClassNotFoundException;
    public void delete(AgentAccountLogDTO dto) throws SQLException, ClassNotFoundException;
}
