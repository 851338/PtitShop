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
@RequestMapping("/nv")
public class NhanVienController {
	private RestTemplate rest = new RestTemplate();
	@GetMapping()
	public String getListNV(Model model) {
		nhan_vien nv = new nhan_vien();
	    model.addAttribute("nv", nv);
		List<nhan_vien> listNv = 
				Arrays.asList(rest.getForObject("http://localhost:8083/nv",nhan_vien[].class));
	    model.addAttribute("listNv", listNv);
		return "home";
	}
	@GetMapping("/them")
	public String showNewLspPage(Model model) {
	    nhan_vien nv = new nhan_vien();
	    model.addAttribute("nv", nv);
	    return "themLsp";
	}
	@GetMapping("/sua/{id}")
	public ModelAndView editNv(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("editNv");
		nhan_vien nv = rest.getForObject("http://localhost:8083/nv/{id}",nhan_vien.class, id);
	    mav.addObject("nv", nv);
	    return mav;
	}
	@GetMapping("/xoa/{id}")
	public String deleteNv(@PathVariable(name = "id") String id) {
		rest.delete("http://localhost:8083/nv/xoa/{id}", id);
		return "redirect:/nv";
	}

	@PostMapping
	public String saveNv(@ModelAttribute("nv") nhan_vien nv) {
		nv.setNgay_tao(new Timestamp(System.currentTimeMillis()));
		nv.setId("2");
		rest.postForObject("http://localhost:8083/nv",nv, nhan_vien.class);
	    return "redirect:/nv";
	    
	}
	@PostMapping("/sua")
	public String saveEditCar(@ModelAttribute("nv") nhan_vien nv) {
		rest.postForObject("http://localhost:8083/nv/put",nv, nhan_vien.class);
	    return "redirect:/nv";
	    
	}
	
}
