package ptit;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@Entity
public class loai_sp {
	@Id
	private String id;
	private String ten_loai;
	private String ghi_chu;
	private Date ngay_tao;
	public loai_sp(String id, String ten_loai, String ghi_chu, Date ngay_tao) {
		super();
		this.id = id;
		this.ten_loai = ten_loai;
		this.ghi_chu = ghi_chu;
		this.ngay_tao = ngay_tao;
	}
	
}

