package ptit.Data;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import ptit.loai_sp;




public interface LoaiSanPhamRep extends CrudRepository<loai_sp, String>{
	@Transactional
	@Query(value = "Select * from loai_sp lsp where lsp.name like %?1%" 
			,nativeQuery=true)
	loai_sp findByName(String key);
}
