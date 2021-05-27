package ptit.api;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ptit.nhan_vien;
import ptit.Data.NhanVienRep;


@RestController
@RequestMapping(path = "/nv", produces = "application/json")
@CrossOrigin(origins = "*")
public class NhanVienController {
	private NhanVienRep nvRep;
	@Autowired
	EntityLinks entityLinks;
	
	public NhanVienController(NhanVienRep nvRep) {
		this.nvRep = nvRep;
	}

	@GetMapping
	public Iterable<nhan_vien> getLsp() {

		// PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
		return nvRep.findAll();
	}

	@GetMapping("/{id}")
	public nhan_vien nvById(@PathVariable("id") String id) {
		Optional<nhan_vien> optNv = nvRep.findById(id);
		if (optNv.isPresent()) {
			return optNv.get();
		}
		return null;
	}
	@GetMapping("tim/{key}")
	public  Iterable<nhan_vien> NhanVienByName(@PathVariable("key") String key) {
		if(key != null) {
			return nvRep.NvByName(key);
		}
		System.out.print(nvRep.NvByName(key));
		return nvRep.findAll();
	}
	//Them Lsp
		@PostMapping(consumes="application/json")
		@ResponseStatus(HttpStatus.CREATED)
		public nhan_vien postNv(@RequestBody nhan_vien nv) {
			nvRep.save(nv);
			return nv;
		} 
	// Sửa Lsp
		@PostMapping(consumes="application/json", path = "/put" )
		public nhan_vien putNv(@RequestBody nhan_vien nv) {
			nvRep.save(nv);// save gì thì trả về đó
			return nv;
		}
	
	@DeleteMapping("/xoa/{id}")
	public void deleteNv(@PathVariable(name = "id") String id) {
	    nvRep.deleteById(id);
	           
	}
}
