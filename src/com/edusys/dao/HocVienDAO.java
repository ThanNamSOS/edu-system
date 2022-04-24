package com.edusys.dao;

import com.edusys.entity.HocVien;
import com.edusys.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

    public class HocVienDAO extends EduSysDAO<HocVien, Integer> {

    String INSERT_SQL = "INSERT INTO HocVien(MaKH, MaNH, Diem) VALUES(?,?,?)";
    String UPDATE_SQL = "UPDATE HocVien SET MaKH = ?, MaNH = ?, Diem = ? WHERE MaHV = ?";
    String DELETE_SQL = "DELETE FROM HocVien WHERE MaHV = ?";
    String SELECT_ALL_SQL = "SELECT * FROM HocVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM HocVien WHERE MaHV = ?";

    @Override
    public void insert(HocVien entity) {
        XJdbc.update(INSERT_SQL,
                entity.getMaKH(), entity.getMaNH(), entity.getDiem());
    }

    @Override
    public void update(HocVien entity) {
        XJdbc.update(UPDATE_SQL,
                entity.getMaKH(), entity.getMaNH(), entity.getDiem(), entity.getMaHV());
    }

    @Override
    public void delete(Integer id) {
        XJdbc.update(DELETE_SQL, id);
    }

    @Override
    public List<HocVien> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    public HocVien selectByID(Integer id) {
        List<HocVien> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<HocVien> selectBySQL(String sql, Object... args) {
        List<HocVien> list = new ArrayList<HocVien>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                HocVien hv = new HocVien();
                hv.setMaHV(rs.getInt(1));
                hv.setMaKH(rs.getInt(2));
                hv.setMaNH(rs.getString(3));
                hv.setDiem((Double) rs.getObject(4));
                list.add(hv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<HocVien> selectByKhoaHoc(int maKH){
        String sql = "SELECT * FROM HocVien WHERE MaKH = ?";
        return this.selectBySQL(sql, maKH);
    }
    
        public static void main(String[] args) {
            
        }
}
