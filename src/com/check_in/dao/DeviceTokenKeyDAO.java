package com.check_in.dao;

import com.check_in.dto.DeviceTokenKeyDTO;

import java.sql.SQLException;

public interface DeviceTokenKeyDAO {
    public DeviceTokenKeyDTO read(DeviceTokenKeyDTO dto) throws SQLException, ClassNotFoundException;
    public int insert(DeviceTokenKeyDTO dto) throws SQLException, ClassNotFoundException;
    public void delete(DeviceTokenKeyDTO dto) throws SQLException, ClassNotFoundException;
    public boolean isKey(DeviceTokenKeyDTO dto) throws SQLException, ClassNotFoundException;
}
