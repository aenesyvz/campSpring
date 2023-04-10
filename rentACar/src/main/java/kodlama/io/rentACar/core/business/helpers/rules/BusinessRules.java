package kodlama.io.rentACar.core.business.helpers.rules;

import kodlama.io.rentACar.core.utilities.results.Result;
import kodlama.io.rentACar.core.utilities.results.SuccessResult;

public class BusinessRules {
	 public static Result run(Result... logics)
    {
        for (Result result : logics)
        {
            if (!result.isSuccess())
            {
                return result;
            }
        }

        return new SuccessResult();
    }
}