package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.invoiceRequest.CreateInvoiceRequest;
import kodlama.io.rentACar.business.requests.invoiceRequest.UpdateInvoiceRequest;
import kodlama.io.rentACar.business.responses.invoiceResponse.GetByIdInvoiceResponse;
import kodlama.io.rentACar.business.responses.invoiceResponse.GetListInvoiceResponse;
@Service
public interface InvoiceService {
	List<GetListInvoiceResponse> getAll();
	GetByIdInvoiceResponse getById(int id);
	void add(CreateInvoiceRequest createInvoiceRequest);
	void update(UpdateInvoiceRequest updateInvoiceRequest);
	void delete(int id);
}
