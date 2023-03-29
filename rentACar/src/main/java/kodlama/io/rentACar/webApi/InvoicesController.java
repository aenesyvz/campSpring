package kodlama.io.rentACar.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.rentACar.business.abstracts.InvoiceService;
import kodlama.io.rentACar.business.requests.invoiceRequest.CreateInvoiceRequest;
import kodlama.io.rentACar.business.requests.invoiceRequest.UpdateInvoiceRequest;
import kodlama.io.rentACar.business.responses.invoiceResponse.GetByIdInvoiceResponse;
import kodlama.io.rentACar.business.responses.invoiceResponse.GetListInvoiceResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/invoices")
public class InvoicesController {
	private InvoiceService invoiceService;

	@Autowired
	public InvoicesController(InvoiceService invoiceService) {
		super();
		this.invoiceService = invoiceService;
	}
	
	@GetMapping("/getAll")
	public List<GetListInvoiceResponse> getAll(){
		return this.invoiceService.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public GetByIdInvoiceResponse getById(@PathVariable int id) {
		return this.invoiceService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() CreateInvoiceRequest createInvoiceRequest) {
		this.invoiceService.add(createInvoiceRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() UpdateInvoiceRequest updateInvoiceRequest) {
		this.invoiceService.update(updateInvoiceRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.invoiceService.delete(id);
	}
	
}
