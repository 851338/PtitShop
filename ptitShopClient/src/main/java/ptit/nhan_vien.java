package ptit;


import java.util.Date;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
public class nhan_vien {
	private String id;
	private String ten;
	private String sdt;
	private String email;
	private String dia_chi;
	private String vai_tro;
	private Date ngay_tao;
}
