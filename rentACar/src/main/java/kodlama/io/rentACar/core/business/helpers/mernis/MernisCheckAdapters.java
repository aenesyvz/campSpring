package kodlama.io.rentACar.core.business.helpers.mernis;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.results.ErrorResult;
import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessResult;
import kodlama.io.rentACar.entities.concretes.IndividualCustomer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckAdapters implements MernisCheckService{

	@Override
	public Result checkIfRealPerson(IndividualCustomer individualCustomer) {
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		boolean result=false;
		try {
			result=client.TCKimlikNoDogrula(
						Long.valueOf(individualCustomer.getNationalityIdentity()), 
						individualCustomer.getFirstName(), 
						individualCustomer.getLastName(), 
						individualCustomer.getDateOfBirth().getYear());
		} catch (NumberFormatException e) {
			return new ErrorResult("fsgf");
		} catch (RemoteException e) {
			return new ErrorResult("Mernis doğrulaması yapılamadı!");
		}
		return result ? new SuccessResult():new ErrorResult("Lütfen bilgilerinizi kontrol ediniz");
	}

}