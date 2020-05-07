package com.check_in.dao;

import com.check_in.dto.AgentConfigurationDTO;

import java.sql.SQLException;

public interface AgentConfigurationDAO {

    public AgentConfigurationDTO read(AgentConfigurationDTO dto) throws SQLException, ClassNotFoundException;
    public int insert(AgentConfigurationDTO dto) throws SQLException, ClassNotFoundException;
    public int update(AgentConfigurationDTO dto) throws SQLException, ClassNotFoundException;
    public void delete(AgentConfigurationDTO dto) throws SQLException, ClassNotFoundException;
    public boolean isKey(AgentConfigurationDTO dto) throws SQLException, ClassNotFoundException;
}
