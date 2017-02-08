package com.ktds.ehm;

import com.ktds.ehm.biz.BicycleShopBiz;
import com.ktds.ehm.biz.BicycleShopBizImpl;

public class BicycleShopMain {
	public void start() {
		BicycleShopBiz bicycleShopBiz = new BicycleShopBizImpl();
		bicycleShopBiz.rent();
	}

	public static void main(String[] args) {
		new BicycleShopMain().start();
	}
}
