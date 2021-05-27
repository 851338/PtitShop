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

import ptit.loai_sp;
import ptit.Data.LoaiSanPhamRep;

@RestController
@RequestMapping(path = "/lsp", produces = "application/json")
@CrossOrigin(origins = "*")
public class LoaiSanPhamController {
	private LoaiSanPhamRep lspRep;
	@Autowired
	EntityLinks entityLinks;
	
	public LoaiSanPhamController(LoaiSanPhamRep lspRep) {
		this.lspRep = lspRep;
	}

	@GetMapping
	public Iterable<loai_sp> getLsp() {

		// PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
		return lspRep.findAll();
	}

	@GetMapping("/{id}")
	public loai_sp LspById(@PathVariable("id") String id) {
		Optional<loai_sp> optLsp = lspRep.findById(id);
		if (optLsp.isPresent()) {
			return optLsp.get();
		}
		return null;
	}

	//Them Lsp
		@PostMapping(consumes="application/json")
		@ResponseStatus(HttpStatus.CREATED)
		public loai_sp postLsp(@RequestBody loai_sp lsp) {
			lspRep.save(lsp);
			return lsp;
		} 
	// Sửa Lsp
		@PostMapping(consumes="application/json", path = "/put" )
		public loai_sp putLsp(@RequestBody loai_sp lsp) {
			lspRep.save(lsp);// save gì thì trả về đó
			return lsp;
		}
	
	@DeleteMapping("/xoa/{id}")
	public void deleteLsp(@PathVariable(name = "id") String id) {
	    lspRep.deleteById(id);
	           
	}
}
