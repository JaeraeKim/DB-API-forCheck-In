package com.check_in.dao;

import com.check_in.dto.AgentConfigurationDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentConfigurationDAOImpl implements AgentConfigurationDAO {
    private static AgentConfigurationDAOImpl acDao;
    private MariaDBConnector mdbc = MariaDBConnector.getInstance();

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private StringBuffer query;

    private AgentConfigurationDAOImpl() {}

    public static AgentConfigurationDAOImpl getInstance() {
        if (acDao == null) {
            acDao = new AgentConfigurationDAOImpl();
        }
        return acDao;
    }

    public AgentConfigurationDTO read(AgentConfigurationDTO dto) throws SQLException, ClassNotFoundException {
        int cnt = existConfig(dto);  // 가져올 데이터 유무 확인

        if(cnt == 0)
            return null;

        con = mdbc.getConnection();
        query = new StringBuffer();
        query.append("SELECT * FROM AgentConfiguration WHERE agentID = ?");

        pstmt = con.prepareStatement(query.toString());
        pstmt.setString(1, dto.getAgentID());

        rs = pstmt.executeQuery();
        AgentConfigurationDTO ret = new AgentConfigurationDTO();
        while(rs.next()) {
            ret.setAgentID(rs.getString("agentID"));
            ret.setBrowserPreference(rs.getString("browserPreference"));
        }

        disconnect();
        return ret;
    }

    public synchronized int insert(AgentConfigurationDTO dto) throws SQLException, ClassNotFoundException {
        int cnt = existConfig(dto);  // 기존 데이터와 키값 중복 여부 확인

        if(cnt != 0)
            return 0;

        con = mdbc.getConnection();
        query = new StringBuffer();
        query.append("INSERT INTO AgentConfiguration VALUES(?, ?)");

        pstmt = con.prepareStatement(query.toString());
        pstmt.setString(1, dto.getAgentID());
        pstmt.setString(2, dto.getBrowserPreference());

        pstmt.executeUpdate();
        disconnect();

        return 1;
    }

    public synchronized int update(AgentConfigurationDTO dto) throws SQLException, ClassNotFoundException {
        int cnt = existConfig(dto);  // 변경할 데이터 존재 여부 확인

        if(cnt == 0)
            return 0;

        AgentConfigurationDTO origin = read(dto);  // 변경 사항 유무 확인
        if(origin.getBrowserPreference().equals(dto.getBrowserPreference())) {
            return 0;
        }

        con = mdbc.getConnection();
        query = new StringBuffer();
        query.append("UPDATE AgentConfiguration SET browserPreference = ? WHERE agentID = ?");

        pstmt = con.prepareStatement(query.toString());
        pstmt.setString(1, dto.getBrowserPreference());
        pstmt.setString(2, dto.getAgentID());

        pstmt.executeUpdate();
        disconnect();

        return 1;
    }

    private int existConfig(AgentConfigurationDTO dto) throws SQLException, ClassNotFoundException {
        con = mdbc.getConnection();
        query = new StringBuffer();
        query.append("SELECT COUNT(*) AS cnt FROM AgentConfiguration WHERE agentID = ?");
        pstmt = con.prepareStatement(query.toString());
        pstmt.setString(1, dto.getAgentID());
        rs = pstmt.executeQuery();

        rs.next();
        int ret = rs.getInt("cnt");

        disconnect();
        return ret;
    }

    public void delete(AgentConfigurationDTO dto) throws SQLException, ClassNotFoundException {
        con = mdbc.getConnection();
        query = new StringBuffer();
        query.append("DELETE FROM AgentConfiguration WHERE agentID = ?");

        pstmt = con.prepareStatement(query.toString());
        pstmt.setString(1, dto.getAgentID());

        pstmt.executeUpdate();
        disconnect();
    }

    public boolean isKey(AgentConfigurationDTO dto) throws SQLException, ClassNotFoundException {
        int cnt = existConfig(dto);  // 기존 데이터와 키값 중복 여부 확인

        if(cnt != 0)
            return true;
        else
            return false;
    }

    private void disconnect() throws SQLException {
        if(rs != null) {
            rs.close();
        }
        pstmt.close();
        con.close();
    }
}