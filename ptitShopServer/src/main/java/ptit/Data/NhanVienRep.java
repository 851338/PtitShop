package ptit.Data;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import ptit.loai_sp;
import ptit.nhan_vien;


public interface NhanVienRep extends CrudRepository<nhan_vien, String>{
	@Transactional
	@Query(value = "Select * from nhan_vien nv where nv.ten like %?1%" 
			,nativeQuery=true)
	List<nhan_vien> NvByName(String key);

	
}


