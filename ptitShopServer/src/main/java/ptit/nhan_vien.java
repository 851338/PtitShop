package ptit;

import java.io.Serializable;
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
public class nhan_vien implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private String id;
	private String ten;
	private String sdt;
	private String email;
	private String dia_chi;
	private String vai_tro;
	private Date ngay_tao;
	public nhan_vien(String ten, String sdt, String email, String dia_chi, String vai_tro, Date ngay_tao) {
		super();
		this.ten = ten;
		this.sdt = sdt;
		this.email = email;
		this.dia_chi = dia_chi;
		this.vai_tro = vai_tro;
		this.ngay_tao = ngay_tao;
	}
}
