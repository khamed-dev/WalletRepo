package com.digital.wallet.queries;

import com.digital.wallet.mocks.MockData;
import com.digital.wallet.models.Customer;
import com.digital.wallet.models.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Main {
    static LocalDateTime test = LocalDateTime.of(2020,2,1,0,0);

    static Optional<Integer> ratio(List cust, List transact, LocalDateTime m){ //pass this in main, given all customers, transactions, month
        return Optional.ofNullable(
                (ActiveCustomersUtil.getAllActiveCustomers.apply(
                        cust,
                        transact,
                        m
                ).size() / cust.size()) * 100
        );
    }

    public static void main(String[] args) {
        List<Customer> getAllCustomers = MockData.customerList();
        List<Transaction> getAllTransactions = MockData.TransactionList();

        System.out.println(ratio(getAllCustomers, getAllTransactions, test));

    }
}
