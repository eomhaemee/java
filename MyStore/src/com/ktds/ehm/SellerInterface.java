package com.ktds.ehm;

import com.ktds.ehm.buyer.Buyer;

public interface SellerInterface {

	public void sell(Buyer buyer);

	public boolean isSoldOut();
}
