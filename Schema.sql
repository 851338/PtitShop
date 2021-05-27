Use ptitshop;
Create table loai_sp(
	id varchar(255) primary key,
    ten_loai varchar(255),
    ghi_chu varchar(255),
    ngay_tao date
);
Create table nhan_vien(
	id int not null AUTO_INCREMENT,
    ten varchar(255),
    sdt varchar(255),
    email varchar(255),
    dia_chi varchar(255),
    vai_tro varchar(255),
    ngay_tao date,
    primary key (id)
    
)

