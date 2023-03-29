package kodlama.io.rentACar.core.business.helpers.mernis;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.entities.concretes.IndividualCustomer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckAdapters implements MernisCheckService{

	@Override
	public boolean checkIfRealPerson(IndividualCustomer individualCustomer) {
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		boolean result=false;
		try {
			result=client.TCKimlikNoDogrula(
						Long.valueOf(individualCustomer.getNationalityIdentity()), 
						individualCustomer.getFirstName(), 
						individualCustomer.getLastName(), 
						individualCustomer.getDateOfBirth().getYear());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}