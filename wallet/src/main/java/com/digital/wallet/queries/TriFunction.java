package com.digital.wallet.queries;

public interface TriFunction <X,Y,Z,R>{
    R apply(X x, Y y, Z z);
}
