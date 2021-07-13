package com.digital.wallet.fpqueries;

import com.digital.wallet.mocks.MockData;
import com.digital.wallet.models.Customer;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@ServiceInterface
public interface CustomerFP {
    Function<> getCustomer = () ->
            MockData.customerList().stream()
            .filter(x -> x.getEmail() != null)
            .collect(Collectors.toList());

}
