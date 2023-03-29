package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.InvoiceService;
import kodlama.io.rentACar.business.requests.invoiceRequest.CreateInvoiceRequest;
import kodlama.io.rentACar.business.requests.invoiceRequest.UpdateInvoiceRequest;
import kodlama.io.rentACar.business.responses.invoiceResponse.GetByIdInvoiceResponse;
import kodlama.io.rentACar.business.responses.invoiceResponse.GetListInvoiceResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.InvoiceRepository;
import kodlama.io.rentACar.entities.concretes.Invoice;

@Service
public class InvoiceManager implements InvoiceService{
	private ModelMapperService modelMapperService;
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	public InvoiceManager(ModelMapperService modelMapperService, InvoiceRepository invoiceRepository) {
		super();
		this.modelMapperService = modelMapperService;
		this.invoiceRepository = invoiceRepository;
	}

	@Override
	public List<GetListInvoiceResponse> getAll() {
		List<Invoice> invoices = this.invoiceRepository.findAll();
		List<GetListInvoiceResponse> listResponse = invoices.stream()
				.map(invoice -> this.modelMapperService.forResponse()
						.map(invoice, GetListInvoiceResponse.class)).collect(Collectors.toList());
		
		return listResponse;
	}

	@Override
	public GetByIdInvoiceResponse getById(int id) {
		Optional<Invoice> invoice = this.invoiceRepository.findById(id);
		GetByIdInvoiceResponse response = this.modelMapperService.forResponse().map(invoice.get(), GetByIdInvoiceResponse.class);
		
		return response;
	}

	@Override
	public void add(CreateInvoiceRequest createInvoiceRequest) {
		Invoice invoice = this.modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);
		this.invoiceRepository.save(invoice);
	}

	@Override
	public void update(UpdateInvoiceRequest updateInvoiceRequest) {
		Invoice invoice = this.modelMapperService.forRequest().map(updateInvoiceRequest, Invoice.class);
		this.invoiceRepository.save(invoice);
	}

	@Override
	public void delete(int id) {
		this.invoiceRepository.deleteById(id);
		
	}
	
}
