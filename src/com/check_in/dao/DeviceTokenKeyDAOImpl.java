package com.check_in.dao;

import com.check_in.dto.DeviceTokenKeyDTO;
import com.check_in.dto.TokenKeyDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceTokenKeyDAOImpl {
    private static DeviceTokenKeyDAOImpl dtkDao;
    private MariaDBConnector mdbc = MariaDBConnector.getInstance();

    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;
    StringBuffer query;

    private DeviceTokenKeyDAOImpl() {}

    public static DeviceTokenKeyDAOImpl getInstance() {
        if(dtkDao == null) {
            dtkDao = new DeviceTokenKeyDAOImpl();
        }
        return dtkDao;
    }

    public DeviceTokenKeyDTO read(DeviceTokenKeyDTO dto) throws SQLException, ClassNotFoundException {
        int cnt = existToken(dto);  // 가져올 데이터 유무 확인

        if(cnt == 0)
            return null;

        con = mdbc.getConnection();
        query = new StringBuffer();
        query.append("SELECT * FROM DeviceTokenKey WHERE agentID = ?");

        pstmt = con.prepareStatement(query.toString());
        pstmt.setString(1, dto.getAgentID());

        rs = pstmt.executeQuery();
        DeviceTokenKeyDTO ret = new DeviceTokenKeyDTO();
        while(rs.next()) {
            ret.setAgentID(rs.getString("agentID"));
            ret.setToken(rs.getString("token"));
        }

        disconnect();
        return ret;
    }

    public synchronized int insert(DeviceTokenKeyDTO dto) throws SQLException, ClassNotFoundException {
        int cnt = existToken(dto);  // 기존 데이터와 키값 중복 여부 확인

        if(cnt != 0)
            return 0;

        con = mdbc.getConnection();
        query = new StringBuffer();
        query.append("INSERT INTO DeviceTokenKey VALUES(?, ?)");

        pstmt = con.prepareStatement(query.toString());
        pstmt.setString(1, dto.getAgentID());
        pstmt.setString(2, dto.getToken());

        pstmt.executeUpdate();
        disconnect();

        return 1;
    }

    public void delete(DeviceTokenKeyDTO dto) throws SQLException, ClassNotFoundException {
        con = mdbc.getConnection();
        query = new StringBuffer();
        query.append("DELETE FROM DeviceTokenKey WHERE agentID = ?");

        pstmt = con.prepareStatement(query.toString());
        pstmt.setString(1, dto.getAgentID());

        pstmt.executeUpdate();
        disconnect();
    }

    public boolean isKey(DeviceTokenKeyDTO dto) throws SQLException, ClassNotFoundException {
        int cnt = existToken(dto);  // 기존 데이터와 키값 중복 여부 확인

        if(cnt != 0)
            return true;
        else
            return false;
    }

    private int existToken (DeviceTokenKeyDTO dto) throws SQLException, ClassNotFoundException {
        con = mdbc.getConnection();
        query = new StringBuffer();
        query.append("SELECT COUNT(*) AS cnt FROM DeviceTokenKey WHERE agentID = ?");
        pstmt = con.prepareStatement(query.toString());
        pstmt.setString(1, dto.getAgentID());
        rs = pstmt.executeQuery();

        rs.next();
        int ret = rs.getInt("cnt");

        disconnect();
        return ret;
    }

    private void disconnect() throws SQLException {
        if(rs != null) {
            rs.close();
        }
        pstmt.close();
        con.close();
    }
}
