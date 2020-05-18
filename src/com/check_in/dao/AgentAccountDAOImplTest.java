package com.check_in.dao;

import com.check_in.dto.AgentAccountDTO;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AgentAccountDAOImplTest {

    @org.junit.jupiter.api.Test
    void read() throws SQLException, ClassNotFoundException {
        AgentAccountDTO aaDto1 = new AgentAccountDTO("test@naver.com", "1234", "ahyun", 0, 0);
        AgentAccountDTO aaDto2 = new AgentAccountDTO("no@naver.com", "0000", "no", 0, 0);

        AgentAccountDAOImpl aaDao = AgentAccountDAOImpl.getInstance();
        assertEquals(aaDao.read(aaDto1).toString(), aaDto1.toString());
        assertSame(aaDao.read(aaDto2), null);
    }

    @org.junit.jupiter.api.Test
    void insert() throws SQLException, ClassNotFoundException {
        AgentAccountDTO aaDto = new AgentAccountDTO("dldkgusl@naver.com", "1234", "ahyun", 0, 0);

        AgentAccountDAOImpl aaDao = AgentAccountDAOImpl.getInstance();
        assertEquals(aaDao.insert(aaDto), 1);
        assertEquals(aaDao.insert(aaDto), 0);
        aaDao.delete(aaDto);
    }

    @org.junit.jupiter.api.Test
    void update() throws SQLException, ClassNotFoundException {
        AgentAccountDTO aaDto = new AgentAccountDTO("dldkgusl@naver.com", "1234", "ahyun", 0, 0);

        AgentAccountDAOImpl aaDao = AgentAccountDAOImpl.getInstance();
        aaDao.insert(aaDto);
        assertEquals(aaDao.update(aaDto), 0);
        aaDto.setAgentPW("hungry");
        assertEquals(aaDao.update(aaDto), 1);
        aaDao.delete(aaDto);
    }

    @org.junit.jupiter.api.Test
    void delete() throws SQLException, ClassNotFoundException {
        AgentAccountDTO aaDto = new AgentAccountDTO("dldkgusl@naver.com", "1234", "ahyun", 0, 0);

        AgentAccountDAOImpl aaDao = AgentAccountDAOImpl.getInstance();
        aaDao.insert(aaDto);
        assertNotEquals(aaDao.read(aaDto), null);
        aaDao.delete(aaDto);
        assertEquals(aaDao.read(aaDto), null);
    }

    @org.junit.jupiter.api.Test
    void isKey() throws SQLException, ClassNotFoundException {
        AgentAccountDTO aaDto1 = new AgentAccountDTO("test@naver.com", "1234", "ahyun", 0, 0);
        AgentAccountDTO aaDto2 = new AgentAccountDTO("no@naver.com", "0000", "no", 0, 0);

        AgentAccountDAOImpl aaDao = AgentAccountDAOImpl.getInstance();
        assertEquals(aaDao.isKey(aaDto1), true);
        assertEquals(aaDao.isKey(aaDto2), false);
    }
}