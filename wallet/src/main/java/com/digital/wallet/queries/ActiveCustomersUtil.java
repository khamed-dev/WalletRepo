package com.digital.wallet.queries;

import com.digital.wallet.mocks.MockData;
import com.digital.wallet.models.Customer;
import com.digital.wallet.models.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface ActiveCustomersUtil {
    // Get the percentage of active customers within the last month
    // criteria: ratio of customers who transacted(received and sent) to the registered total for the previous month registered in percentage
    //make month generic, but for test fix it

    //get all customer wallet transaction tags
    Function<Customer, List<Map.Entry<Customer, Long>>> getWalletIdsPerCustomer = (c) ->
            Stream.of(c)
            .flatMap(cw -> cw.getWallets().stream())
            .collect(Collectors.toMap(wh -> wh.getWalletHolder(), wh -> wh.getWalletId()))
            .entrySet().stream()
            .collect(Collectors.toList());

    //get transactions per month per customer
    TriFunction<List<Transaction>, Long, LocalDateTime, List<Transaction>> getTransactionPerWalletPerMonth = (t, cId, m) ->
            t.stream()
            .filter(mt -> LocalDateTime.of(m.getYear(), m.getMonth(), m.getDayOfMonth(), 0,0).equals(mt.getTransactionDate()))
            .filter(ct -> ct.getWalletSender() == cId || ct.getWalletReciever() == cId)
            .collect(Collectors.toList());

    //get all customers for the set monthly transactions
    TriFunction<List<Customer>, List<Transaction>, LocalDateTime, List<String>> getAllActiveCustomers = (cs, t, m) ->
            cs.stream()
            .flatMap(cI -> getWalletIdsPerCustomer.apply(cI).stream())
            .collect(Collectors.toMap(
                    wh -> wh.getKey(),
                    wh -> getTransactionPerWalletPerMonth.apply(t, wh.getValue(), m)
            )).entrySet().stream()
            .map(c -> c.getKey())
            .map(cp -> cp.getFirstName())
            .distinct()
            .collect(Collectors.toList());


//      static Optional<Integer> ratio(){ //pass this in main, given all customers, transactions, month
//          return Optional.ofNullable(
//                  (getAllActiveCustomers.apply(
//                          getAllCustomers,
//                          getAllTransactions,
//                          LocalDateTime.of(2020,2,1, 0, 0)
//                  ).size() / getAllCustomers.size()) * 100
//          );
//      }

}
