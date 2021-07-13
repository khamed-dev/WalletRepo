package com.digital.wallet.mocks;

import com.digital.wallet.models.Card;
import com.digital.wallet.models.Customer;
import com.digital.wallet.models.Transaction;
import com.digital.wallet.models.Wallet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MockData {

    public static List<Customer> customerList(){
        List<Customer> customers = Arrays.asList(
                new Customer(1L, "John", "Bull", "bull@gmail.com", 2002, cardList().get(0), Arrays.asList(walletList().get(0), walletList().get(1))),
                new Customer(2L, "Esther", "Mukungu", "mukungu@gmail.com", 2002, cardList().get(0), Arrays.asList(walletList().get(2), walletList().get(3))),
                new Customer(3L, "Joe", "Biden", "biden@gmail.com", 2002, cardList().get(0), Arrays.asList(walletList().get(5), walletList().get(6))),
                new Customer(4L, "Donny", "Trump", "trump@gmail.com", 2002, cardList().get(0), Arrays.asList(walletList().get(7))),
                new Customer(5L, "Barack", "Obama", "obama@gmail.com", 2002, cardList().get(0), Arrays.asList(walletList().get(8))),
                new Customer(6L, "Michelle", "Stone", "stone@gmail.com", 2002, cardList().get(0), Arrays.asList(walletList().get(9))),
                new Customer(7L, "Stone", "Cold", "cold@gmail.com", 2002, cardList().get(0), Arrays.asList(walletList().get(10))),
                new Customer(8L, "Hulk", "Hogan", "hogan@gmail.com", 2002, cardList().get(0), Arrays.asList(walletList().get(11))),
                new Customer(9L, "Bubu", "Harry", "harry@gmail.com", 2002, new Card(), Arrays.asList(walletList().get(12)))
        );

        return customers;
    }

    public static List<Card> cardList(){
        List<Card> cards = Arrays.asList(
                new Card(5399356490908800L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(5399356490908801L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(5399356490908802L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(5399356490908829L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(5399356490908809L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(5399356490908863L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(4456344646467377L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(4456344646467377L, 0011, LocalDate.of(2023, 12, 01) ),
                new Card(4456344646460001L, 0011, LocalDate.of(2023, 12, 01) )
        );
        return cards;
    }

    public  static List<Wallet> walletList(){
        List<Wallet> wallets = Arrays.asList(
                new Wallet(1000),
                new Wallet(2000),
                new Wallet(3000),
                new Wallet(4000),
                new Wallet(5000),
                new Wallet(500),
                new Wallet(0),
                new Wallet(250),
                new Wallet(30),
                new Wallet(790),
                new Wallet(99),
                new Wallet(5000),
                new Wallet(0)
        );
        return wallets;
    }

    public List<Transaction> TransactionList(){
        List<Transaction> transactions = Arrays.asList(
                new Transaction(200, 1, 2, "", LocalDateTime.of(2019, 9, 01, 02, 38)),
                new Transaction(1, 1, 9, "", LocalDateTime.of(2019, 9, 01, 02, 38)),
                new Transaction(20, 4, 2, "", LocalDateTime.of(2019, 10, 01, 02, 38)),
                new Transaction(1000, 6, 8, "", LocalDateTime.of(2019, 10, 01, 02, 38)),
                new Transaction(35, 5, 1, "", LocalDateTime.of(2019, 11, 01, 02, 38)),
                new Transaction(2, 6, 2, "", LocalDateTime.of(2019, 12, 01, 02, 38)),
                new Transaction(2.5F, 5, 7, "", LocalDateTime.of(2020, 01, 01, 02, 38)),
                new Transaction(10.3F, 1, 2, "", LocalDateTime.of(2020, 01, 01, 02, 38)),
                new Transaction(50, 3, 4, "", LocalDateTime.of(2020, 02, 01, 02, 38)),
                new Transaction(500, 5, 6, "", LocalDateTime.of(2020, 03, 01, 02, 38)),
                new Transaction(50, 7, 8, "", LocalDateTime.of(2020, 03, 01, 02, 38)),
                new Transaction(200, 8, 7, "", LocalDateTime.of(2020, 03, 01, 02, 38)),
                new Transaction(200, 7, 6, "", LocalDateTime.of(2020, 04, 01, 02, 38)),
                new Transaction(1500, 6, 5, "", LocalDateTime.of(2020, 05, 01, 02, 38)),
                new Transaction(150, 5, 4, "", LocalDateTime.of(2020, 06, 01, 02, 38)),
                new Transaction(123, 4, 3, "", LocalDateTime.of(2021, 01, 01, 02, 38)),
                new Transaction(200, 3, 2, "", LocalDateTime.of(2021, 02, 01, 02, 38)),
                new Transaction(88, 2, 1, "", LocalDateTime.of(2021, 03, 01, 02, 38)),
                new Transaction(90, 1, 2, "", LocalDateTime.of(2021, 04, 01, 02, 38)),
                new Transaction(76, 4, 2, "", LocalDateTime.of(2021, 06, 01, 02, 38)),
                new Transaction(99.9F, 8, 3, "", LocalDateTime.of(2021, 06, 01, 02, 38)),
                new Transaction(99.99F, 6, 5, "", LocalDateTime.of(2021, 06, 01, 02, 38)),
                new Transaction(22, 3, 2, "", LocalDateTime.of(2021, 06, 01, 02, 38)),
                new Transaction(44, 1, 4, "", LocalDateTime.of(2021, 07, 01, 02, 38)),
                new Transaction(450, 1, 5, "", LocalDateTime.of(2021, 07, 01, 02, 38))
        );

        return transactions;
    }

}
