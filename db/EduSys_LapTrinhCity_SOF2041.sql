CREATE DATABASE SOF2041
GO

USE SOF2041
GO

CREATE TABLE NhanVien(
	MaNV NVARCHAR(20) NOT NULL,
	MatKhau NVARCHAR(50) NOT NULL,
	HoTen NVARCHAR(50) NOT NULL,
	VaiTro BIT DEFAULT 0, -- 0 là nhân viên, 1 là trưởng phòng
	PRIMARY KEY (MaNV)
)

INSERT INTO NhanVien VALUES(N'TeoNV',N'123456',N'Nguyễn Văn Tèo',1)
INSERT INTO NhanVien VALUES(N'NoPT',N'123456',N'Phạm Thị Nở',0)
INSERT INTO NhanVien VALUES(N'PheoNC',N'123456',N'Nguyễn Chí Phèo',0)
GO

CREATE TABLE ChuyenDe(
	MaCD NCHAR(5) NOT NULL,
	TenCD NVARCHAR(50) NOT NULL,
	HocPhi FLOAT NOT NULL,
	ThoiLuong INT NOT NULL,
	Hinh NVARCHAR(50) NOT NULL,
	MoTa NVARCHAR(255) NOT NULL,
	PRIMARY KEY (MaCD)
)

 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'JAV01', N'Lập trình Java cơ bản', 300, 90, N'GAME.png', N'JAV01 - Lập trình Java cơ bản')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'JAV02', N'Lập trình Java nâng cao', 300, 90, N'HTCS.jpg', N'JAV02 - Lập trình Java nâng cao')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'JAV03', N'Lập trình mạng với Java', 200, 70, N'INMA.jpg', N'JAV03 - Lập trình mạng với Java')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'JAV04', N'Lập trình desktop với Swing', 200, 70, N'LAYO.jpg', N'JAV04 - Lập trình desktop với Swing')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'PRO01', N'Dự án với công nghệ MS.NET MVC', 300, 90, N'MOWE.png', N'PRO01 - Dự án với công nghệ MS.NET MVC')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'PRO02', N'Dự án với công nghệ Spring MVC', 300, 90, N'Subject.png', N'PRO02 - Dự án với công nghệ Spring MVC')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'PRO03', N'Dự án với công nghệ Servlet/JSP', 300, 90, N'GAME.png', N'PRO03 - Dự án với công nghệ Servlet/JSP')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'PRO04', N'Dự án với AngularJS & WebAPI', 300, 90, N'HTCS.jpg', N'PRO04 - Dự án với AngularJS & WebAPI')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'PRO05', N'Dự án với Swing & JDBC', 300, 90, N'INMA.jpg', N'PRO05 - Dự án với Swing & JDBC')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'PRO06', N'Dự án với WindowForm', 300, 90, N'LAYO.jpg', N'PRO06 - Dự án với WindowForm')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'RDB01', N'Cơ sở dữ liệu SQL Server', 100, 50, N'MOWE.png', N'RDB01 - Cơ sở dữ liệu SQL Server')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'RDB02', N'Lập trình JDBC', 150, 60, N'Subject.png', N'RDB02 - Lập trình JDBC')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'RDB03', N'Lập trình cơ sở dữ liệu Hibernate', 250, 80, N'GAME.png', N'RDB03 - Lập trình cơ sở dữ liệu Hibernate')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'SER01', N'Lập trình web với Servlet/JSP', 350, 100, N'HTCS.jpg', N'SER01 - Lập trình web với Servlet/JSP')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'SER02', N'Lập trình Spring MVC', 400, 110, N'INMA.jpg', N'SER02 - Lập trình Spring MVC')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'SER03', N'Lập trình MS.NET MVC', 400, 110, N'LAYO.jpg', N'SER03 - Lập trình MS.NET MVC')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'SER04', N'Xây dựng Web API với Spring MVC & ASP.NET MVC', 200, 70, N'MOWE.png', N'SER04 - Xây dựng Web API với Spring MVC & ASP.NET MVC')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'WEB01', N'Thiết kế web với HTML và CSS', 200, 70, N'Subject.png', N'WEB01 - Thiết kế web với HTML và CSS')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'WEB02', N'Thiết kế web với Bootstrap', 0, 40, N'GAME.png', N'WEB02 - Thiết kế web với Bootstrap')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'WEB03', N'Lập trình front-end với JavaScript và jQuery', 150, 60, N'HTCS.jpg', N'WEB03 - Lập trình front-end với JavaScript và jQuery')
 INSERT INTO CHUYENDE(MACD,TENCD,HOCPHI,THOILUONG,HINH,MOTA) VALUES (N'WEB04', N'Lập trình AngularJS', 250, 80, N'INMA.jpg', N'WEB04 - Lập trình AngularJS')
GO

CREATE TABLE KhoaHoc(
	MaKH INT IDENTITY(1,1) NOT NULL,
	MaCD NCHAR(5) NOT NULL,
	HocPhi FLOAT NOT NULL,
	ThoiLuong INT NOT NULL,
	NgayKG DATE NOT NULL,
	GhiChu NVARCHAR(50) NULL,
	MaNV NVARCHAR(20) NOT NULL,
	NgayTao DATE NOT NULL,
	PRIMARY KEY (MaKH),
	FOREIGN KEY (MaCD) REFERENCES ChuyenDe(MaCD) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
)

 INSERT INTO KHOAHOC VALUES (N'PRO02',300,90,'12/10/2019',N'',N'TeoNV',GETDATE())
 INSERT INTO KHOAHOC VALUES (N'PRO03',300,90,'12/10/2019',N'',N'TeoNV',GETDATE())
 INSERT INTO KHOAHOC VALUES (N'RDB01',100,50,'12/10/2019',N'',N'TeoNV',GETDATE())
 INSERT INTO KHOAHOC VALUES (N'JAV01',250,80,'12/10/2019',N'',N'TeoNV',GETDATE())
 INSERT INTO KHOAHOC VALUES (N'JAV02',700,90,'12/10/2019',N'',N'TeoNV',GETDATE())
 INSERT INTO KHOAHOC VALUES (N'JAV03',200,80,'12/10/2019',N'',N'TeoNV',GETDATE())
 INSERT INTO KHOAHOC VALUES (N'WEB01',700,50,'12/10/2019',N'',N'TeoNV',GETDATE())
 INSERT INTO KHOAHOC VALUES (N'WEB02',600,50,'12/10/2019',N'',N'TeoNV',GETDATE())
GO

CREATE TABLE NguoiHoc(
	MaNH NCHAR(7) NOT NULL,
	HoTen NVARCHAR(50) NOT NULL,
	GioiTinh BIT DEFAULT 1, -- 0 là nữ, 1 là nam
	NgaySinh DATE NOT NULL,
	DienThoai NVARCHAR(24) NOT NULL,
	Email NVARCHAR(50) NOT NULL,
	GhiChu NVARCHAR(255) NULL,
	MaNV NVARCHAR(20) NOT NULL,
	NgayDK DATE DEFAULT getdate(),
	PRIMARY KEY (MaNH),
	FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON DELETE NO ACTION ON UPDATE CASCADE
)

INSERT INTO NGUOIHOC VALUES ('PS06357', N'LỮ HUY CƯỜNG', 1, '01/02/2000', N'0928768265', N'PS01638@gmail.com', N'0928768265 - LỮ HUY CƯỜNG', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS06737', N'ĐỖ VĂN MINH', 1, '02/03/2000', N'0968095685', N'PS02037@gmail.com', N'0968095685 - ĐỖ VĂN MINH', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS07916', N'NGUYỄN TẤN HIẾU', 1, '03/04/2000', N'0927594734', N'PS02771@gmail.com', N'0927594734 - NGUYỄN TẤN HIẾU', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS07961', N'NGUYỄN HỮU TRÍ', 1, '01/05/2000', N'0946984711', N'PS02867@gmail.com', N'0946984711 - NGUYỄN HỮU TRÍ', N'TeoNV', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08359', N'TRẦN VĂN NAM', 1, '01/06/2000', N'0924774498', N'PS02930@gmail.com', N'0924774498 - TRẦN VĂN NAM', N'TeoNV', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08379', N'ĐOÀN TRẦN NHẬT VŨ', 1, '01/07/2000', N'0912374818', N'PS02979@gmail.com', N'0912374818 - ĐOÀN TRẦN NHẬT VŨ', N'TeoNV', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08389', N'NGUYỄN HOÀNG THIÊN PHƯỚC', 1, '01/12/2000', N'0912499836', N'PS02983@gmail.com', N'0912499836 - NGUYỄN HOÀNG THIÊN PHƯỚC', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08393', N'HỒ HỮU HẬU', 0, '09/10/2000', N'0924984876', N'PS02988@gmail.com', N'0924984876 - HỒ HỮU HẬU', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08425', N'PHAN TẤN VIỆT', 1, '01/09/2000', N'0924832716', N'PS03031@gmail.com', N'0924832716 - PHAN TẤN VIỆT', N'PheoNC',GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08459', N'NGUYỄN CAO PHƯỚC', 1, '01/10/2000', N'0977117727', N'PS03046@gmail.com', N'0977117727 - NGUYỄN CAO PHƯỚC', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08461', N'HUỲNH THANH HUY', 0, '01/11/2000', N'0916436052', N'PS03080@gmail.com', N'0916436052 - HUỲNH THANH HUY', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08470', N'NGUYỄN HOÀNG TRUNG', 1, '02/02/1999', N'0938101529', N'PS03088@gmail.com', N'0938101529 - NGUYỄN HOÀNG TRUNG', N'PheoNC',GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08474', N'ĐOÀN HỮU KHANG', 1, '03/02/1999', N'0945196719', N'PS03096@gmail.com', N'0945196719 - ĐOÀN HỮU KHANG', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08483', N'LÊ THÀNH PHƯƠNG', 1, '04/02/1999', N'0922948096', N'PS03104@gmail.com', N'0922948096 - LÊ THÀNH PHƯƠNG', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08499', N'PHẠM NGỌC NHẬT TRƯỜNG', 1, '05/02/2000', N'0994296169', N'PS03120@gmail.com', N'0994296169 - PHẠM NGỌC NHẬT TRƯỜNG', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08507', N'ĐẶNG BẢO VIỆT', 1, '06/02/2000', N'0917749344', N'PS03130@gmail.com', N'0917749344 - ĐẶNG BẢO VIỆT', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08660', N'LÊ DUY BẢO', 1, '07/11/2001', N'0926714368', N'PS03134@gmail.com', N'0926714368 - LÊ DUY BẢO', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08522', N'NGUYỄN ANH TUẤN', 1, '08/12/2001', N'0920020472', N'PS03172@gmail.com', N'0920020472 - NGUYỄN ANH TUẤN', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08523', N'PHAN QUỐC QUI', 1, '09/13/2001', N'0930649274', N'PS03202@gmail.com', N'0930649274 - PHAN QUỐC QUI', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08525', N'ĐẶNG LÊ QUANG VINH', 1, '01/14/2002', N'0920197355', N'PS03203@gmail.com', N'0920197355 - ĐẶNG LÊ QUANG VINH', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08528', N'NGUYỄN MINH SANG', 1, '01/15/2002', N'0967006218', N'PS03205@gmail.com', N'0967006218 - NGUYỄN MINH SANG', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08530', N'TRẦM MINH MẪN', 1, '01/16/2002', N'0911183649', N'PS03222@gmail.com', N'0911183649 - TRẦM MINH MẪN', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08535', N'NGUYỄN PHẠM MINH HÂN', 1, '01/17/2002', N'0983469892', N'PS03230@gmail.com', N'0983469892 - NGUYỄN PHẠM MINH HÂN', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08595', N'LƯU KIM HOÀNG DUY', 1, '01/02/2002', N'0938357735', N'PS03233@gmail.com', N'0938357735 - LƯU KIM HOÀNG DUY', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08610', N'TRẦN QUANG VŨ', 1, '09/09/2000', N'0914531913', N'PS03251@gmail.com', N'0914531913 - TRẦN QUANG VŨ', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08611', N'BÙI NGỌC THUẬN', 1, '08/08/2000', N'0999794115', N'PS03304@gmail.com', N'0999794115 - BÙI NGỌC THUẬN', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08714', N'HỒ VĂN HÀNH', 1, '01/02/2000', N'0912277868', N'PS03306@gmail.com', N'0912277868 - HỒ VĂN HÀNH', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08719', N'TRẦN VIẾT HÙNG', 1, '02/08/2000', N'0916050164', N'PS03308@gmail.com', N'0916050164 - TRẦN VIẾT HÙNG', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08728', N'NGUYỄN HOÀNG MINH ĐỨC', 1,'12/08/2000', N'0912234437', N'PS03325@gmail.com', N'0912234437 - NGUYỄN HOÀNG MINH ĐỨC', N'PheoNC', GETDATE())
INSERT INTO NGUOIHOC VALUES ('PS08731', N'PHAN THANH PHONG', 1, '11/08/2000', N'0937891282', N'PS03346@gmail.com', N'0937891282 - PHAN THANH PHONG', N'PheoNC', GETDATE())
GO

CREATE TABLE HocVien(
	MaHV INT IDENTITY(1,1),
	MaKH INT NOT NULL,
	MaNH NCHAR(7) NOT NULL,
	Diem FLOAT DEFAULT -1,
	PRIMARY KEY (MaHV),
	FOREIGN KEY (MaKH) REFERENCES KhoaHoc(MaKH) ON DELETE NO ACTION ON UPDATE CASCADE,
	FOREIGN KEY (MaNH) REFERENCES NguoiHoc(MaNH) ON DELETE NO ACTION 
)

INSERT INTO HOCVIEN VALUES(1,'PS06357',6)
INSERT INTO HOCVIEN VALUES(2,'PS06737',3)
INSERT INTO HOCVIEN VALUES(3,'PS07916',3)
INSERT INTO HOCVIEN VALUES(4,'PS07961',2)
INSERT INTO HOCVIEN VALUES(5,'PS08359',1)
INSERT INTO HOCVIEN VALUES(8,'PS08379',null)
INSERT INTO HOCVIEN VALUES(8,'PS08389',10)
INSERT INTO HOCVIEN VALUES(8,'PS08393',5)
INSERT INTO HOCVIEN VALUES(2,'PS08425',6)
INSERT INTO HOCVIEN VALUES(3,'PS08459',null)
INSERT INTO HOCVIEN VALUES(4,'PS08461',null)
INSERT INTO HOCVIEN VALUES(5,'PS08470',3)
INSERT INTO HOCVIEN VALUES(6,'PS08474',3)
INSERT INTO HOCVIEN VALUES(7,'PS08483',7)
INSERT INTO HOCVIEN VALUES(8,'PS08499',9)
INSERT INTO HOCVIEN VALUES(2,'PS08507',8)
INSERT INTO HOCVIEN VALUES(6,'PS08660',9)
INSERT INTO HOCVIEN VALUES(5,'PS08522',10)
INSERT INTO HOCVIEN VALUES(2,'PS08523',10)
INSERT INTO HOCVIEN VALUES(1,'PS08525',9)
INSERT INTO HOCVIEN VALUES(3,'PS08528',8)
INSERT INTO HOCVIEN VALUES(1,'PS08530',7)
INSERT INTO HOCVIEN VALUES(7,'PS08535',6)
INSERT INTO HOCVIEN VALUES(7,'PS08595',3)
INSERT INTO HOCVIEN VALUES(8,'PS08610',1)
INSERT INTO HOCVIEN VALUES(6,'PS08611',4)
INSERT INTO HOCVIEN VALUES(1,'PS08714',7)
INSERT INTO HOCVIEN VALUES(2,'PS08719',4)
INSERT INTO HOCVIEN VALUES(2,'PS08728',3)
INSERT INTO HOCVIEN VALUES(3,'PS08731',6)
GO

-- Report : MANH - HOTEN - DIEM
CREATE PROC sp_BangDiem(@MaKH INT)
AS BEGIN
	SELECT 
		nh.MaNH,
		nh.HoTen,
		hv.Diem
	FROM HocVien hv
		JOIN NguoiHoc nh ON nh.MaNH=hv.MaNH
	WHERE hv.MaKH = @MaKH
	ORDER BY hv.Diem DESC
END
GO

-- Report : TEN_CĐ - SO_HV - THAP_NHAT - CAO_NHAT - TRUNG-BINH
CREATE PROC sp_ThongKeDiem
AS BEGIN
	SELECT
		TenCD ChuyenDe,
		COUNT(MaHV) SoHV,
		MIN(Diem) ThapNhat,
		MAX(Diem) CaoNhat,
		AVG(Diem) TrungBinh
	FROM KhoaHoc kh
		JOIN HocVien hv ON kh.MaKH = hv.MaKH
		JOIN ChuyenDe cd ON kh.MaCD = cd.MaCD
	GROUP BY TenCD
END
GO

-- Report : TEN_CĐ - SO_KH - SO_HV - DOANH_THU - THAP_NHAT - CAO_NHAT - TRUNG-BINH
CREATE PROC sp_ThongKeDoanhThu(@Year INT)
AS BEGIN
	SELECT 
		TenCD ChuyenDe,
		COUNT(DISTINCT kh.MaKH) SoKH,
		COUNT(hv.MaHV) SoHV,
		SUM(kh.HocPhi) DoanhThu,
		MIN(kh.HocPhi) ThapNhat,
		MAX(kh.HocPhi) CaoNhat,
		AVG(kh.HocPhi) TrungBinh
	FROM KhoaHoc kh
		JOIN HocVien hv ON kh.MaKH=hv.MaKH
		JOIN ChuyenDe cd ON cd.MaCD = kh.MaCD
	WHERE YEAR(NgayKG) = @Year
	GROUP BY TenCD
END
GO

-- Report : NAM - SO_LUONG - DAU_TIEN - CUOI_CUNG
CREATE PROC sp_ThongKeNguoiHoc
AS BEGIN
	SELECT 
		YEAR(NgayDK) Nam,
		COUNT(*) SoLuong,
		MIN(NgayDK) DauTien,
		MAX(NgayDK) CuoiCung
	FROM NguoiHoc
	GROUP BY YEAR(NgayDK) 
END
GO

select * from KhoaHoc
select * from HocVien where MaKH = '4'

