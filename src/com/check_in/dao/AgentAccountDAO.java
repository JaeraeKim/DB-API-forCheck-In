package com.check_in.dao;

import com.check_in.dto.AgentAccountDTO;

import java.sql.SQLException;

public interface AgentAccountDAO {
    public AgentAccountDTO read(AgentAccountDTO dto) throws SQLException, ClassNotFoundException;
    public int insert(AgentAccountDTO dto) throws SQLException, ClassNotFoundException;
    public int update(AgentAccountDTO dto) throws SQLException, ClassNotFoundException;
<<<<<<< HEAD
=======
    public int updatePW(AgentAccountDTO dto) throws SQLException, ClassNotFoundException;
>>>>>>> de9634e96ff6b1ec3722f60f63f2135d931f44fe
    public void delete(AgentAccountDTO dto) throws SQLException, ClassNotFoundException;
    public boolean isKey(AgentAccountDTO dto) throws SQLException, ClassNotFoundException;
}
