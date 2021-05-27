package ptit;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ptit.Data.LoaiSanPhamRep;
import ptit.Data.NhanVienRep;


@SpringBootTest
@Transactional
public class testDb {
	
	@Autowired
	private LoaiSanPhamRep lspRep;
	@Autowired
	private NhanVienRep nvRep;
	
	@Test
	public void testCreateKindProduct() {
		loai_sp lsp = new loai_sp("a1","a","a",new Timestamp(System.currentTimeMillis()));
		lspRep.save(lsp);
		assertNotNull(lsp);
	}
	@Test
	public void testListKindProduct() {
		List<loai_sp> lsps = (List<loai_sp>) lspRep.findAll();
		assertThat(lsps).size().isGreaterThan(0);
	}
	@Test
	@Rollback(true)
	public void testUpdateKindProduct() {
		String name = "Fan";
		loai_sp lsp = new loai_sp("a1",name,"a",new Timestamp(System.currentTimeMillis()));
		lspRep.save(lsp);
		Optional<loai_sp> updateLsp = lspRep.findById("a1");
		assertThat(updateLsp.get().getTen_loai()).isEqualTo(name);
		
	}
	@Test 
	@Rollback(true)
	public void TestDeleteKindProduct() {
		String temp = "a1";
		boolean exist = lspRep.findById(temp).isPresent();
		lspRep.deleteById(temp);
		boolean notExist = lspRep.findById(temp).isPresent();
		assertTrue(exist);
		assertFalse(notExist);
	}
	@Test
	public void TestCreateEmployee() {
		nhan_vien nv = new nhan_vien("Nguyen Van A","0987963251","nvanA@gmail.com","Ha Noi","manager",new Timestamp(System.currentTimeMillis()));
		nv.setId("14");
		nvRep.save(nv);	
		assertNotNull(nv);

	}
	@Test
	public void testListEmployees() {
		List<nhan_vien> nvs = (List<nhan_vien>) nvRep.findAll();
		assertThat(nvs).size().isGreaterThan(0);
	}
	@Test
	@Rollback(true)
	public void testUpdateEmployee() {
		String name = "NguyenVanB";
		nhan_vien nv = new nhan_vien(name,"0987963251","nvanA@gmail.com","HCM","manager",new Timestamp(System.currentTimeMillis()));
		nv.setId("6");
		nvRep.save(nv);
		Optional<nhan_vien> updateNv = nvRep.findById("6");
		System.out.print(updateNv);
		assertThat(updateNv.get().getTen()).isEqualTo(name);
		
	}
	@Test 
	@Rollback(true)
	public void TestDeleteEmployee() {
		String temp = "33";
		boolean exist = nvRep.findById(temp).isPresent();
		nvRep.deleteById(temp);
		boolean notExist = nvRep.findById(temp).isPresent();
		assertTrue(exist);
		assertFalse(notExist);
	}
	
}
