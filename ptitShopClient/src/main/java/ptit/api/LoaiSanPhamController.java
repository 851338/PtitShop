package ptit.api;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;
import ptit.loai_sp;
import ptit.nhan_vien;


@Controller
@RequestMapping("/lsp")
public class LoaiSanPhamController {
	private RestTemplate rest = new RestTemplate();
	@GetMapping()
	public String getListCar(Model model) {
		loai_sp lsp = new loai_sp();
	    model.addAttribute("lsp", lsp);
		List<loai_sp> listLsp = 
				Arrays.asList(rest.getForObject("http://localhost:8083/lsp",loai_sp[].class));
	    model.addAttribute("listLsp", listLsp);
	    nhan_vien nv = new nhan_vien();
	    model.addAttribute("nv", nv);
		List<nhan_vien> listNv = 
				Arrays.asList(rest.getForObject("http://localhost:8083/nv",nhan_vien[].class));
	    model.addAttribute("listNv", listNv);
		return "home";
	}
	@GetMapping("/timNv/{key}")
	public String findNvbyKey(@PathVariable(name = "key") String key, Model model) {
		loai_sp lsp = new loai_sp();
	    model.addAttribute("lsp", lsp);
		List<loai_sp> listLsp = 
				Arrays.asList(rest.getForObject("http://localhost:8083/lsp",loai_sp[].class));
	    model.addAttribute("listLsp", listLsp);
	    nhan_vien nv = new nhan_vien();
	    model.addAttribute("nv", nv);
		model.addAttribute("key", key);
		List<nhan_vien> listNv = Arrays
				.asList(rest.getForObject("http://localhost:8083/nv/tim/{key}", nhan_vien[].class, key));
		System.out.print(key);
		model.addAttribute("listNv", listNv);

		return "home";
	}
	
	@GetMapping("/them")
	public String showNewLspPage(Model model) {
	    loai_sp lsp = new loai_sp();
	    model.addAttribute("lsp", lsp);
	    return "themLsp";
	}
	@GetMapping("/sua/{id}")
	public ModelAndView editLsp(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("edit_kindProduct");
		loai_sp lsp = rest.getForObject("http://localhost:8083/lsp/{id}",loai_sp.class, id);
	    mav.addObject("lsp", lsp);
	    return mav;
	}
	@GetMapping("/suaNv/{id}")
	public ModelAndView editNv(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("edit_Employee");
		nhan_vien nv = rest.getForObject("http://localhost:8083/nv/{id}",nhan_vien.class, id);
	    mav.addObject("nv", nv);
	    return mav;
	}
	@GetMapping("/xoa/{id}")
	public String deleteLsp(@PathVariable(name = "id") String id) {
		rest.delete("http://localhost:8083/lsp/xoa/{id}", id);
		return "redirect:/lsp";
	}
	@GetMapping("/xoaNv/{id}")
	public String deleteNv(@PathVariable(name = "id") String id) {
		rest.delete("http://localhost:8083/nv/xoa/{id}", id);
		return "redirect:/lsp";
	}

	@PostMapping
	public String saveLsp(@ModelAttribute("lsp") loai_sp lsp) {
		lsp.setNgay_tao(new Timestamp(System.currentTimeMillis()));
		
		rest.postForObject("http://localhost:8083/lsp",lsp, loai_sp.class);
		
	    return "redirect:lsp";
	    
	}
	@PostMapping("/nv")
	public String saveNv(@ModelAttribute("nv") nhan_vien nv) {
		
		nv.setNgay_tao(new Timestamp(System.currentTimeMillis()));
		
		
		rest.postForObject("http://localhost:8083/nv",nv, nhan_vien.class);
	    return "redirect:/lsp";
	    
	}
	@PostMapping("/sua")
	public String saveEditKindProduct(@ModelAttribute("lsp") loai_sp lsp, Model model) {
		lsp.setNgay_tao(new Timestamp(System.currentTimeMillis()));
		rest.postForObject("http://localhost:8083/lsp/put",lsp, loai_sp.class);
	    return "redirect:/lsp";
	    
	}
	@PostMapping("/suaNv")
	public String saveEditEmployee(@ModelAttribute("nv") nhan_vien nv, Model model) {
		nv.setNgay_tao(new Timestamp(System.currentTimeMillis()));
		rest.postForObject("http://localhost:8083/nv/put",nv, nhan_vien.class);
	    return "redirect:/lsp";
	    
	}
	

}
