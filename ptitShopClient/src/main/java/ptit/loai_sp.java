package ptit;


import java.util.Date;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor

public class loai_sp {
	
	private String id;
	private String ten_loai;
	private String ghi_chu;
	private Date ngay_tao;
}
